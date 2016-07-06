package org.tmf.dsmapi.service.qualification.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceRsp implements Serializable {

    private final static long serialVersionUID = 11L;

    private List<ServiceRspCharacteristic> serviceCharacteristic = null;
    private ServiceSpecification serviceSpecification = null;

    /**
     *
     */
    public ServiceRsp serviceCharacteristic(List<ServiceRspCharacteristic> serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceCharacteristic")
    public List<ServiceRspCharacteristic> getServiceCharacteristic() {
        return serviceCharacteristic;
    }

    public void setServiceCharacteristic(List<ServiceRspCharacteristic> serviceCharacteristic) {
        this.serviceCharacteristic = serviceCharacteristic;
    }

    /**
     *
     */
    public ServiceRsp serviceSpecification(ServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceSpecification")
    public ServiceSpecification getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(ServiceSpecification serviceSpecification) {
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
        ServiceRsp serviceRsp = (ServiceRsp) o;
        return Objects.equals(serviceCharacteristic, serviceRsp.serviceCharacteristic)
                && Objects.equals(serviceSpecification, serviceRsp.serviceSpecification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceCharacteristic, serviceSpecification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceRsp {\n");

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
