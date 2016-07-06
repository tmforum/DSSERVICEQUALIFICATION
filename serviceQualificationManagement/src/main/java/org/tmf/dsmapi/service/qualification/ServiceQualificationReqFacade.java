/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import org.tmf.dsmapi.service.qualification.req.ServiceQualificationReq;

/**
 *
 * @author Lin
 */
@Stateless
public class ServiceQualificationReqFacade extends AbstractFacade<ServiceQualificationReq>  {
    @PersistenceContext(unitName = "DSServiceQualificationPU")
    private EntityManager em;
    
    
     /**
     * 
     */
    public ServiceQualificationReqFacade() {
        super(ServiceQualificationReq.class);
    }
    
    /**
     * 
     * @return  EntityManager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
