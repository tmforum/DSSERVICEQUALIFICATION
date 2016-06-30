/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template;

import java.util.List;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;
import org.tmf.dsmapi.service.qualification.req.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.req.ServiceReq;
import org.tmf.dsmapi.service.qualification.rsp.ServiceQualificationItemRsp;

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
    public ServiceSpecification prepare(ServiceSpecification serviceSpecification) {

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
