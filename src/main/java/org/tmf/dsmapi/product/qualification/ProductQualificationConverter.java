package org.tmf.dsmapi.product.qualification;

import java.util.ArrayList;
import java.util.List;
import org.tmf.dsmapi.product.qualification.entity.ProductCharacteristicReqEntity;
import org.tmf.dsmapi.product.qualification.entity.ProductOfferingCategoryReqEntity;
import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationReqEntity;
import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationReqItemEntity;
import org.tmf.dsmapi.product.qualification.entity.ProductOfferingReqEntity;
import org.tmf.dsmapi.product.qualification.entity.ProductReqEntity;
import org.tmf.dsmapi.product.qualification.entity.ProductSpecificationReqEntity;
import org.tmf.dsmapi.product.qualification.entity.RelatedPartyReqEntity;
import org.tmf.dsmapi.product.qualification.rsp.ProductOfferingQualificationRsp;
import org.tmf.dsmapi.service.qualification.ServiceQualificationConverter;
import org.tmf.dsmapi.service.qualification.model.ProductCharacteristicReq;
import org.tmf.dsmapi.service.qualification.model.ProductOfferingCategoryReq;
import org.tmf.dsmapi.service.qualification.model.ProductOfferingQualificationReq;
import org.tmf.dsmapi.service.qualification.model.ProductOfferingQualificationReqItem;
import org.tmf.dsmapi.service.qualification.model.ProductOfferingReq;
import org.tmf.dsmapi.service.qualification.model.ProductReq;
import org.tmf.dsmapi.service.qualification.model.ProductSpecificationReq;
import org.tmf.dsmapi.service.qualification.model.RelatedParty;

public class ProductQualificationConverter {

    public static ProductOfferingQualificationRsp convert(ProductOfferingQualificationReq req) {
        ProductOfferingQualificationRsp resp = new ProductOfferingQualificationRsp();

        return resp;
    }

    public static ProductOfferingQualificationReqEntity convertRequest(ProductOfferingQualificationReq request) {
        ProductOfferingQualificationReqEntity entity = new ProductOfferingQualificationReqEntity();
        entity.setHref(request.getId());
        entity.setChannel(request.getChannel());
        entity.setAddress(ServiceQualificationConverter.convert(request.getAddress()));
        entity.setAddressDescription(ServiceQualificationConverter.convert(request.getAddressDescription()));
        entity.setEligibilityDate(request.getEligibilityDate());
        entity.setGeoCode(ServiceQualificationConverter.convert(request.getGeoCode()));
        entity.setProductInventoryId(request.getProductInventoryId());
        entity.setProductOfferingQualificationItem(convert(request.getProductOfferingQualificationItem()));
        entity.setPublicKey(request.getPublicKey());
        entity.setRelatedParty(convertRelatedParties(request.getRelatedParty()));
        return entity;

    }

    public static List<RelatedPartyReqEntity> convertRelatedParties(List<RelatedParty> items) {
        List<RelatedPartyReqEntity> list = new ArrayList<>();
        for (RelatedParty item : items) {
            RelatedPartyReqEntity entity = new RelatedPartyReqEntity();
            entity.setHref(item.getHref());
            entity.setId(item.getId());
            entity.setName(item.getName());
            entity.setRole(item.getRole());
            list.add(entity);
        }
        return list;
    }

    public static List<ProductOfferingQualificationReqItemEntity> convert(List<ProductOfferingQualificationReqItem> items) {
        List<ProductOfferingQualificationReqItemEntity> list = new ArrayList<>();
        for (ProductOfferingQualificationReqItem item : items) {
            ProductOfferingQualificationReqItemEntity entity = new ProductOfferingQualificationReqItemEntity();
            entity.setProductOffering(convert(item.getProductOffering()));
            list.add(entity);
        }
        return list;
    }

    public static ProductOfferingReqEntity convert(ProductOfferingReq request) {
        ProductOfferingReqEntity entity = new ProductOfferingReqEntity();
        if (request == null) {
            return null;
        }
        entity.setHref(request.getHref());
        entity.setId(request.getId());
        entity.setProduct(convert(request.getProduct()));
        entity.setProductOfferingCategory(convert(request.getProductOfferingCategory()));
        return entity;
    }

    public static ProductReqEntity convert(ProductReq request) {
        ProductReqEntity entity = new ProductReqEntity();
        if (request == null) {
            return null;
        }
        entity.setProductCharacteristic(convertProductCharacteristics(request.getProductCharacteristic()));
        entity.setProductSpecification(convert(request.getProductSpecification()));
        return entity;
    }

    public static ProductSpecificationReqEntity convert(ProductSpecificationReq request) {
        ProductSpecificationReqEntity entity = new ProductSpecificationReqEntity();
        if (request == null) {
            return null;
        }
        entity.setName(request.getName());
        entity.setId(request.getId());
        entity.setValue(request.getValue());
        entity.setVersion(request.getVersion());
        return entity;
    }

    public static List<ProductCharacteristicReqEntity> convertProductCharacteristics(List<ProductCharacteristicReq> items) {
        List<ProductCharacteristicReqEntity> list = new ArrayList<>();
        for (ProductCharacteristicReq item : items) {
            ProductCharacteristicReqEntity entity = new ProductCharacteristicReqEntity();
            entity.setId(item.getId());
            entity.setName(item.getName());
            entity.setValue(item.getValue());
            list.add(entity);
        }
        return list;
    }

    public static ProductOfferingCategoryReqEntity convert(ProductOfferingCategoryReq request) {
        ProductOfferingCategoryReqEntity entity = new ProductOfferingCategoryReqEntity();
        if (request == null) {
            return null;
        }
        entity.setId(request.getId());
        return entity;
    }

}
