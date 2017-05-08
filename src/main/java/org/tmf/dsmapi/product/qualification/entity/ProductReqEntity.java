package org.tmf.dsmapi.product.qualification.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductReq")
@Table(name = "PRODUCT_REQ")
public class ProductReqEntity {

    private ProductSpecificationReqEntity productSpecification = null;
    private List<ProductCharacteristicReqEntity> productCharacteristic = null;

    protected Long hjid;
    
    
    public Product convert() {
        Product prod = new Product();
        if(productSpecification != null) {
            prod.setProductSpecification(productSpecification.convert());
        }
        if(productCharacteristic != null && productCharacteristic.size() > 0) {
            List<ProductCharacteristic> chList = new ArrayList<>(); 
            for(ProductCharacteristicReqEntity req: productCharacteristic) {
                chList.add(req.convert());
            }
            prod.setProductCharacteristic(chList);
        }
        return prod;
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
    public ProductReqEntity productSpecification(ProductSpecificationReqEntity productSpecification) {
        this.productSpecification = productSpecification;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productSpecification")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_SPEC_ID")
    public ProductSpecificationReqEntity getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecificationReqEntity productSpecification) {
        this.productSpecification = productSpecification;
    }

    /**
     *
     */
    public ProductReqEntity productCharacteristic(List<ProductCharacteristicReqEntity> productCharacteristic) {
        this.productCharacteristic = productCharacteristic;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productCharacteristic")
    @OneToMany(targetEntity = ProductCharacteristicReqEntity.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_ID")
    public List<ProductCharacteristicReqEntity> getProductCharacteristic() {
        return productCharacteristic;
    }

    public void setProductCharacteristic(List<ProductCharacteristicReqEntity> productCharacteristic) {
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
        ProductReqEntity productReq = (ProductReqEntity) o;
        return Objects.equals(productSpecification, productReq.productSpecification)
                && Objects.equals(productCharacteristic, productReq.productCharacteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productSpecification, productCharacteristic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductReq {\n");

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
