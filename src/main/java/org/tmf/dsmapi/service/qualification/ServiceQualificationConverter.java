package org.tmf.dsmapi.service.qualification;

import java.util.ArrayList;
import java.util.List;
import org.tmf.dsmapi.service.qualification.enity.AddressDescriptionReqEntity;
import org.tmf.dsmapi.service.qualification.enity.AddressReqEntity;
import org.tmf.dsmapi.service.qualification.enity.GeoCodeReqEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationReqEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationReqItemEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceReqCharacteristicEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceReqEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceSpecificationCharacteristicEntity;
import org.tmf.dsmapi.service.qualification.enity.ServiceSpecificationEntity;
import org.tmf.dsmapi.service.qualification.model.AddressDescriptionReq;
import org.tmf.dsmapi.service.qualification.model.AddressReq;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRsp;

import org.tmf.dsmapi.service.qualification.model.GeoCodeReq;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationItemReq;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.model.ServiceReq;
import org.tmf.dsmapi.service.qualification.model.ServiceReqCharacteristic;
import org.tmf.dsmapi.service.qualification.model.ServiceRsp;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecificationCharacteristic;

/**
 *
 * @author Naveen_P08
 */
public class ServiceQualificationConverter {

    public static ServiceQualificationRsp convert(ServiceQualificationReqEntity request) {
        ServiceQualificationRsp rsp = new ServiceQualificationRsp();

        if (request == null) {
            return rsp;
        }

        rsp.setId(request.getId());
        rsp.setHref(request.getHref());
        rsp.setInteractionDate(request.getInteractionDate());
        rsp.setProvideAlternative(request.getProvideAlternative());
        rsp.setProvideOnlyEligible(request.getProvideOnlyEligible());
        rsp.setEligibilityDate(request.getEligibilityDate());
        rsp.setQualificationState(request.getQualificationState());
        rsp.setDescription(request.getDescription());

        rsp.setAddress(convert(request.getAddress()));
        rsp.setAddressDescription(convert(request.getAddressDescription()));
        rsp.setGeoCode(convert(request.getGeoCode()));
        rsp.setPublicKey(request.getPublicKey());

        return rsp;
    }

    public static AddressReq convert(AddressReqEntity addressReqEntity) {
        AddressReq request = new AddressReq();

        if (addressReqEntity == null) {
            return request;
        }

        request.setId(addressReqEntity.getId());
        request.setHref(addressReqEntity.getHref());
        return request;
    }

    public static AddressReqEntity convert(AddressReq addressReq) {
        AddressReqEntity request = new AddressReqEntity();
        if (addressReq == null) {
            return null;
        }
        request.setId(addressReq.getId());
        request.setHref(addressReq.getHref());
        return request;
    }

    public static AddressDescriptionReq convert(AddressDescriptionReqEntity addressDescriptionEntity) {
        AddressDescriptionReq request = new AddressDescriptionReq();

        if (addressDescriptionEntity == null) {
            return request;
        }

        request.setCity(addressDescriptionEntity.getCity());
        request.setCountry(addressDescriptionEntity.getCountry());
        request.setLocality(addressDescriptionEntity.getLocality());
        request.setPostcode(addressDescriptionEntity.getPostcode());
        request.setStateOrProvince(addressDescriptionEntity.getStateOrProvince());
        request.setStreetName(addressDescriptionEntity.getStreetName());
        request.setStreetNr(addressDescriptionEntity.getStreetNr());
        request.setStreetNrLast(addressDescriptionEntity.getStreetNrLast());
        request.setStreetNrLastSuffix(addressDescriptionEntity.getStreetNrLastSuffix());
        request.setStreetNrSuffix(addressDescriptionEntity.getStreetNrSuffix());
        request.setStreetSuffix(addressDescriptionEntity.getStreetSuffix());
        request.setStreetType(addressDescriptionEntity.getStreetType());
        return request;
    }
    
    public static AddressDescriptionReqEntity convert(AddressDescriptionReq request) {
        AddressDescriptionReqEntity entity = new AddressDescriptionReqEntity();

        if (request == null) {
            return null;
        }

        entity.setCity(request.getCity());
        entity.setCountry(request.getCountry());
        entity.setLocality(request.getLocality());
        entity.setPostcode(request.getPostcode());
        entity.setStateOrProvince(request.getStateOrProvince());
        entity.setStreetName(request.getStreetName());
        entity.setStreetNr(request.getStreetNr());
        entity.setStreetNrLast(request.getStreetNrLast());
        entity.setStreetNrLastSuffix(request.getStreetNrLastSuffix());
        entity.setStreetNrSuffix(request.getStreetNrSuffix());
        entity.setStreetSuffix(request.getStreetSuffix());
        entity.setStreetType(request.getStreetType());
        return entity;
    }

    public static GeoCodeReq convert(GeoCodeReqEntity geoCodeReqEntity) {
        GeoCodeReq request = new GeoCodeReq();

        if (geoCodeReqEntity == null) {
            return request;
        }

        request.setGeographicDatum(geoCodeReqEntity.getGeographicDatum());
        request.setLatitude(geoCodeReqEntity.getLatitude());
        request.setLongitude(geoCodeReqEntity.getLongitude());
        return request;
    }
    
    public static GeoCodeReqEntity convert(GeoCodeReq request) {
        GeoCodeReqEntity entity = new GeoCodeReqEntity();

        if (request == null) {
            return null;
        }

        entity.setGeographicDatum(request.getGeographicDatum());
        entity.setLatitude(request.getLatitude());
        entity.setLongitude(request.getLongitude());
        return entity;
    }

    public static ServiceQualificationRsp convert(ServiceQualificationReq serviceQualificationReq) {
        ServiceQualificationRsp rsp = new ServiceQualificationRsp();
        return rsp;
    }

    public static ServiceQualificationReq convertSQRequest(ServiceQualificationReqEntity request) {
        ServiceQualificationReq req = new ServiceQualificationReq();

        if (request == null) {
            return req;
        }

        req.setAddress(convert(request.getAddress()));
        req.setAddressDescription(convert(request.getAddressDescription()));
        req.setGeoCode(convert(request.getGeoCode()));
        req.setPublicKey(request.getPublicKey());
        req.setDescription(request.getDescription());
        req.setEligibilityDate(request.getEligibilityDate());
        req.setInteractionDate(request.getInteractionDate());
        req.setProvideAlternative(request.getProvideAlternative());
        req.setProvideOnlyEligible(request.getProvideOnlyEligible());
        req.setServiceQualificationItem(convert(request.getServiceQualificationItem()));
        return req;
    }

    public static List<ServiceQualificationItemReq> convert(List<ServiceQualificationReqItemEntity> items) {
        List<ServiceQualificationItemReq> itemsReq = new ArrayList<>();
        for (ServiceQualificationReqItemEntity item : items) {
            ServiceQualificationItemReq itemReq = new ServiceQualificationItemReq();
            itemReq.setService(convert(item.getService()));
            itemsReq.add(itemReq);
        }
        return itemsReq;
    }

    public static ServiceRsp convertServiceResp(ServiceSpecificationEntity servSpecification) {
        ServiceRsp response = new ServiceRsp();
//        response.setServiceCharacteristic(convertChars(servSpecification.getServiceSpecificationCharacteristic()));
        return response;
    }

    public static ServiceSpecification convert(ServiceSpecificationEntity servSpecification) {
        ServiceSpecification response = new ServiceSpecification();
        if (servSpecification == null) {
            return response;
        }
        response.setHref(servSpecification.getHref());
        response.setId(servSpecification.getId());
        response.setServiceCategoryId(servSpecification.getServiceCategoryId());
        response.setServiceSpecificationCharacteristic(convertChars(servSpecification.getServiceSpecificationCharacteristic()));
        return response;
    }

    public static ServiceRsp convert(ServiceReq serviceReq) {
        ServiceRsp response = new ServiceRsp();
        return response;
    }

    public static ServiceReq convert(ServiceReqEntity serviceReq) {
        ServiceReq request = new ServiceReq();
        request.setServiceCharacteristic(converterviceReqCharacteristics(serviceReq.getServiceCharacteristic()));
        return request;
    }

    public static ServiceRsp convertAlterService(ServiceSpecificationEntity servSpec) {
        ServiceRsp serviceRsp = new ServiceRsp();
        return serviceRsp;
    }

    public static List<ServiceSpecificationCharacteristic> convertChars(List<ServiceSpecificationCharacteristicEntity> items) {
        List<ServiceSpecificationCharacteristic> itemsReq = new ArrayList<>();
        for (ServiceSpecificationCharacteristicEntity item : items) {
            ServiceSpecificationCharacteristic ssCharacteristic = new ServiceSpecificationCharacteristic();
            ssCharacteristic.setId(item.getId());
            ssCharacteristic.setName(item.getName());
            ssCharacteristic.setValuefrom(item.getValuefrom());
            ssCharacteristic.setValueto(item.getValueto());
            itemsReq.add(ssCharacteristic);
        }
        return itemsReq;
    }

    public static List<ServiceReqCharacteristic> converterviceReqCharacteristics(List<ServiceReqCharacteristicEntity> items) {
        List<ServiceReqCharacteristic> itemsReq = new ArrayList<>();
        for (ServiceReqCharacteristicEntity item : items) {
            ServiceReqCharacteristic serviceReqCharacteristic = new ServiceReqCharacteristic();
            serviceReqCharacteristic.setName(item.getName());
            serviceReqCharacteristic.setValue(item.getValue());
            itemsReq.add(serviceReqCharacteristic);
        }
        return itemsReq;
    }

}
