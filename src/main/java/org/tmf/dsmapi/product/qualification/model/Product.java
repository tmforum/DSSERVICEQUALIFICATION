package org.tmf.dsmapi.product.qualification.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.tmf.dsmapi.service.qualification.req.ServiceQualificationReqItem;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Product")
@Table(name = "PRODUCT")
public class Product implements Serializable {

    private final static long serialVersionUID = 1L;

    private ProductSpecification productSpecification = null;
    private List<ProductCharacteristic> productCharacteristic = null;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    protected Long hjid;

    /**
     *
     * @return possible object is {@link Long }
     *
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    public Product productSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productSpecification")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_SPEC_ID")
    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    /**
     *
     */
    public Product productCharacteristic(List<ProductCharacteristic> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productCharacteristic")
    @OneToMany(targetEntity = ProductCharacteristic.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_ID")
    public List<ProductCharacteristic> getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(List<ProductCharacteristic> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(productSpecification, product.productSpecification)
                && Objects.equals(productCharacteristic, product.productCharacteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productSpecification, productCharacteristic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");

        sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
        sb.append("    productCharacteristic: ").append(toIndentedString(productCharacteristic)).append("\n");
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
