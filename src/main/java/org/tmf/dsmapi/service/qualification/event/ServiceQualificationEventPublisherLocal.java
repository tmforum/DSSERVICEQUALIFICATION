package org.tmf.dsmapi.service.qualification.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationReqEntity;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;


@Local
public interface ServiceQualificationEventPublisherLocal {

    void publish(ServiceQualificationEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param date the creation date
     */
    public void createNotification(ServiceQualificationReqEntity bean, Date date);

    
}
