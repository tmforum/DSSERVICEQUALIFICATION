package org.tmf.dsmapi.service.qualification.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecificationCharacteristic;
import org.tmf.dsmapi.service.qualification.rsp.ServiceRsp;
import org.tmf.dsmapi.service.qualification.rsp.ServiceRspCharacteristic;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceReq")
@Table(name = "SERVICE_REQ")
public class ServiceReq implements Serializable {

    private final static long serialVersionUID = 11L;

    private List<ServiceReqCharacteristic> serviceCharacteristic = new ArrayList<>();
    private ServiceSpecificationReq serviceSpecification = null;

    protected Long serviceId;
    
    /**
     * 
     * @return ServiceRsp
     */
    public ServiceRsp convert() {
        List<ServiceRspCharacteristic> rspList;
        ServiceRsp serviceRsp = null;
        
        if(this.serviceCharacteristic != null ) {
            serviceRsp = new ServiceRsp();
            rspList = new ArrayList<>();
            for(ServiceReqCharacteristic characteristic: serviceCharacteristic) {
                rspList.add(characteristic.convert());
            }
            serviceRsp.setServiceCharacteristic(rspList);
        }
        return serviceRsp;
    }
    
    public ServiceRsp convertServiceRsp() {
        ServiceRsp serviceRsp = null;
        if(this.serviceSpecification != null) {
            serviceRsp = new ServiceRsp();
            serviceRsp.setServiceSpecification(this.serviceSpecification.convert());
        }
        return serviceRsp;
    }
    
   /**
    * 
    * @param servSpec
    * @return 
    */
    public ServiceRsp convertAlterService(ServiceSpecification servSpec) {
        ServiceRsp serviceRsp = new ServiceRsp();
        if(this.getServiceSpecification() != null) {
            serviceRsp.setServiceSpecification(this.getServiceSpecification().convert());
        }
        if(servSpec == null || servSpec.getServiceSpecificationCharacteristic() == null) {
            return serviceRsp;
        }
        if(serviceCharacteristic == null ) {
            return serviceRsp;
        }
        
        List<ServiceRspCharacteristic> servRspCharacteristicList = new ArrayList<>();
        ServiceRspCharacteristic rspCharacteristic = null;
        for(ServiceReqCharacteristic serviceReqCharacteristic: serviceCharacteristic) {
            for(ServiceSpecificationCharacteristic serviceSpecCharacteristic: servSpec.getServiceSpecificationCharacteristic()) {
                
                if(serviceReqCharacteristic.getName().equals(serviceSpecCharacteristic.getName())) {
                    rspCharacteristic = new ServiceRspCharacteristic();
                    rspCharacteristic.setName(serviceSpecCharacteristic.getName());
                    rspCharacteristic.setValue(serviceSpecCharacteristic.getValueto());
                    servRspCharacteristicList.add(rspCharacteristic);
                }
            }
        }
        serviceRsp.setServiceCharacteristic(servRspCharacteristicList);
        
        return serviceRsp;
    }

    /**
     *
     * @return possible object is {@link Long }
     *
     */
    @Id
    @Column(name = "SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Long getServiceId() {
        return serviceId;
    }

    /**
     *
     * @param value allowed object is {@link Long }
     *
     */
    public void setServiceId(Long value) {
        this.serviceId = value;
    }

    /**
     *
     */
    public ServiceReq serviceCharacteristic(List<ServiceReqCharacteristic> serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceCharacteristic")
    @OneToMany(targetEntity = ServiceReqCharacteristic.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_ID")
    public List<ServiceReqCharacteristic> getServiceCharacteristic() {
        return serviceCharacteristic;
    }

    public void setServiceCharacteristic(List<ServiceReqCharacteristic> serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
    }

    /**
     *
     */
    public ServiceReq serviceSpecification(ServiceSpecificationReq serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceSpecification")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_SPEC_ID")
    public ServiceSpecificationReq getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(ServiceSpecificationReq serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceReq serviceReq = (ServiceReq) o;
        return Objects.equals(serviceCharacteristic, serviceReq.serviceCharacteristic)
                && Objects.equals(serviceSpecification, serviceReq.serviceSpecification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceCharacteristic, serviceSpecification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceReq {\n");

        sb.append("    serviceCharacteristic: ").append(toIndentedString(serviceCharacteristic)).append("\n");
        sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
