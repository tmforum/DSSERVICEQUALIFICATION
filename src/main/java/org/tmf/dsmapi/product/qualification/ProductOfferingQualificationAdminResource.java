/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.product.qualification;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.jaxrs.Report;
import org.tmf.dsmapi.product.qualification.model.ProductOfferingQualification;
import org.tmf.dsmapi.product.qualification.model.RelatedParty;
import org.tmf.dsmapi.product.qualification.req.ProductOfferingQualificationReq;
import org.tmf.dsmapi.product.qualification.req.RelatedPartyReq;
import org.tmf.dsmapi.service.qualification.AddressFacade;
import org.tmf.dsmapi.service.qualification.model.Address;
import org.tmf.dsmapi.service.qualification.req.AddressReq;

/**
 *
 * @author Lin
 */
@Stateless
@Path("/admin/v1/productOfferingQualification")
public class ProductOfferingQualificationAdminResource {
    
    @EJB
    ProductOfferingQualificationFacade productOfferingQualificationFacade;
    
    @EJB
    AddressFacade addressFacade;
    
    @EJB
    RelatedPartyFacade relatedPartyFacade;
    
    /**
     *
     * For test purpose only
     * @param entities
     * @return
     */
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response post(List<ProductOfferingQualificationReq> entities, @Context UriInfo info) throws UnknownResourceException {
       if (entities == null) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
       }
        
        int previousRows = productOfferingQualificationFacade.count();
        int affectedRows=0;
        
        ProductOfferingQualification prodOfferingQualification;
        List<RelatedPartyReq> relatedPartyList;
        RelatedParty existRelatedParty = null;
        String addressId = null;
        try {
            for (ProductOfferingQualificationReq entitie : entities) { 
                
                if(entitie.getRelatedParty() == null || entitie.getRelatedParty().size() <= 0) {
                    continue;
                }
                
                AddressReq address = entitie.getAddress();
                if(address != null) {
                    Address existAddress = null;
                    if(address.getId() != null) {
                        existAddress = addressFacade.find(address.getId());
                    } else if(address.getHref() != null) {
                        existAddress = addressFacade.findByHref(address.getHref());
                    }
                    if(existAddress == null) {
                        Address newAddress = new Address();
                        newAddress.setHref(address.getHref());
                        addressFacade.create(newAddress);
                        addressId = newAddress.getId();
                    } else {
                        addressId = existAddress.getId();
                    }
                }
                relatedPartyList = entitie.getRelatedParty();
                if(relatedPartyList != null && !relatedPartyList.isEmpty()) {
                    for(RelatedPartyReq relatedParty: relatedPartyList) {
                        prodOfferingQualification = entitie.convert();
                        prodOfferingQualification.setAddressId(addressId);
                        if(relatedParty.getId() != null) {
                            existRelatedParty = relatedPartyFacade.find(relatedParty.getId());
                        } else if(relatedParty.getHref() != null) {
                            existRelatedParty = relatedPartyFacade.findByHref(relatedParty.getHref());
                        }
                        
                        if(existRelatedParty == null) { 
                            RelatedParty newRelatedParty = relatedParty.convert();
                            relatedPartyFacade.create(newRelatedParty);
                            prodOfferingQualification.setRelatedPartyId(newRelatedParty.getId());
                        } else {
                            prodOfferingQualification.setRelatedPartyId(existRelatedParty.getId());
                        }
                        
                        productOfferingQualificationFacade.create(prodOfferingQualification);
                        prodOfferingQualification.setHref(info.getAbsolutePath() + "/" + prodOfferingQualification.getId());
                        productOfferingQualificationFacade.edit(prodOfferingQualification);
                        affectedRows = affectedRows + 1;
                    }
                }
                
                
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).build();
        }

        Report stat = new Report(productOfferingQualificationFacade.count());
        stat.setAffectedRows(affectedRows);
        stat.setPreviousRows(previousRows);

        // 201 OK
        return Response.created(null).
                entity(stat).
                build();
    }
    
}
