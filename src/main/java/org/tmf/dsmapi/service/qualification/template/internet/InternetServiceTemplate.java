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
import org.tmf.dsmapi.service.qualification.ServiceQualificationConverter;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceSpecificationEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceSpecificationCharacteristicEntity;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationItemRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.model.ServiceReq;
import org.tmf.dsmapi.service.qualification.model.ServiceRsp;
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
    public ServiceSpecificationEntity prepare(ServiceSpecificationEntity serviceSpecification) {

        Tuple<Long, String> tupleFrom = null;
        Tuple<Long, String> tupleTo = null;
        for (ServiceSpecificationCharacteristicEntity entity : serviceSpecification.getServiceSpecificationCharacteristic()) {

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

        List<ServiceQualificationEntity> serviceRelaList = null;
        if ("Yes".equalsIgnoreCase(qualificationReq.getProvideOnlyEligible())) {
            serviceRelaList = internetServiceFacade.queryQualifiedService(qualificationReq, serviceReq);
        }

        List<ServiceQualificationEntity> alterServiceRelaList = null;
        if (serviceRelaList == null || serviceRelaList.isEmpty()) {
            if ("Yes".equalsIgnoreCase(qualificationReq.getProvideAlternative())) {
                alterServiceRelaList = internetServiceFacade.queryQualifiedService(qualificationReq, serviceReq, true);
            }
        }

        ServiceQualificationItemRsp rspItem;
        List<ServiceQualificationItemRsp> itemRspList = new ArrayList<>();
        // requester ask for a broadband access with a download speed at least equals to 20 Mb/s – if only 12 M/bs is available 
        if (alterServiceRelaList != null && !alterServiceRelaList.isEmpty()) {
            rspItem = new ServiceQualificationItemRsp();
            ServiceQualificationEntity rela = alterServiceRelaList.get(0);
            if (rela.getServiceSpecification() != null && !rela.getServiceSpecification().isEmpty()) {
                ServiceSpecificationEntity servSpecification = rela.getServiceSpecification().get(0);
                //servSpecification.clean();
                ServiceRsp alterService = ServiceQualificationConverter.convertAlterService(servSpecification);
                alterService.setServiceSpecification(ServiceQualificationConverter.convert(servSpecification));

                List<ServiceRsp> alterList = new ArrayList<>();
                alterList.add(alterService);
                rspItem.setAlternativeService(alterList);
                rspItem.setService(ServiceQualificationConverter.convert(serviceReq));
                rspItem.setAvailability("available-shortfall");
                rspItem.setServiceabilityDate(new Date());

                itemRspList.add(rspItem);
            }
        }

        if (serviceRelaList == null || serviceRelaList.isEmpty()) {
            return itemRspList;
        }
        for (ServiceQualificationEntity rela : serviceRelaList) {

            List<ServiceSpecificationEntity> servSpecList = rela.getServiceSpecification();
            if (servSpecList == null) {
                continue;
            }
            for (ServiceSpecificationEntity servSpec : servSpecList) {
                rspItem = new ServiceQualificationItemRsp();
                rspItem.setAvailability("available");
                rspItem.setServiceabilityDate(new Date());
                ServiceRsp serviceRsp = ServiceQualificationConverter.convert(serviceReq);

                //servSpec.clean();
                serviceRsp.setServiceSpecification(ServiceQualificationConverter.convert(servSpec));
                rspItem.setService(serviceRsp);
                itemRspList.add(rspItem);
            }
        }
        return itemRspList;
    }
}
