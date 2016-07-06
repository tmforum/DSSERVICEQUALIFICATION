package org.tmf.dsmapi.product.qualification.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.tmf.dsmapi.product.qualification.model.ProductCharacteristic;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductCharacteristicReq")
@Table(name = "PRODUCT_CHARACTERISTIC_REQ")
public class ProductCharacteristicReq {

    private String id = null;
    private String name = null;
    private String value = null;
    
    
    public ProductCharacteristic convert() {
        ProductCharacteristic ch = new ProductCharacteristic();
        ch.setName(name);
        ch.setValue(value);
        return ch;
    }

    /**
     *
     */
    public ProductCharacteristicReq id(String id) {
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
    public ProductCharacteristicReq name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("name")
    @Basic
    @Column(name = "NAME", length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public ProductCharacteristicReq value(String value) {
        this.value = value;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("value")
    @Basic
    @Column(name = "VALUE", length = 128)
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
        ProductCharacteristicReq productCharacteristicReq = (ProductCharacteristicReq) o;
        return Objects.equals(id, productCharacteristicReq.id)
                && Objects.equals(name, productCharacteristicReq.name)
                && Objects.equals(value, productCharacteristicReq.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductCharacteristicReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
