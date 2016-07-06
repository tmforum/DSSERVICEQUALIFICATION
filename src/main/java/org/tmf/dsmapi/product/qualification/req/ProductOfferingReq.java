package org.tmf.dsmapi.product.qualification.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;
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
import org.tmf.dsmapi.product.qualification.model.ProductOffering;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductOfferingReq")
@Table(name = "PRODUCT_OFFERING_REQ")
public class ProductOfferingReq implements Serializable {

    private final static long serialVersionUID = 1L;

    private String id = null;
    private String href = null;
    private ProductOfferingCategoryReq productOfferingCategory = null;
    private ProductReq product = null;
    
    
    public ProductOffering convert() {
        ProductOffering prodOffering = new ProductOffering();
        prodOffering.setHref(href);
        if(productOfferingCategory != null) {
            prodOffering.setProductOfferingCategory(this.productOfferingCategory.convert());
        }
        if(product != null) {
            prodOffering.setProduct(product.convert());
        }
        return prodOffering;
    }

    /**
     *
     */
    public ProductOfferingReq id(String id) {
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
    public ProductOfferingReq href(String href) {
        this.href = href;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("href")
    @Basic
    @Column(name = "HREF", length = 512)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     */
    public ProductOfferingReq productOfferingCategory(ProductOfferingCategoryReq productOfferingCategory) {
        this.productOfferingCategory = productOfferingCategory;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOfferingCategory")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    public ProductOfferingCategoryReq getProductOfferingCategory() {
        return productOfferingCategory;
    }

    public void setProductOfferingCategory(ProductOfferingCategoryReq productOfferingCategory) {
        this.productOfferingCategory = productOfferingCategory;
    }

    /**
     *
     */
    public ProductOfferingReq product(ProductReq product) {
        this.product = product;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("product")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_ID")
    public ProductReq getProduct() {
        return product;
    }

    public void setProduct(ProductReq product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOfferingReq productOfferingReq = (ProductOfferingReq) o;
        return Objects.equals(id, productOfferingReq.id)
                && Objects.equals(href, productOfferingReq.href)
                && Objects.equals(productOfferingCategory, productOfferingReq.productOfferingCategory)
                && Objects.equals(product, productOfferingReq.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, productOfferingCategory, product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    productOfferingCategory: ").append(toIndentedString(productOfferingCategory)).append("\n");
        sb.append("    product: ").append(toIndentedString(product)).append("\n");
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
