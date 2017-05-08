package org.tmf.dsmapi.service.qualification.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceSpecReq")
@Table(name = "SERVICE_SPEC_REQ")
public class ServiceSpecificationReqEntity implements Serializable {

    private final static long serialVersionUID = 11L;

    private String id = null;
    private String href = null;
    private String serviceCategoryId = null;
    private List<ServiceSpecificationReqCharacteristicEntity> serviceSpecificationCharacteristic = new ArrayList<ServiceSpecificationReqCharacteristicEntity>();

    protected Long hjid;
    
    
    
    public ServiceSpecificationEntity convert() {
        ServiceSpecificationEntity servSpec = new ServiceSpecificationEntity();
        
        servSpec.setId(id);
        servSpec.setHref(href);
        servSpec.setServiceCategoryId(serviceCategoryId);
        
        return servSpec;
    }

    /**
     *
     * @return possible object is {@link Long }
     *
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Long getHjid() {
        return hjid;
    }

    /**
     *
     * @param value allowed object is {@link Long }
     *
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    /**
     *
     */
    public ServiceSpecificationReqEntity id(String id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("id")
    @Basic
    @Column(name = "ID", length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     */
    public ServiceSpecificationReqEntity href(String href) {
        this.href = href;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("href")
    @Basic
    @Column(name = "HREF", length = 255)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     */
    public ServiceSpecificationReqEntity serviceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceCategoryId")
    @Basic
    @Column(name = "SERVICE_CATG_ID", length = 255)
    public String getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(String serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    /**
     *
     */
    public ServiceSpecificationReqEntity serviceSpecificationCharacteristic(List<ServiceSpecificationReqCharacteristicEntity> serviceSpecificationCharacteristic) {
        this.serviceSpecificationCharacteristic = serviceSpecificationCharacteristic;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceSpecificationCharacteristic")
    @OneToMany(targetEntity = ServiceSpecificationReqCharacteristicEntity.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_SPEC_REQ_ID")
    public List<ServiceSpecificationReqCharacteristicEntity> getServiceSpecificationCharacteristic() {
        return serviceSpecificationCharacteristic;
    }

    public void setServiceSpecificationCharacteristic(List<ServiceSpecificationReqCharacteristicEntity> serviceSpecificationCharacteristic) {
        this.serviceSpecificationCharacteristic = serviceSpecificationCharacteristic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceSpecificationReqEntity serviceSpecificationReq = (ServiceSpecificationReqEntity) o;
        return Objects.equals(id, serviceSpecificationReq.id)
                && Objects.equals(href, serviceSpecificationReq.href)
                && Objects.equals(serviceCategoryId, serviceSpecificationReq.serviceCategoryId)
                && Objects.equals(serviceSpecificationCharacteristic, serviceSpecificationReq.serviceSpecificationCharacteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, serviceCategoryId, serviceSpecificationCharacteristic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceSpecificationReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
        sb.append("    serviceSpecificationCharacteristic: ").append(toIndentedString(serviceSpecificationCharacteristic)).append("\n");
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
