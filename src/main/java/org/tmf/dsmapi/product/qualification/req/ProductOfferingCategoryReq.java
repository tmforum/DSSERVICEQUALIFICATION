package org.tmf.dsmapi.product.qualification.req;

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
import org.tmf.dsmapi.product.qualification.model.ProductOfferingCategory;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductOfferingCategoryReq")
@Table(name = "PRODUCT_OFFERING_CAT_REQ")
public class ProductOfferingCategoryReq implements Serializable {

    private final static long serialVersionUID = 1L;

    private String id = null;
    
    protected Long hjid;
    
    public ProductOfferingCategory convert() {
        ProductOfferingCategory category = new ProductOfferingCategory();
        category.setId(id);
        return category;
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
    public ProductOfferingCategoryReq id(String id) {
        this.id = id;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("id")
    @Basic
    @Column(name = "ID", length = 128)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOfferingCategoryReq productOfferingCategoryReq = (ProductOfferingCategoryReq) o;
        return Objects.equals(id, productOfferingCategoryReq.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingCategoryReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
