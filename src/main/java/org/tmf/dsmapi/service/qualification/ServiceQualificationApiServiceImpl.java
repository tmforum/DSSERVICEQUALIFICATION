package org.tmf.dsmapi.service.qualification;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.tmf.dsmapi.NotFoundException;
import org.tmf.dsmapi.ServiceQualificationApiService;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.Jackson;
import org.tmf.dsmapi.commons.utils.URIParser;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationReqEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationReqItemEntity;
import org.tmf.dsmapi.service.qualification.event.ServiceQualificationEventPublisherLocal;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationItemRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceReq;
import org.tmf.dsmapi.service.qualification.template.Template;
import org.tmf.dsmapi.service.qualification.template.TemplateFactory;
import org.tmf.dsmapi.service.qualification.template.TemplateNotFoundException;

@Stateless
public class ServiceQualificationApiServiceImpl implements ServiceQualificationApiService {

    @EJB
    ServiceQualificationReqFacade serviceQualificationReqFacade;

    @Resource
    private SessionContext sessionContext;

    @EJB
    private ServiceQualificationEventPublisherLocal publisher;

    @Override
    public Response serviceQualificationFind(String id, SecurityContext securityContext, UriInfo info) throws NotFoundException {
        return Response.ok(serviceQualificationReqFacade.findAll()).build();
    }

    @Override
    public Response serviceQualificationCreate(ServiceQualificationReq req, SecurityContext securityContext, UriInfo info) throws NotFoundException {
        if (req == null) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }
        ServiceQualificationReqEntity serviceQualificationReqEntity = new ServiceQualificationReqEntity();
        serviceQualificationReqEntity.setQualificationState(ServiceQualificationRsp.QualificationStateEnum.DONE);
        Date now = new Date();
        serviceQualificationReqEntity.setInteractionDate(now);
        serviceQualificationReqEntity.setEligibilityDate(now);
        serviceQualificationReqEntity.setAddress(ServiceQualificationConverter.convert(req.getAddress()));

        List<ServiceQualificationItemRsp> itemRspList = null;
        try {

            itemRspList = renderServiceQualificationRsp(serviceQualificationReqEntity);
            serviceQualificationReqFacade.create(serviceQualificationReqEntity);
            serviceQualificationReqEntity.setHref(info.getAbsolutePath() + "/" + serviceQualificationReqEntity.getId());
            serviceQualificationReqFacade.edit(serviceQualificationReqEntity);

            publisher.createNotification(serviceQualificationReqEntity, now);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }

        ServiceQualificationRsp rsp = ServiceQualificationConverter.convert(serviceQualificationReqEntity);
        rsp.setServiceQualificationItem(itemRspList);

        // 201 OK
        return Response.created(null).
                entity(rsp).
                build();
    }

    @Override
    public Response serviceQualificationGet(String id, String fields, SecurityContext securityContext, UriInfo info) throws NotFoundException {
        try {
            // search queryParameters
            MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

            Map<String, List<String>> mutableMap = new HashMap();
            for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
                mutableMap.put(e.getKey(), e.getValue());
            }

            // fields to filter view
            Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);

            ServiceQualificationReqEntity req = serviceQualificationReqFacade.find(id);
            List<ServiceQualificationItemRsp> itemRspList = null;
            try {
                itemRspList = renderServiceQualificationRsp(req);
            } catch (Exception ex) {
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
            }

            Response response;
            ServiceQualificationRsp rsp = req.convert();
            rsp.setServiceQualificationItem(itemRspList);
            if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
                response = Response.ok(rsp).build();
            } else {
                fieldSet.add(URIParser.ID_FIELD);
                ObjectNode node = Jackson.createNode(rsp, fieldSet);
                response = Response.ok(node).build();
            }
            return response;

        } catch (UnknownResourceException ex) {
            Logger.getLogger(ServiceQualificationApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     *
     * @param req
     * @return
     * @throws Exception
     */
    private List<ServiceQualificationItemRsp> renderServiceQualificationRsp(ServiceQualificationReqEntity req) throws Exception {
        String templateName;
        Template template;
        ServiceReq serviceReq;
        List<ServiceQualificationItemRsp> itemRspList = null;
        List<ServiceQualificationReqItemEntity> items = req.getServiceQualificationItem();

        String serviceCategoryId;
        for (ServiceQualificationReqItemEntity item : items) {
            if (item == null) {
                continue;
            }
            serviceReq = ServiceQualificationConverter.convert(item.getService());
            if (serviceReq == null) {
                continue;
            }

            if (item.getService().getServiceSpecification() != null) {
                serviceCategoryId = item.getService().getServiceSpecification().getServiceCategoryId();
            } else {
                serviceCategoryId = "internetService";
            }

            templateName = TemplateFactory.getInstance().getTemplateName(serviceCategoryId);
            if (templateName != null) {
                template = (Template) sessionContext.lookup("java:module/" + templateName);
                if (template != null) {
                    itemRspList = template.mactch(ServiceQualificationConverter.convertSQRequest(req), serviceReq);
                }
            } else {
                throw new TemplateNotFoundException();
            }
        }
        return itemRspList;
    }

}
