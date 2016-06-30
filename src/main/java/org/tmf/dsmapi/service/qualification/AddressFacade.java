/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import org.tmf.dsmapi.service.qualification.model.Address;

/**
 *
 * @author Lin
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {
    
    @PersistenceContext(unitName = "DSServiceQualificationPU")
    private EntityManager em;
    
    /**
     * 
     * @param href
     * @return 
     */
    public Address findByHref(String href) {
        String sqlStr = "select a from Address a where a.href = :href";
        Query query = em.createQuery(sqlStr);
        query.setParameter("href", href);
        
        List<Address> addressList = (List<Address>)query.getResultList();
        if(addressList != null && addressList.size() > 0) {
            return addressList.get(0);
        }
        return null;
    }
    
    /**
     * 
     */
    public AddressFacade() {
        super(Address.class);
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
