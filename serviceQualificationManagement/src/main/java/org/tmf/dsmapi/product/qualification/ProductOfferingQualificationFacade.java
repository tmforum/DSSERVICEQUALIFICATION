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
import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.queries.QueryByExamplePolicy;
import org.eclipse.persistence.queries.ReadObjectQuery;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import org.tmf.dsmapi.product.qualification.model.ProductOfferingQualification;

/**
 *
 * @author Lin
 */
@Stateless
public class ProductOfferingQualificationFacade extends AbstractFacade<ProductOfferingQualification> {

    @PersistenceContext(unitName = "DSServiceQualificationPU")
    private EntityManager em;

    public List<ProductOfferingQualification> findByCriteria(ProductOfferingQualification condition) {
        //CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        //CriteriaQuery<ProductOfferingQualification> cq = criteriaBuilder.createQuery(ProductOfferingQualification.class);
        //cq.where(criteriaBuilder)
        QueryByExamplePolicy policy = new QueryByExamplePolicy();
        policy.excludeDefaultPrimitiveValues();
        ReadObjectQuery q = new ReadObjectQuery(condition, policy);
        Query query = JpaHelper.createQuery(q, em);

        List<ProductOfferingQualification> retList = (List<ProductOfferingQualification>)query.getResultList();
        
        return retList;
    }

    /**
     *
     */
    public ProductOfferingQualificationFacade() {
        super(ProductOfferingQualification.class);
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
