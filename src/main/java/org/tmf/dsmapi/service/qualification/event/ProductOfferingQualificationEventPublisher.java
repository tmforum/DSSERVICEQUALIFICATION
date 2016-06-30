/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;
import org.tmf.dsmapi.product.qualification.req.ProductOfferingQualificationReq;

/**
 *
 * @author Lin
 */
@Stateless
@Asynchronous
public class ProductOfferingQualificationEventPublisher implements ProductOfferingQualificationEventPublisherLocal {
     @EJB
    HubFacade hubFacade;
    @EJB
    ProductOfferingQualificationEventFacade eventFacade;
    @EJB
    RESTEventPublisherLocal restEventPublisherLocal;

    /**
     * 
     * @param event 
     */
    @Override
    public void publish(ProductOfferingQualificationEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(ServiceQualificationEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(ProductOfferingQualificationReq bean, Date date) {
        ProductOfferingQualificationEvent event = new ProductOfferingQualificationEvent();
        event.setEventTime(date);
        event.setEventType(QualificationEventTypeEnum.ProductOfferingQualificationCreation);
        event.setResource(bean);
        publish(event);

    }
}
