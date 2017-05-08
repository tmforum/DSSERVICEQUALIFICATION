package org.tmf.dsmapi.product.qualification.entity;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductOffering")
@Table(name = "PRODUCT_OFFERING")
public class ProductOffering implements Serializable {

    private final static long serialVersionUID = 1L;
    
    private String id = null;
    private String href = null;
    private ProductOfferingCategory productOfferingCategory = null;
    private Product product = null;

    /**
     *
     */
    public ProductOffering id(String id) {
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
    public ProductOffering href(String href) {
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
    public ProductOffering productOfferingCategory(ProductOfferingCategory productOfferingCategory) {
        this.productOfferingCategory = productOfferingCategory;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOfferingCategory")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    public ProductOfferingCategory getProductOfferingCategory() {
        return productOfferingCategory;
    }

    public void setProductOfferingCategory(ProductOfferingCategory productOfferingCategory) {
        this.productOfferingCategory = productOfferingCategory;
    }

    /**
     *
     */
    public ProductOffering product(Product product) {
        this.product = product;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("product")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
        ProductOffering productOffering = (ProductOffering) o;
        return Objects.equals(id, productOffering.id)
                && Objects.equals(href, productOffering.href)
                && Objects.equals(productOfferingCategory, productOffering.productOfferingCategory)
                && Objects.equals(product, productOffering.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, productOfferingCategory, product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOffering {\n");

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
