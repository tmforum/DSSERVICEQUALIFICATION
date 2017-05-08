package org.tmf.dsmapi.service.qualification.enity;

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



@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceReq")
@Table(name = "SERVICE_REQ")
public class ServiceReqEntity implements Serializable {

    private final static long serialVersionUID = 11L;

    private List<ServiceReqCharacteristicEntity> serviceCharacteristic = new ArrayList<>();
    private ServiceSpecificationReqEntity serviceSpecification = null;

    protected Long serviceId;

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
    public ServiceReqEntity serviceCharacteristic(List<ServiceReqCharacteristicEntity> serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceCharacteristic")
    @OneToMany(targetEntity = ServiceReqCharacteristicEntity.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_ID")
    public List<ServiceReqCharacteristicEntity> getServiceCharacteristic() {
        return serviceCharacteristic;
    }

    public void setServiceCharacteristic(List<ServiceReqCharacteristicEntity> serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
    }

    /**
     *
     */
    public ServiceReqEntity serviceSpecification(ServiceSpecificationReqEntity serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceSpecification")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_SPEC_ID")
    public ServiceSpecificationReqEntity getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(ServiceSpecificationReqEntity serviceSpecification) {
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
        ServiceReqEntity serviceReq = (ServiceReqEntity) o;
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
