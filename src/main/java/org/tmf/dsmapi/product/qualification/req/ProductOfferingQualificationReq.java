package org.tmf.dsmapi.product.qualification.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.tmf.dsmapi.product.qualification.model.ProductOfferingQualification;
import org.tmf.dsmapi.product.qualification.model.ProductOfferingQualificationItem;
import org.tmf.dsmapi.product.qualification.rsp.ProductOfferingQualificationRsp;
import org.tmf.dsmapi.service.qualification.model.QualificationStateEnum;
import org.tmf.dsmapi.service.qualification.req.AddressDescriptionReq;
import org.tmf.dsmapi.service.qualification.req.AddressReq;
import org.tmf.dsmapi.service.qualification.req.GeoCodeReq;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ProductOfferingQualificationReq")
@Table(name = "PRODUCT_OFFERING_QUALIFICATION_REQ")
public class ProductOfferingQualificationReq implements Serializable {

    private final static long serialVersionUID = 1L;

    protected String id = null;
    protected String href = null;
    protected String provideOnlyAvailable = null;
    protected String provideUnavailabilityReason = null;
    protected QualificationStateEnum qualificationState = null;
    protected Date interactionDate = null;
    protected String description = null;
    protected Date eligibilityDate = null;
    protected List<RelatedPartyReq> relatedParty = null;
    protected String channel = null;
    protected String productInventoryId = null;
    protected AddressReq address = null;
    protected AddressDescriptionReq addressDescription = null;
    protected GeoCodeReq geoCode = null;
    protected String publicKey = null;
    protected List<ProductOfferingQualificationReqItem> productOfferingQualificationItem = null;
    

    public ProductOfferingQualification convert() {
        ProductOfferingQualification qualification = new ProductOfferingQualification();
        qualification.setReq(this);
        if (address != null) {
            qualification.setAddressId(address.getId());
        }
        //qualification.setId(id);
        qualification.setEligibilityDate(eligibilityDate);
        qualification.setChannel(channel);
        qualification.setProductInventoryId(productInventoryId);
        qualification.setPublicKey(publicKey);
        //qualification.setProductOfferingQualificationItem(productOfferingQualificationItem);
        if(productOfferingQualificationItem  != null && productOfferingQualificationItem.size() > 0) {
            List<ProductOfferingQualificationItem> itemList = new ArrayList<>();
            for(ProductOfferingQualificationReqItem item : productOfferingQualificationItem) {
                itemList.add(item.convert());
            }
            qualification.setProductOfferingQualificationItem(itemList);
        }
        return qualification;
    }
    
        
    /**
     * 
     * @return 
     */
    public ProductOfferingQualificationRsp convertRsp() {
        ProductOfferingQualificationRsp rsp = new ProductOfferingQualificationRsp();
        rsp.setId(id);
        rsp.setHref(href);
        rsp.setProvideOnlyAvailable(provideOnlyAvailable);
        rsp.setProvideUnavailabilityReason(provideUnavailabilityReason);
        rsp.setQualificationState(qualificationState);
        rsp.setInteractionDate(interactionDate);
        rsp.setDescription(description);
        rsp.setEligibilityDate(eligibilityDate);
        rsp.setRelatedParty(relatedParty);
        rsp.setChannel(channel);
        rsp.setProductInventoryId(productInventoryId);
        rsp.setAddress(address);
        rsp.setAddressDescription(addressDescription);
        rsp.setGeoCode(geoCode);
        rsp.setPublicKey(publicKey);
        
        return rsp;
    }
    
    
    /**
     *
     */
    public ProductOfferingQualificationReq id(String id) {
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
    public ProductOfferingQualificationReq href(String href) {
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
    
    @ApiModelProperty(value = "")
    @JsonProperty("provideOnlyAvailable")
    @Basic
    @Column(name = "PROVIDE_ONLY_AVAILABLE", length = 16)
    public String getProvideOnlyAvailable() {
        return provideOnlyAvailable;
    }

    public void setProvideOnlyAvailable(String provideOnlyAvailable) {
        this.provideOnlyAvailable = provideOnlyAvailable;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("provideUnavailabilityReason")
    @Basic
    @Column(name = "PROVIDE_UNAVAILABLILITY_REASON", length = 512)
    public String getProvideUnavailabilityReason() {
        return provideUnavailabilityReason;
    }

    public void setProvideUnavailabilityReason(String provideUnavailabilityReason) {
        this.provideUnavailabilityReason = provideUnavailabilityReason;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("qualificationState")
    @Basic
    @Column(name = "QUALIFICATION_STATE", length = 32)
    public QualificationStateEnum getQualificationState() {
        return qualificationState;
    }

    public void setQualificationState(QualificationStateEnum qualificationState) {
        this.qualificationState = qualificationState;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("interactionDate")
    @Basic
    @Column(name = "INTERACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("description")
    @Basic
    @Column(name = "DESCRIPTION", length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     */
    public ProductOfferingQualificationReq eligibilityDate(Date eligibilityDate) {
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
    public ProductOfferingQualificationReq relatedParty(List<RelatedPartyReq> relatedParty) {
        this.relatedParty = relatedParty;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("relatedParty")
    @OneToMany(targetEntity = RelatedPartyReq.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_OFFERING_QUALIFICATION_ID")
    public List<RelatedPartyReq> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedPartyReq> relatedParty) {
        this.relatedParty = relatedParty;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq channel(String channel) {
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
    public ProductOfferingQualificationReq productInventoryId(String productInventoryId) {
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
    public ProductOfferingQualificationReq address(AddressReq address) {
        this.address = address;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("address")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_ID")
    public AddressReq getAddress() {
        return address;
    }

    public void setAddress(AddressReq address) {
        this.address = address;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq addressDescription(AddressDescriptionReq addressDescription) {
        this.addressDescription = addressDescription;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("addressDescription")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_DESC_ID")
    public AddressDescriptionReq getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(AddressDescriptionReq addressDescription) {
        this.addressDescription = addressDescription;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq geoCode(GeoCodeReq geoCode) {
        this.geoCode = geoCode;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("geoCode")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GEO_CODE_ID")
    public GeoCodeReq getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCodeReq geoCode) {
        this.geoCode = geoCode;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("publicKey")
    @Basic
    @Column(name = "PUBLIC_KEY", length = 255)
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq productOfferingQualificationItem(List<ProductOfferingQualificationReqItem> productOfferingQualificationItem) {
        this.productOfferingQualificationItem = productOfferingQualificationItem;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOfferingQualificationItem")
    @OneToMany(targetEntity = ProductOfferingQualificationReqItem.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_OFFERING_QUALIFICATION_ID")
    public List<ProductOfferingQualificationReqItem> getProductOfferingQualificationItem() {
        return productOfferingQualificationItem;
    }

    public void setProductOfferingQualificationItem(List<ProductOfferingQualificationReqItem> productOfferingQualificationItem) {
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
        ProductOfferingQualificationReq productOfferingQualificationReq = (ProductOfferingQualificationReq) o;
        return Objects.equals(id, productOfferingQualificationReq.id)
                && Objects.equals(eligibilityDate, productOfferingQualificationReq.eligibilityDate)
                && Objects.equals(relatedParty, productOfferingQualificationReq.relatedParty)
                && Objects.equals(channel, productOfferingQualificationReq.channel)
                && Objects.equals(productInventoryId, productOfferingQualificationReq.productInventoryId)
                && Objects.equals(address, productOfferingQualificationReq.address)
                && Objects.equals(addressDescription, productOfferingQualificationReq.addressDescription)
                && Objects.equals(geoCode, productOfferingQualificationReq.geoCode)
                && Objects.equals(publicKey, productOfferingQualificationReq.publicKey)
                && Objects.equals(productOfferingQualificationItem, productOfferingQualificationReq.productOfferingQualificationItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eligibilityDate, relatedParty, channel, productInventoryId, address, addressDescription, geoCode, publicKey, productOfferingQualificationItem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductOfferingQualificationReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    eligibilityDate: ").append(toIndentedString(eligibilityDate)).append("\n");
        sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    productInventoryId: ").append(toIndentedString(productInventoryId)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    addressDescription: ").append(toIndentedString(addressDescription)).append("\n");
        sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
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
