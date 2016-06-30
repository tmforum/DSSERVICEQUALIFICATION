package org.tmf.dsmapi.product.qualification.model;

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
@Entity(name = "ProductOfferingQualificationItem")
@Table(name = "PRODUCT_OFFERING_QUALIFICATION_ITEM")
public class ProductOfferingQualificationItem implements Serializable {

    private final static long serialVersionUID = 1L;
    
    protected ProductOffering productOffering = null;
    protected OrderFeasibilityCheck orderFeasibilityCheck = null;
    
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
    public ProductOfferingQualificationItem productOffering(ProductOffering productOffering) {
        this.productOffering = productOffering;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOffering")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_OFFERING_ID")
    public ProductOffering getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOffering productOffering) {
        this.productOffering = productOffering;
    }

    /**
     *
     */
    public ProductOfferingQualificationItem orderFeasibilityCheck(OrderFeasibilityCheck orderFeasibilityCheck) {
        this.orderFeasibilityCheck = orderFeasibilityCheck;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("orderFeasibilityCheck")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_FEASIBILITY_CHECK_ID")
    public OrderFeasibilityCheck getOrderFeasibilityCheck() {
        return orderFeasibilityCheck;
    }

    public void setOrderFeasibilityCheck(OrderFeasibilityCheck orderFeasibilityCheck) {
        this.orderFeasibilityCheck = orderFeasibilityCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOfferingQualificationItem productOfferingQualificationItem = (ProductOfferingQualificationItem) o;
        return Objects.equals(productOffering, productOfferingQualificationItem.productOffering)
                && Objects.equals(orderFeasibilityCheck, productOfferingQualificationItem.orderFeasibilityCheck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOffering, orderFeasibilityCheck);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingQualificationItem {\n");

        sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
        sb.append("    orderFeasibilityCheck: ").append(toIndentedString(orderFeasibilityCheck)).append("\n");
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
