package org.tmf.dsmapi.service.qualification.rsp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceQualificationItemRsp implements Serializable {

    private final static long serialVersionUID = 11L;

    private ServiceRsp service = null;
    private List<ServiceRsp> alternativeService = null;
    private String availability = null;
    private Date serviceabilityDate = null;

    /**
     *
     */
    public ServiceQualificationItemRsp service(ServiceRsp service) {
        this.service = service;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("service")
    public ServiceRsp getService() {
        return service;
    }

    public void setService(ServiceRsp service) {
        this.service = service;
    }

    /**
     *
     */
    public ServiceQualificationItemRsp alternativeService(List<ServiceRsp> alternativeService) {
        this.alternativeService = alternativeService;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("alternativeService")
    public List<ServiceRsp> getAlternativeService() {
        return alternativeService;
    }

    public void setAlternativeService(List<ServiceRsp> alternativeService) {
        this.alternativeService = alternativeService;
    }

    /**
     *
     */
    public ServiceQualificationItemRsp availability(String availability) {
        this.availability = availability;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("availability")
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     *
     */
    public ServiceQualificationItemRsp serviceabilityDate(Date serviceabilityDate) {
        this.serviceabilityDate = serviceabilityDate;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceabilityDate")
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
        ServiceQualificationItemRsp serviceQualificationItemRsp = (ServiceQualificationItemRsp) o;
        return Objects.equals(service, serviceQualificationItemRsp.service)
                && Objects.equals(alternativeService, serviceQualificationItemRsp.alternativeService)
                && Objects.equals(availability, serviceQualificationItemRsp.availability)
                && Objects.equals(serviceabilityDate, serviceQualificationItemRsp.serviceabilityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service, alternativeService, availability, serviceabilityDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceQualificationItemRsp {\n");

        sb.append("    service: ").append(toIndentedString(service)).append("\n");
        sb.append("    alternativeService: ").append(toIndentedString(alternativeService)).append("\n");
        sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
        sb.append("    serviceabilityDate: ").append(toIndentedString(serviceabilityDate)).append("\n");
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
