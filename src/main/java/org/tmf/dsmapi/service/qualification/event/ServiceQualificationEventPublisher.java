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
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationReqEntity;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class ServiceQualificationEventPublisher implements ServiceQualificationEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    ServiceQualificationEventFacade eventFacade;
    @EJB
    RESTEventPublisherLocal restEventPublisherLocal;

    /**
     * 
     * @param event 
     */
    @Override
    public void publish(ServiceQualificationEvent event) {
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
    public void createNotification(ServiceQualificationReqEntity bean, Date date) {
        ServiceQualificationEvent event = new ServiceQualificationEvent();
        event.setEventTime(date);
        event.setEventType(QualificationEventTypeEnum.ServiceQualificationCreation);
        event.setResource(bean);
        publish(event);

    }

}
