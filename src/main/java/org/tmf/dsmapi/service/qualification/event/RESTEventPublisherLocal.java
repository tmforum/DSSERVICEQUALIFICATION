package org.tmf.dsmapi.service.qualification.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface RESTEventPublisherLocal {

    public void publish(Hub hub, ServiceQualificationEvent event);
    
    public void publish(Hub hub, ProductOfferingQualificationEvent event);
}
