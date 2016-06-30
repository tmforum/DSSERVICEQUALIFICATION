/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.jaxrs.Report;
import org.tmf.dsmapi.service.qualification.model.Address;
import org.tmf.dsmapi.service.qualification.model.ServiceQualification;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRelation;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;
import org.tmf.dsmapi.service.qualification.template.Template;
import org.tmf.dsmapi.service.qualification.template.TemplateFactory;

/**
 *
 * @author Lin
 */
@Stateless
@Path("/admin/v1/serviceQualification")
public class ServiceQualificationAdminResource {
    @EJB
    ServiceQualificationFacade serviceQualificationFacade;
    
    @EJB
    AddressFacade addressFacade;
    
    @Resource
    private SessionContext sessionContext; 
    
    
    @GET
    @Produces({"application/json"})
    public List<ServiceQualification> findAll() {
        return serviceQualificationFacade.findAll();
    }
    
     /**
     *
     * For test purpose only
     * @param entities
     * @return
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response post(List<ServiceQualificationRelation> entities, @Context UriInfo info) throws UnknownResourceException {

        if (entities == null) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }
        

        int previousRows = serviceQualificationFacade.count();
        int affectedRows=0;
        
        String serviceCategoryId;
        String templateName;
        Template template;
        ServiceQualification serviceQualification;
        try {
            for (ServiceQualificationRelation entitie : entities) { 
                serviceQualification = entitie.convert();
                Address address = entitie.getAddress();
                if(address != null) {
                    Address existAddress = null;
                    if(address.getId() != null) {
                        existAddress = addressFacade.find(address.getId());
                    } else if(address.getHref() != null) {
                        existAddress = addressFacade.findByHref(address.getHref());
                    }
                    if(existAddress == null) {
                        addressFacade.create(address);
                        serviceQualification.setAddressId(address.getId());
                    } else {
                        serviceQualification.setAddressId(existAddress.getId());
                    }
                }
                
                List<ServiceSpecification> servSpecEntities = serviceQualification.getServiceSpecification();
                for(ServiceSpecification servSpec: servSpecEntities) {
                    serviceCategoryId = servSpec.getServiceCategoryId();
                    templateName  = TemplateFactory.getInstance().getTemplateName(serviceCategoryId);
                    if(templateName != null) {
                        template = (Template)sessionContext.lookup("java:module/"+templateName);
                        if(template != null) {
                            template.prepare(servSpec);
                        }
                    }
                }
                serviceQualificationFacade.create(serviceQualification);
                serviceQualification.setHref(info.getAbsolutePath() + "/" + serviceQualification.getId());
                serviceQualificationFacade.edit(serviceQualification);
                affectedRows = affectedRows + 1;
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }

        Report stat = new Report(serviceQualificationFacade.count());
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        // 201 OK
        return Response.created(null).
                entity(stat).
                build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response update(@PathParam("id") String id, ServiceQualification entity) throws UnknownResourceException {
        Response response = null;
        ServiceQualification serviceQualification = serviceQualificationFacade.find(id);
        if (serviceQualification != null) {
            entity.setId(id);
            serviceQualificationFacade.edit(entity);
            // 200 OK + location
            response = Response.status(Response.Status.OK).entity(entity).build();

        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }
}
