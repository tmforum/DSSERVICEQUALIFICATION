/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.product.qualification;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import org.tmf.dsmapi.product.qualification.req.ProductOfferingQualificationReq;

/**
 *
 * @author Lin
 */
@Stateless
public class ProductOfferingQualificationReqFacade extends AbstractFacade<ProductOfferingQualificationReq> {

    @PersistenceContext(unitName = "DSServiceQualificationPU")
    private EntityManager em;

    /**
     *
     */
    public ProductOfferingQualificationReqFacade() {
        super(ProductOfferingQualificationReq.class);
    }

    /**
     *
     * @return EntityManager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
