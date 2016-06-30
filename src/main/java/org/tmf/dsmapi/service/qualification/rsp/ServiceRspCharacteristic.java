package org.tmf.dsmapi.service.qualification.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceRspCharacteristic implements Serializable {

    private final static long serialVersionUID = 11L;

    private String name = null;
    private String value = null;

    /**
     *
     */
    public ServiceRspCharacteristic name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public ServiceRspCharacteristic value(String value) {
        this.value = value;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceRspCharacteristic serviceRspCharacteristic = (ServiceRspCharacteristic) o;
        return Objects.equals(name, serviceRspCharacteristic.name)
                && Objects.equals(value, serviceRspCharacteristic.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceRspCharacteristic {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
