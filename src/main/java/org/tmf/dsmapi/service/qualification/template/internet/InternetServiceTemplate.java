/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template.internet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.service.qualification.model.ServiceQualification;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecificationCharacteristic;
import org.tmf.dsmapi.service.qualification.req.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.req.ServiceReq;
import org.tmf.dsmapi.service.qualification.rsp.ServiceQualificationItemRsp;
import org.tmf.dsmapi.service.qualification.rsp.ServiceRsp;
import org.tmf.dsmapi.service.qualification.template.Template;
import org.tmf.dsmapi.service.qualification.template.TemplateNotFoundException;
import org.tmf.dsmapi.service.qualification.template.Tuple;

/**
 *
 * @author Lin
 */
@Stateless(name = "InternetServiceTemplate")
public class InternetServiceTemplate extends Template {

    @EJB
    InternetServiceFacade internetServiceFacade;

    /**
     *
     * @param serviceSpecification
     * @return
     */
    @Override
    public ServiceSpecification prepare(ServiceSpecification serviceSpecification) {

        Tuple<Long, String> tupleFrom = null;
        Tuple<Long, String> tupleTo = null;
        for (ServiceSpecificationCharacteristic entity : serviceSpecification.getServiceSpecificationCharacteristic()) {

            if (CharacteristicEnum.DOWNSTREAM_SPEED.getValue().equals(entity.getName())) {
                tupleFrom = InternetServiceUtil.parseSpeedCharacteristicValue(entity.getValuefrom());
                tupleTo = InternetServiceUtil.parseSpeedCharacteristicValue(entity.getValueto());
            } else if (CharacteristicEnum.UPSTREAM_SPEED.getValue().equals(entity.getName())) {
                tupleFrom = InternetServiceUtil.parseSpeedCharacteristicValue(entity.getValuefrom());
                tupleTo = InternetServiceUtil.parseSpeedCharacteristicValue(entity.getValueto());
            }
            if (tupleFrom != null) {
                entity.setValueFromNumber(tupleFrom.getValue());
                entity.setValueFromUnit(tupleFrom.getUnit());
            }

            if (tupleTo != null) {
                entity.setValueToNumber(tupleTo.getValue());
                entity.setValueToUnit(tupleTo.getUnit());
            }
        }
        return serviceSpecification;
    }

    /**
     *
     * @param qualificationReq * @param serviceReq
     * @return
     * @throws TemplateNotFoundException
     */
    @Override
    public List<ServiceQualificationItemRsp> mactch(ServiceQualificationReq qualificationReq, ServiceReq serviceReq) throws TemplateNotFoundException {
        if (serviceReq == null) {
            return null;
        }
        
        List<ServiceQualification> serviceRelaList = null;
        if("Yes".equalsIgnoreCase(qualificationReq.getProvideOnlyEligible())) {
            serviceRelaList = internetServiceFacade.queryQualifiedService(qualificationReq, serviceReq);
        }
        
        List<ServiceQualification> alterServiceRelaList = null;
        if(serviceRelaList == null || serviceRelaList.isEmpty()) {
            if("Yes".equalsIgnoreCase(qualificationReq.getProvideAlternative())) {
                alterServiceRelaList = internetServiceFacade.queryQualifiedService(qualificationReq, serviceReq, true);
            }
        }
        
        ServiceQualificationItemRsp rspItem;
        List<ServiceQualificationItemRsp> itemRspList = new ArrayList<>();
        // requester ask for a broadband access with a download speed at least equals to 20 Mb/s – if only 12 M/bs is available 
        if(alterServiceRelaList != null && !alterServiceRelaList.isEmpty()) {
            rspItem = new ServiceQualificationItemRsp();
            ServiceQualification rela = alterServiceRelaList.get(0);
            if(rela.getServiceSpecification() != null && !rela.getServiceSpecification().isEmpty()) {
                ServiceSpecification servSpecification = rela.getServiceSpecification().get(0);
                //servSpecification.clean();
                ServiceRsp alterService = serviceReq.convertAlterService(servSpecification);
                alterService.setServiceSpecification(servSpecification);
 
                List<ServiceRsp> alterList = new ArrayList<>();
                alterList.add(alterService);
                rspItem.setAlternativeService(alterList);
                rspItem.setService(serviceReq.convertServiceRsp());
                rspItem.setAvailability("available-shortfall");
                rspItem.setServiceabilityDate(new Date());
                
                itemRspList.add(rspItem);
            }
        }
        
        if (serviceRelaList == null || serviceRelaList.isEmpty()) {
            return itemRspList;
        }
        for (ServiceQualification rela : serviceRelaList) {

            List<ServiceSpecification> servSpecList = rela.getServiceSpecification();
            if (servSpecList == null) {
                continue;
            }
            for (ServiceSpecification servSpec : servSpecList) {
                rspItem = new ServiceQualificationItemRsp();
                rspItem.setAvailability("available");
                rspItem.setServiceabilityDate(new Date());
                ServiceRsp serviceRsp = serviceReq.convert();
                
                //servSpec.clean();
                serviceRsp.setServiceSpecification(servSpec);
                rspItem.setService(serviceRsp);
                itemRspList.add(rspItem);
            }
        }
        return itemRspList;
    }
}
