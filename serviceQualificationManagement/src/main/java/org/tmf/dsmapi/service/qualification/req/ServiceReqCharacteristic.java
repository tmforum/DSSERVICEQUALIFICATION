package org.tmf.dsmapi.service.qualification.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.tmf.dsmapi.service.qualification.rsp.ServiceRspCharacteristic;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceReqCharacteristic")
@Table(name = "SERVICE_REQ_CHARACTERISTIC")
public class ServiceReqCharacteristic implements Serializable {

    private final static long serialVersionUID = 11L;

    private String name = null;
    private String value = null;

    protected Long hjid;
    
    /**
     * 
     * @return ServiceRspCharacteristic
     */
    public ServiceRspCharacteristic convert() {
        ServiceRspCharacteristic serviceRspCharacteristic = new ServiceRspCharacteristic();
        serviceRspCharacteristic.setName(name);
        serviceRspCharacteristic.setValue(value);
        
        return serviceRspCharacteristic;
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
    public ServiceReqCharacteristic name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("name")
    @Basic
    @Column(name = "NAME", length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public ServiceReqCharacteristic value(String value) {
        this.value = value;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("value")
    @Basic
    @Column(name = "VALUE", length = 255)
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
        ServiceReqCharacteristic serviceReqCharacteristic = (ServiceReqCharacteristic) o;
        return Objects.equals(name, serviceReqCharacteristic.name)
                && Objects.equals(value, serviceReqCharacteristic.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceReqCharacteristic {\n");

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
