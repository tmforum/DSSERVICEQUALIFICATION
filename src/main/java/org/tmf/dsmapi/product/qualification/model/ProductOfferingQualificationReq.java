package org.tmf.dsmapi.product.qualification.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.tmf.dsmapi.service.qualification.model.Address;
import org.tmf.dsmapi.service.qualification.model.AddressDescription;
import org.tmf.dsmapi.service.qualification.model.GeoCode;

public class ProductOfferingQualificationReq {

    private String id = null;
    private Date eligibilityDate = null;
    private List<RelatedParty> relatedParty = null;
    private String channel = null;
    private String productInventoryId = null;
    private Address address = null;
    private AddressDescription addressDescription = null;
    private GeoCode geoCode = null;
    private String publicKey = null;
    private List<ProductOfferingQualificationItem> productOfferingQualificationItem = null;

    /**
     *
     */
    public ProductOfferingQualificationReq id(String id) {
        this.id = id;
        return this;
    }

    public ProductOfferingQualification convert() {
        ProductOfferingQualification qualification = new ProductOfferingQualification();
        //qualification.setReq(this);
        if (address != null) {
            qualification.setAddressId(address.getId());
        }
        qualification.setId(id);
        qualification.setEligibilityDate(eligibilityDate);
        qualification.setChannel(channel);
        qualification.setProductInventoryId(productInventoryId);
        qualification.setPublicKey(publicKey);
        qualification.setProductOfferingQualificationItem(productOfferingQualificationItem);
        return qualification;
    }

    public List<ProductOfferingQualification> convertList() {
        List<ProductOfferingQualification> qualificationList = new ArrayList<>();
        if (relatedParty == null || relatedParty.isEmpty()) {
            return qualificationList;
        }
        ProductOfferingQualification qualification = null;
        for (RelatedParty party : this.relatedParty) {
            qualification = convert();
            if (party != null) {
                qualification.setRelatedPartyId(party.getId());
            }
        }
        return qualificationList;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public Date getEligibilityDate() {
        return eligibilityDate;
    }

    public void setEligibilityDate(Date eligibilityDate) {
        this.eligibilityDate = eligibilityDate;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq relatedParty(List<RelatedParty> relatedParty) {
        this.relatedParty = relatedParty;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("RelatedParty")
    public List<RelatedParty> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedParty> relatedParty) {
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
    public String getProductInventoryId() {
        return productInventoryId;
    }

    public void setProductInventoryId(String productInventoryId) {
        this.productInventoryId = productInventoryId;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq address(Address address) {
        this.address = address;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq addressDescription(AddressDescription addressDescription) {
        this.addressDescription = addressDescription;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("addressDescription")
    public AddressDescription getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(AddressDescription addressDescription) {
        this.addressDescription = addressDescription;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq geoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("geoCode")
    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
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
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     *
     */
    public ProductOfferingQualificationReq productOfferingQualificationItem(List<ProductOfferingQualificationItem> productOfferingQualificationItem) {
        this.productOfferingQualificationItem = productOfferingQualificationItem;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productOfferingQualificationItem")
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
