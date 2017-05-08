///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.tmf.dsmapi.product.qualification;
//
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.UriInfo;
//import org.tmf.dsmapi.commons.exceptions.BadUsageException;
//import org.tmf.dsmapi.commons.exceptions.ExceptionType;
//import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
//import org.tmf.dsmapi.commons.utils.Jackson;
//import org.tmf.dsmapi.commons.utils.URIParser;
//import org.tmf.dsmapi.product.qualification.entity.OrderFeasibilityCheck;
//import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualification;
//import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationItem;
//import org.tmf.dsmapi.product.qualification.entity.RelatedParty;
//import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationReqEntity;
//import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationReqItemEntity;
//import org.tmf.dsmapi.product.qualification.entity.RelatedPartyReqEntity;
//import org.tmf.dsmapi.product.qualification.rsp.ProductOfferingQualificationRsp;
//import org.tmf.dsmapi.service.qualification.AddressFacade;
//import org.tmf.dsmapi.service.qualification.ServiceQualificationConverter;
//import org.tmf.dsmapi.service.qualification.event.ProductOfferingQualificationEventPublisherLocal;
//import org.tmf.dsmapi.service.qualification.enity.AddressEntity;
//import org.tmf.dsmapi.service.qualification.model.AddressReq;
//import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRsp.QualificationStateEnum;
//
///**
// *
// * @author Lin
// */
//@Stateless
//@Path("/v1/productOfferingQualification")
//public class ProductOfferingQualificationResource {
//
//    @EJB
//    ProductOfferingQualificationFacade qulificationFacade;
//
//    @EJB
//    ProductOfferingQualificationReqFacade qulificationReqFacade;
//    
//    @EJB
//    AddressFacade addressFacade;
//    
//    @EJB
//    RelatedPartyFacade relatedPartyFacade;
//    
//    @EJB
//    ProductOfferingQualificationEventPublisherLocal publisher;
//
//    @POST
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public Response post(ProductOfferingQualificationReqEntity req, @Context UriInfo info) throws UnknownResourceException {
//        if (req == null) {
//            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
//        }
//        ProductOfferingQualificationRsp rsp;
//        try {
//            checkRequest(req);
//            rsp = renderRsp(req);
//            qulificationReqFacade.create(req);
//            req.setHref(info.getAbsolutePath() + "/" + req.getId());
//            qulificationReqFacade.edit(req);
//            
//            publisher.createNotification(req, new Date());
//            
//            rsp.setId(req.getId());
//            rsp.setHref(req.getHref());
//            Date now = new Date();
//            rsp.setEligibilityDate(now);
//        } catch (Exception e) {
//            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
//        }
//        
//        // 201 OK
//        return Response.created(null).
//                entity(rsp).
//                build();
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({"application/json"})
//    public Response get(@PathParam("id") String id, @Context UriInfo info) throws UnknownResourceException {
//
//        // search queryParameters
//        MultivaluedMap<String, String> queryParameters = info.getQueryParameters();
//
//        Map<String, List<String>> mutableMap = new HashMap();
//        for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
//            mutableMap.put(e.getKey(), e.getValue());
//        }
//
//        // fields to filter view
//        Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);
//
//        ProductOfferingQualificationReqEntity req = qulificationReqFacade.find(id);
//        ProductOfferingQualificationRsp rsp;
//        try {
//            rsp = renderRsp(req);
//            rsp.setId(req.getId());
//            rsp.setHref(req.getHref());
//            Date now = new Date();
//            rsp.setEligibilityDate(now);
//        } catch (Exception ex) {
//            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
//        }
//        Response response;
//        if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
//            response = Response.ok(rsp).build();
//        } else {
//            fieldSet.add(URIParser.ID_FIELD);
//            ObjectNode node = Jackson.createNode(rsp, fieldSet);
//            response = Response.ok(node).build();
//        }
//        return response;
//    }
//    
//    
//    /**
//     * 
//     * @param req
//     * @throws BadUsageException
//     * @throws UnknownResourceException 
//     */
//    private void checkRequest(ProductOfferingQualificationReqEntity req) throws BadUsageException, UnknownResourceException {
//        List<RelatedPartyReqEntity> relatedParty = req.getRelatedParty();
//        if(relatedParty == null || relatedParty.size() <= 0) {
//            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "relatedParty is mandatory");
//        }
//        
//        List<ProductOfferingQualificationReqItemEntity> itemList = req.getProductOfferingQualificationItem();
//        if(itemList == null || itemList.size() <= 0) {
//             throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "productOfferingQualificationItem is mandatory");
//        }
//        
//        AddressReq addressReq = ServiceQualificationConverter.convert(req.getAddress());
//        if(addressReq != null) {
//            if(addressReq.getHref() == null) {
//                throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "address.href is mandatory");
//            }
//        }
//    }
//
//    /**
//     * 
//     * @param req
//     * @return 
//     */
//    private ProductOfferingQualificationRsp renderRsp(ProductOfferingQualificationReqEntity req) {
//        
//        ProductOfferingQualificationRsp rsp = req.convertRsp();
//        List<ProductOfferingQualification> qualificationList;
//        List<ProductOfferingQualification> existQualificationList;
//        Map<String, ProductOfferingQualificationItem> itemCollection = new HashMap<>();
//        qualificationList = convertList(req);
//
//        List<ProductOfferingQualificationItem> itemList = new ArrayList<>();
//        for (ProductOfferingQualification qualification : qualificationList) {
//            existQualificationList = qulificationFacade.findByCriteria(qualification);
//            if (existQualificationList == null || existQualificationList.size() <= 0) {
//                continue;
//            }
//            for (ProductOfferingQualification exsitQualification : existQualificationList) {
//                if (exsitQualification == null || exsitQualification.getProductOfferingQualificationItem() == null) {
//                    continue;
//                }
//                for (ProductOfferingQualificationItem qItem : exsitQualification.getProductOfferingQualificationItem()) {
//                    if (qItem == null || qItem.getProductOffering() == null || qItem.getProductOffering().getHref() == null) {
//                        continue;
//                    }
//                    if (!itemCollection.containsKey(qItem.getProductOffering().getHref())) {
//                        qItem.setOrderFeasibilityCheck(new OrderFeasibilityCheck());
//                        itemCollection.put(qItem.getProductOffering().getHref(), qItem);
//                        itemList.add(qItem);
//                    }
//                }
//            }
//        }
//        rsp.setProductOfferingQualificationItem(itemList);
//        rsp.setQualificationState(QualificationStateEnum.DONE);
//        
//        return rsp;
//    }
//    
//    /**
//     * 
//     * @param req
//     * @return 
//     */
//    private List<ProductOfferingQualification> convertList(ProductOfferingQualificationReqEntity req) {
//        List<ProductOfferingQualification> qualificationList = null;
//        if (req.getRelatedParty() == null || req.getRelatedParty().isEmpty()) {
//            return qualificationList;
//        }
//        AddressEntity existAddress = null;
//        if(req.getAddress() != null && req.getAddress().getHref() != null)  {
//            existAddress = addressFacade.findByHref(req.getAddress().getHref());
//            if(existAddress == null) {
//                return qualificationList;
//            }
//        }
//        //TODO AddressDescrition GeoCode ...
//        
//        qualificationList = new ArrayList<>();
//        ProductOfferingQualification qualification;
//        RelatedParty existParty;
//        
//        for (RelatedPartyReqEntity party : req.getRelatedParty()) {
//            qualification = req.convert();
//            if (party != null && party.getHref() != null) {
//                existParty = relatedPartyFacade.findByHref(party.getHref());
//                if(existParty != null) {
//                    qualification.setRelatedPartyId(existParty.getId());
//                } else {
//                    continue;
//                }
//            }
//            if(existAddress != null) {
//                qualification.setAddressId(existAddress.getId());
//            }
//            qualificationList.add(qualification);
//        }
//        return qualificationList;
//    }
//
//}
