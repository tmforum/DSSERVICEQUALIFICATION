package org.tmf.dsmapi.product.qualification.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductOfferingQualificationReqItem")
@Table(name = "PRODUCT_OFFERING_QUAL_REQ_ITEM")
public class ProductOfferingQualificationReqItemEntity implements Serializable {

    private final static long serialVersionUID = 1L;

    private ProductOfferingReqEntity productOffering = null;
    
    protected Long hjid;
    
    public ProductOfferingQualificationItem convert() {
        ProductOfferingQualificationItem item = new ProductOfferingQualificationItem();
        if(productOffering != null) {
            item.setProductOffering(productOffering.convert());
        }
        return item;
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
    public ProductOfferingQualificationReqItemEntity productOffering(ProductOfferingReqEntity productOffering) {
        this.productOffering = productOffering;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOffering")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_OFFERING_ID")
    public ProductOfferingReqEntity getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOfferingReqEntity productOffering) {
        this.productOffering = productOffering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOfferingQualificationReqItemEntity productOfferingQualificationReqItem = (ProductOfferingQualificationReqItemEntity) o;
        return Objects.equals(productOffering, productOfferingQualificationReqItem.productOffering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOffering);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingQualificationReqItem {\n");

        sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
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
