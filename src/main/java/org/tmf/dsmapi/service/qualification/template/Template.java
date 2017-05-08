/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template;

import java.util.List;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationItemRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.model.ServiceReq;
import org.tmf.dsmapi.service.qualification.enity.ServiceSpecificationEntity;


/**
 *
 * @author Henry
 */
public abstract class Template {

    /**
     *
     * @param serviceSpecification
     * @return
     */
    public ServiceSpecificationEntity prepare(ServiceSpecificationEntity serviceSpecification) {

        return serviceSpecification;
    }
    
    /**
     * 
     * @param qualificationReq
     * @param serviceReq
     * @return
     * @throws TemplateNotFoundException 
     */
    public List<ServiceQualificationItemRsp> mactch(ServiceQualificationReq qualificationReq, ServiceReq serviceReq) throws TemplateNotFoundException  {
        throw new TemplateNotFoundException();
    }
}
