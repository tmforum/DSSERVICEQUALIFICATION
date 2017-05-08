package org.tmf.dsmapi.product.qualification.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import org.tmf.dsmapi.product.qualification.entity.ProductOfferingQualificationItem;
import org.tmf.dsmapi.product.qualification.entity.RelatedPartyReqEntity;
import org.tmf.dsmapi.service.qualification.model.AddressDescriptionReq;
import org.tmf.dsmapi.service.qualification.model.AddressReq;
import org.tmf.dsmapi.service.qualification.model.GeoCodeReq;
import org.tmf.dsmapi.service.qualification.model.ServiceQualificationRsp.QualificationStateEnum;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value={"id","href","interactionDate",
    "description","eligibilityDate","qualificationState",
    "relatedParty","provideOnlyAvailable","provideUnavailabilityReason",
    "channel", "address", "productOfferingQualificationItem"})
public class ProductOfferingQualificationRsp implements Serializable {

    private final static long serialVersionUID = 1L;

    protected String id = null;
    protected String href = null;
    protected String provideOnlyAvailable = null;
    protected String provideUnavailabilityReason = null;
    protected QualificationStateEnum qualificationState = null;
    protected Date interactionDate = null;
    protected String description = null;
    protected Date eligibilityDate = null;
    protected List<RelatedPartyReqEntity> relatedParty = null;
    protected String channel = null;
    protected String productInventoryId = null;
    protected AddressReq address = null;
    protected AddressDescriptionReq addressDescription = null;
    protected GeoCodeReq geoCode = null;
    protected String publicKey = null;
    protected List<ProductOfferingQualificationItem> productOfferingQualificationItem = null;


    @ApiModelProperty(value = "")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    


    @ApiModelProperty(value = "")
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("provideOnlyAvailable")
    public String getProvideOnlyAvailable() {
        return provideOnlyAvailable;
    }

    public void setProvideOnlyAvailable(String provideOnlyAvailable) {
        this.provideOnlyAvailable = provideOnlyAvailable;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("provideUnavailabilityReason")
    public String getProvideUnavailabilityReason() {
        return provideUnavailabilityReason;
    }

    public void setProvideUnavailabilityReason(String provideUnavailabilityReason) {
        this.provideUnavailabilityReason = provideUnavailabilityReason;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("qualificationState")
    public QualificationStateEnum getQualificationState() {
        return qualificationState;
    }

    public void setQualificationState(QualificationStateEnum qualificationState) {
        this.qualificationState = qualificationState;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("interactionDate")
    public Date getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }
    
    @ApiModelProperty(value = "")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("eligibilityDate")
    public Date getEligibilityDate() {
        return eligibilityDate;
    }

    public void setEligibilityDate(Date eligibilityDate) {
        this.eligibilityDate = eligibilityDate;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("relatedParty")
    public List<RelatedPartyReqEntity> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedPartyReqEntity> relatedParty) {
        this.relatedParty = relatedParty;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("productInventoryId")
    public String getProductInventoryId() {
        return productInventoryId;
    }

    public void setProductInventoryId(String productInventoryId) {
        this.productInventoryId = productInventoryId;
    }



    @ApiModelProperty(value = "")
    @JsonProperty("address")
    public AddressReq getAddress() {
        return address;
    }

    public void setAddress(AddressReq address) {
        this.address = address;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("addressDescription")
    public AddressDescriptionReq getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(AddressDescriptionReq addressDescription) {
        this.addressDescription = addressDescription;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("geoCode")
    public GeoCodeReq getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCodeReq geoCode) {
        this.geoCode = geoCode;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("publicKey")
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
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
        ProductOfferingQualificationRsp productOfferingQualificationReq = (ProductOfferingQualificationRsp) o;
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
