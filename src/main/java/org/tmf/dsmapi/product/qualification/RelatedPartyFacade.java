/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.product.qualification;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import org.tmf.dsmapi.product.qualification.entity.RelatedParty;

/**
 *
 * @author Lin
 */
@Stateless
public class RelatedPartyFacade extends AbstractFacade<RelatedParty> {
    
    @PersistenceContext(unitName = "DSServiceQualificationPU")
    private EntityManager em;
    
     /**
     * 
     * @param href
     * @return 
     */
    public RelatedParty findByHref(String href) {
        String sqlStr = "select a from RelatedParty a where a.href = :href";
        Query query = em.createQuery(sqlStr);
        query.setParameter("href", href);
        
        List<RelatedParty> relatedPartyList = (List<RelatedParty>)query.getResultList();
        if(relatedPartyList != null && relatedPartyList.size() > 0) {
            return relatedPartyList.get(0);
        }
        return null;
    }
    
    /**
     * 
     */
    public RelatedPartyFacade() {
        super(RelatedParty.class);
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
