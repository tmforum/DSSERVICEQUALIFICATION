package org.tmf.dsmapi.service.qualification.enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"valueFromNumber","valueFromUnit","valueToNumber","valueToUnit"}) 
@Entity(name = "ServiceSpecCharacteristic")
@Table(name = "SERVICE_SPEC_CHARACTERISTIC")
public class ServiceSpecificationCharacteristicEntity implements Serializable {

    private final static long serialVersionUID = 11L;

    protected String id = null;
    protected String name = null;
    protected String valuefrom = null;
    protected String valueto = null;
    
    @JsonIgnore
    protected Long valueFromNumber = null;
    
    @JsonIgnore
    protected String valueFromUnit = null;
    
    @JsonIgnore
    protected Long valueToNumber = null;
    
    @JsonIgnore
    protected String valueToUnit = null;

    
    @Basic
    @Column(name = "VALUE_FROM_NUM")
    public Long getValueFromNumber() {
        return valueFromNumber;
    }

    public void setValueFromNumber(Long valueFromNumber) {
        this.valueFromNumber = valueFromNumber;
    }

    
    @Basic
    @Column(name = "VALUE_FROM_UNIT", length = 20)
    public String getValueFromUnit() {
        return valueFromUnit;
    }

    public void setValueFromUnit(String valueFromUnit) {
        this.valueFromUnit = valueFromUnit;
    }
    
    
    @Basic
    @Column(name = "VALUE_TO_NUM")
    public Long getValueToNumber() {
        return valueToNumber;
    }

    public void setValueToNumber(Long valueToNumber) {
        this.valueToNumber = valueToNumber;
    }
    
    
    @Basic
    @Column(name = "VALUE_TO_UNIT", length = 20)
    public String getValueToUnit() {
        return valueToUnit;
    }

    public void setValueToUnit(String valueToUnit) {
        this.valueToUnit = valueToUnit;
    }

    /**
     *
     * @return possible object is {@link Long }
     *
     */
    @ApiModelProperty(value = "")
    @JsonProperty("id")
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    /**
     *
     * @param value allowed object is {@link Long }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     *
     * @param id
     * @return
     */
    public ServiceSpecificationCharacteristicEntity id(String id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @param name
     * @return
     */
    public ServiceSpecificationCharacteristicEntity name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "name")
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
     * @param valuefrom
     * @return
     */
    public ServiceSpecificationCharacteristicEntity valuefrom(String valuefrom) {
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
     * @param valueto
     * @return
     */
    public ServiceSpecificationCharacteristicEntity valueto(String valueto) {
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
        ServiceSpecificationCharacteristicEntity serviceSpecificationCharacteristic = (ServiceSpecificationCharacteristicEntity) o;
        return Objects.equals(id, serviceSpecificationCharacteristic.id)
                && Objects.equals(name, serviceSpecificationCharacteristic.name)
                && Objects.equals(valuefrom, serviceSpecificationCharacteristic.valuefrom)
                && Objects.equals(valueto, serviceSpecificationCharacteristic.valueto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, valuefrom, valueto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceSpecificationCharacteristic {\n");

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
