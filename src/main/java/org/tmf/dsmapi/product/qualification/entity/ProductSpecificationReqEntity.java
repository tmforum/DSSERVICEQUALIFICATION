package org.tmf.dsmapi.product.qualification.entity;

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
@Entity(name = "ProductSpecificationReq")
@Table(name = "PRODUCT_SPEC_REQ")
public class ProductSpecificationReqEntity implements Serializable {

    private final static long serialVersionUID = 1L;

    private String id = null;
    private String name = null;
    private String version = null;
    private String value = null;
    
    public ProductSpecification convert() {
        ProductSpecification prodSpec = new ProductSpecification();
        prodSpec.setName(name);
        prodSpec.setVersion(version);
        prodSpec.setValue(value);
        return prodSpec;
    }

    /**
     *
     */
    public ProductSpecificationReqEntity id(String id) {
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
    public ProductSpecificationReqEntity name(String name) {
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
    public ProductSpecificationReqEntity version(String version) {
        this.version = version;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("version")
    @Basic
    @Column(name = "VERSION", length = 10)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     */
    public ProductSpecificationReqEntity value(String value) {
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
        ProductSpecificationReqEntity productSpecificationReq = (ProductSpecificationReqEntity) o;
        return Objects.equals(id, productSpecificationReq.id)
                && Objects.equals(name, productSpecificationReq.name)
                && Objects.equals(version, productSpecificationReq.version)
                && Objects.equals(value, productSpecificationReq.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, version, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductSpecificationReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
