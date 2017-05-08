package org.tmf.dsmapi.product.qualification.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationReqEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductOfferingQualification")
@Table(name = "PRODUCT_OFFERING_QUALIFICATION")
public class ProductOfferingQualification implements Serializable {

    private final static long serialVersionUID = 1L;  
    
    protected String id = null;
    protected String href = null;
    protected Date eligibilityDate = null;
    protected String relatedPartyId = null;
    protected String channel = null;
    protected String productInventoryId = null;
    protected String addressId = null;
    protected String addressDescId = null;
    protected String geoCodeId = null;
    protected String publicKey = null;
    protected List<ProductOfferingQualificationItem> productOfferingQualificationItem = null;
    
    protected ProductOfferingQualificationReqEntity req = null;
    
    public void reset() {
        this.id = null;
        this.href = null;
        this.eligibilityDate = null;
    }

    @Transient
    public ProductOfferingQualificationReqEntity getReq() {
        return req;
    }

    public void setReq(ProductOfferingQualificationReqEntity req) {
        this.req = req;
    }

    /**
     *
     */
    public ProductOfferingQualification id(String id) {
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
    public ProductOfferingQualification href(String href) {
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
    public ProductOfferingQualification eligibilityDate(Date eligibilityDate) {
        this.eligibilityDate = eligibilityDate;
        return this;
    }

    

    @ApiModelProperty(value = "")
    @JsonProperty("eligibilityDate")
    @Basic
    @Column(name = "ELIGIBILITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEligibilityDate() {
        return eligibilityDate;
    }

    public void setEligibilityDate(Date eligibilityDate) {
        this.eligibilityDate = eligibilityDate;
    }

    /**
     *
     */
    public ProductOfferingQualification relatedParty(String relatedPartyId) {
        this.relatedPartyId = relatedPartyId;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("RelatedPartyId")
    @Basic
    @Column(name = "RELATED_PARTY_ID", length=30)
    public String getRelatedPartyId() {
        return relatedPartyId;
    }

    public void setRelatedPartyId(String relatedPartyId) {
        this.relatedPartyId = relatedPartyId;
    }

    /**
     *
     */
    public ProductOfferingQualification channel(String channel) {
        this.channel = channel;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("channel")
    @Basic
    @Column(name = "CHANNEL", length = 128)
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     *
     */
    public ProductOfferingQualification productInventoryId(String productInventoryId) {
        this.productInventoryId = productInventoryId;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productInventoryId")
    @Basic
    @Column(name = "PRODUCT_INVENTORY_ID", length=30)
    public String getProductInventoryId() {
        return productInventoryId;
    }

    public void setProductInventoryId(String productInventoryId) {
        this.productInventoryId = productInventoryId;
    }

    /**
     *
     */
    public ProductOfferingQualification addressId(String addressId) {
        this.addressId = addressId;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("addressId")
    @Basic
    @Column(name = "ADDRESS_ID", length=30)
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     *
     */
    public ProductOfferingQualification addressDescId(String addressDescId) {
        this.addressDescId = addressDescId;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("addressDescId")
    @Basic
    @Column(name = "ADDRESS_DESC_ID", length=30)
    public String getAddressDescId() {
        return addressDescId;
    }

    public void setAddressDescId(String addressDescId) {
        this.addressDescId = addressDescId;
    }

    /**
     *
     */
    public ProductOfferingQualification geoCodeId(String geoCodeId) {
        this.geoCodeId = geoCodeId;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("geoCodeId")
    @Basic
    @Column(name = "GEO_CODE_ID", length=30)
    public String getGeoCodeId() {
        return geoCodeId;
    }

    public void setGeoCodeId(String geoCodeId) {
        this.geoCodeId = geoCodeId;
    }

    /**
     *
     */
    public ProductOfferingQualification publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("publicKey")
    @Basic
    @Column(name = "PUBLIC_KEY", length=128)
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     *
     */
    public ProductOfferingQualification productOfferingQualificationItem(List<ProductOfferingQualificationItem> productOfferingQualificationItem) {
        this.productOfferingQualificationItem = productOfferingQualificationItem;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOfferingQualificationItem")
    @OneToMany(targetEntity = ProductOfferingQualificationItem.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_OFFERING_QUALIFICATION_ID")
    public List<ProductOfferingQualificationItem> getProductOfferingQualificationItem() {
        return productOfferingQualificationItem;
    }

    public void setProductOfferingQualificationItem(List<ProductOfferingQualificationItem> productOfferingQualificationItem) {
        this.productOfferingQualificationItem = productOfferingQualificationItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductOfferingQualification productOfferingQualification = (ProductOfferingQualification) o;
        return Objects.equals(id, productOfferingQualification.id)
                && Objects.equals(eligibilityDate, productOfferingQualification.eligibilityDate)
                && Objects.equals(relatedPartyId, productOfferingQualification.relatedPartyId)
                && Objects.equals(channel, productOfferingQualification.channel)
                && Objects.equals(productInventoryId, productOfferingQualification.productInventoryId)
                && Objects.equals(addressId, productOfferingQualification.addressId)
                && Objects.equals(addressDescId, productOfferingQualification.addressDescId)
                && Objects.equals(geoCodeId, productOfferingQualification.geoCodeId)
                && Objects.equals(publicKey, productOfferingQualification.publicKey)
                && Objects.equals(productOfferingQualificationItem, productOfferingQualification.productOfferingQualificationItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eligibilityDate, relatedPartyId, channel, productInventoryId, addressId, addressDescId, geoCodeId, publicKey, productOfferingQualificationItem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingQualification {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    eligibilityDate: ").append(toIndentedString(eligibilityDate)).append("\n");
        sb.append("    relatedParty: ").append(toIndentedString(relatedPartyId)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    productInventoryId: ").append(toIndentedString(productInventoryId)).append("\n");
        sb.append("    addressId: ").append(toIndentedString(addressId)).append("\n");
        sb.append("    addressDescId: ").append(toIndentedString(addressDescId)).append("\n");
        sb.append("    geoCodeId: ").append(toIndentedString(geoCodeId)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    productOfferingQualificationItem: ").append(toIndentedString(productOfferingQualificationItem)).append("\n");
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
