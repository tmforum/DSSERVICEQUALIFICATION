/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.service.qualification.template.internet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.tmf.dsmapi.service.qualification.model.AddressDescriptionReq;
import org.tmf.dsmapi.service.qualification.model.AddressReq;
import org.tmf.dsmapi.service.qualification.model.GeoCodeReq;
import org.tmf.dsmapi.service.qualification.enity.ServiceQualificationEntity;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationReq;
import org.tmf.dsmapi.service.qualification.model.ServiceReq;
import org.tmf.dsmapi.service.qualification.model.ServiceReqCharacteristic;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecificationReq;
import org.tmf.dsmapi.service.qualification.template.QueryPreparation;
import org.tmf.dsmapi.service.qualification.template.Tuple;

/**
 *
 * @author Lin
 */
@Stateless
public class InternetServiceFacade {

    @PersistenceContext(unitName = "DSServiceQualificationPU")
    private EntityManager em;

    /**
     *
     * @param qualificationReq
     * @param servReq
     * @return
     */
    public List<ServiceQualificationEntity> queryQualifiedService(ServiceQualificationReq qualificationReq, ServiceReq servReq) {
        return queryQualifiedService(qualificationReq, servReq, false);
    }

    /**
     *
     * @param qualificationReq
     * @param servReq
     * @param alternative
     * @return
     */
    public List<ServiceQualificationEntity> queryQualifiedService(ServiceQualificationReq qualificationReq, ServiceReq servReq, boolean alternative) {

        QueryPreparation queryPreparation    = getJoinAddress(qualificationReq);
        QueryPreparation  servicePreparation = getJoinServiceSpec(qualificationReq, servReq, alternative);

        boolean whereFlag = false;

        StringBuilder ql = new StringBuilder(1024);
        ql.append("select a from ServiceQualification a");
        if (queryPreparation != null) {
            ql.append(queryPreparation.getJoin());
            whereFlag = true;
        }
        if (servicePreparation != null) {
            ql.append(servicePreparation.getJoin());
            whereFlag = true;
        }
        if (whereFlag) {
            ql.append(" where ");
        }
        if (queryPreparation != null) {
            ql.append(queryPreparation.getWhere());
        }
        if (servicePreparation != null) {
            if (queryPreparation != null && queryPreparation.getWhere() != null && queryPreparation.getWhere().length() > 0) {
                ql.append(" and ");
            }
            ql.append(servicePreparation.getWhere());
            ql.append(servicePreparation.getOrder());
        }
       

        Query query = em.createQuery(ql.toString());
        if (queryPreparation != null && queryPreparation.getParams() != null) {
            Set<Entry<String, Object>> paramSet = queryPreparation.getParams().entrySet();
            for (Entry<String, Object> param : paramSet) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        if (servicePreparation != null && servicePreparation.getParams() != null) {
            Set<Entry<String, Object>> paramSet = servicePreparation.getParams().entrySet();
            for (Entry<String, Object> param : paramSet) {
                query.setParameter(param.getKey(), param.getValue());
            }
        }
        List<ServiceQualificationEntity> resultList = (List<ServiceQualificationEntity>) query.getResultList();

        return resultList;
    }

    /**
     *
     * @param req
     * @return
     */
    private QueryPreparation getJoinAddress(ServiceQualificationReq req) {
        StringBuilder joinStr = new StringBuilder(512);
        StringBuilder whereStr = new StringBuilder(512);
        Map<String, Object> params = new HashMap<>();

        AddressReq addressReq = req.getAddress();
        AddressDescriptionReq addressDescReq = req.getAddressDescription();
        GeoCodeReq geoCodeReq = req.getGeoCode();
        String publicKey = req.getPublicKey();

        if (addressReq != null) {
            joinStr.append(" join Address b on a.addressId = b.id");
            whereStr.append(" b.href = :href ");
            params.put("href", addressReq.getHref());

        } else if (addressDescReq != null) {
            joinStr.append(" join AddressDescription c on a.addressDescId = c.id");
            whereStr.append(" ");
        } else if (geoCodeReq != null) {
            joinStr.append(" join GeoCode d on a.geoCodeId = d.id");
            whereStr.append(" ");
        } else if (publicKey != null && !publicKey.isEmpty()) {
            whereStr.append(" ");
        }

        QueryPreparation queryPreparation = new QueryPreparation();
        queryPreparation.setJoin(joinStr.toString());
        queryPreparation.setWhere(whereStr.toString());
        queryPreparation.setParams(params);

        return queryPreparation;
    }

    /**
     *
     * @param req
     * @param servReq
     * @return
     */
    private QueryPreparation getJoinServiceSpec(ServiceQualificationReq req, ServiceReq servReq, boolean alternative) {

        if (req == null || servReq == null) {
            return null;
        }

        StringBuilder joinStr = new StringBuilder(512);
        StringBuilder whereStr = new StringBuilder(512);
        StringBuilder orderStr = new StringBuilder(512);
        Map<String, Object> params = new HashMap<>();

        ServiceSpecificationReq servSpecificationReq = servReq.getServiceSpecification();
        if (servSpecificationReq != null) {
            joinStr.append(" join a.serviceSpecification e ");
            whereStr.append(" e.id = :servSpecId ");
            params.put("servSpecId", servSpecificationReq.getId());
        } else {
            joinStr.append(" join a.serviceSpecification e ");
        }

        List<ServiceReqCharacteristic> servReqCharList = servReq.getServiceCharacteristic();
        Tuple<Long, String> ret;
        if (servReqCharList == null || servReqCharList.isEmpty()) {
            return null;
        }

        for (ServiceReqCharacteristic characteristic : servReqCharList) {
            if (CharacteristicEnum.DOWNSTREAM_SPEED.getValue().equals(characteristic.getName())) {
                ret = InternetServiceUtil.parseSpeedCharacteristicValue(characteristic.getValue());
                joinStr.append(" join e.serviceSpecificationCharacteristic ea ");
                if (whereStr.length() > 0) {
                    whereStr.append(" and ");
                }
                if (alternative) {
                    whereStr.append(" ea.name = :characteristic_name ");
                    params.put("characteristic_name", CharacteristicEnum.DOWNSTREAM_SPEED.getValue());
                } else {
                    whereStr.append(" ea.name = :characteristic_name and ea.valueToNumber >=  :downstream_speed");
                    params.put("characteristic_name", CharacteristicEnum.DOWNSTREAM_SPEED.getValue());
                    params.put("downstream_speed", ret.getValue());
                }
                if (orderStr.length() > 0) {
                    orderStr.append(" ,ea.valueToNumber desc ");
                } else {
                    orderStr.append(" order by ea.valueToNumber desc ");
                }

            } else if (CharacteristicEnum.UPSTREAM_SPEED.getValue().equals(characteristic.getName())) {
                ret = InternetServiceUtil.parseSpeedCharacteristicValue(characteristic.getValue());
                joinStr.append(" join e.serviceSpecificationCharacteristic eb ");
                if (whereStr.length() > 0) {
                    whereStr.append(" and ");
                }
                if (alternative) {
                    whereStr.append(" eb.name = :characteristic_name");
                    params.put("characteristic_name", CharacteristicEnum.UPSTREAM_SPEED.getValue());
                } else {
                    whereStr.append(" eb.name = :characteristic_name and eb.valueToNumber >=  :upstream_speed");
                    params.put("characteristic_name", CharacteristicEnum.UPSTREAM_SPEED.getValue());
                    params.put("upstream_speed", ret.getValue());
                }
                if (orderStr.length() > 0) {
                    orderStr.append(" ,eb.valueToNumber desc ");
                } else {
                    orderStr.append(" order by eb.valueToNumber desc ");
                }
            }

        }

        QueryPreparation queryPreparation = new QueryPreparation();
        queryPreparation.setJoin(joinStr.toString());
        queryPreparation.setWhere(whereStr.toString());
        queryPreparation.setOrder(orderStr.toString());
        queryPreparation.setParams(params);

        return queryPreparation;
    }
}
