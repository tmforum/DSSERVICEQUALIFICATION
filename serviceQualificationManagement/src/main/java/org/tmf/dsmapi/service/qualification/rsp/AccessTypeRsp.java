package org.tmf.dsmapi.service.qualification.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessTypeRsp implements Serializable {

    private final static long serialVersionUID = 11L;
    private String accessType = null;

    /**
     *
     */
    public AccessTypeRsp accessType(String accessType) {
        this.accessType = accessType;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("accessType")
    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccessTypeRsp accessTypeRsp = (AccessTypeRsp) o;
        return Objects.equals(accessType, accessTypeRsp.accessType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccessTypeRsp {\n");

        sb.append("    accessType: ").append(toIndentedString(accessType)).append("\n");
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
