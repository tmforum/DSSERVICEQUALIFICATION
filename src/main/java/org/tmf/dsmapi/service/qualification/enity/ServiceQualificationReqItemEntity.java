package org.tmf.dsmapi.service.qualification.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.tmf.dsmapi.service.qualification.model.ServiceReq;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceQualificationReqItem")
@Table(name = "SERVICE_QUALIFICATION_REQ_ITEM")
public class ServiceQualificationReqItemEntity implements Serializable {

    private final static long serialVersionUID = 11L;

    private ServiceReqEntity service = null;

    protected String availability = null;
    protected Date serviceabilityDate = null;

    protected Long hjid;

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
     * @param service
     * @return
     */
    public ServiceQualificationReqItemEntity service(ServiceReqEntity service) {
        this.service = service;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("service")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_REQ_ID")
    public ServiceReqEntity getService() {
        return service;
    }

    public void setService(ServiceReqEntity service) {
        this.service = service;
    }

    /**
     *
     */
    public ServiceQualificationReqItemEntity availability(String availability) {
        this.availability = availability;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("availability")
    @Basic
    @Column(name = "AVAILABILITY", length = 10)
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     *
     */
    public ServiceQualificationReqItemEntity serviceabilityDate(Date serviceabilityDate) {
        this.serviceabilityDate = serviceabilityDate;
        return this;
    }

    /**
     *
     * @return
     */
    @ApiModelProperty(value = "")
    @JsonProperty("serviceabilityDate")
    @Basic
    @Column(name = "SERVICEABILITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getServiceabilityDate() {
        return serviceabilityDate;
    }

    public void setServiceabilityDate(Date serviceabilityDate) {
        this.serviceabilityDate = serviceabilityDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceQualificationReqItemEntity serviceQualificationItemReq = (ServiceQualificationReqItemEntity) o;
        return Objects.equals(service, serviceQualificationItemReq.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceQualificationItemReq {\n");

        sb.append("    service: ").append(toIndentedString(service)).append("\n");
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
