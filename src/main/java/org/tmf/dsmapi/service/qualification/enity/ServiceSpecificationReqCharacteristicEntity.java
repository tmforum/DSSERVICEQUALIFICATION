package org.tmf.dsmapi.service.qualification.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceSpecReqCharateristic")
@Table(name = "SERVICE_SPEC_REQ_CHARACTERISTIC")
public class ServiceSpecificationReqCharacteristicEntity implements Serializable {

    private final static long serialVersionUID = 11L;

    protected String id = null;
    protected String name = null;
    protected String valuefrom = null;
    protected String valueto = null;

    /**
     *
     */
    public ServiceSpecificationReqCharacteristicEntity id(String id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("id")
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     */
    public ServiceSpecificationReqCharacteristicEntity name(String name) {
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
    public ServiceSpecificationReqCharacteristicEntity valuefrom(String valuefrom) {
        this.valuefrom = valuefrom;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("valuefrom")
    @Basic
    @Column(name = "VALUE_FROM", length = 255)
    public String getValuefrom() {
        return valuefrom;
    }

    public void setValuefrom(String valuefrom) {
        this.valuefrom = valuefrom;
    }

    /**
     *
     */
    public ServiceSpecificationReqCharacteristicEntity valueto(String valueto) {
        this.valueto = valueto;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("valueto")
    @Basic
    @Column(name = "VALUE_TO", length = 255)
    public String getValueto() {
        return valueto;
    }

    public void setValueto(String valueto) {
        this.valueto = valueto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceSpecificationReqCharacteristicEntity serviceSpecificationReqCharacteristic = (ServiceSpecificationReqCharacteristicEntity) o;
        return Objects.equals(id, serviceSpecificationReqCharacteristic.id)
                && Objects.equals(name, serviceSpecificationReqCharacteristic.name)
                && Objects.equals(valuefrom, serviceSpecificationReqCharacteristic.valuefrom)
                && Objects.equals(valueto, serviceSpecificationReqCharacteristic.valueto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, valuefrom, valueto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceSpecificationReqCharacteristic {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    valuefrom: ").append(toIndentedString(valuefrom)).append("\n");
        sb.append("    valueto: ").append(toIndentedString(valueto)).append("\n");
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
