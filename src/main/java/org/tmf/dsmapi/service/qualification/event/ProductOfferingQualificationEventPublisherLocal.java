/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.product.qualification.req.ProductOfferingQualificationReq;

/**
 *
 * @author Lin
 */
@Local
public interface ProductOfferingQualificationEventPublisherLocal {
    
     void publish(ProductOfferingQualificationEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(ProductOfferingQualificationReq bean, Date date);
}
