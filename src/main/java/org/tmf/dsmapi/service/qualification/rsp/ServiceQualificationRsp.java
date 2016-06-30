package org.tmf.dsmapi.service.qualification.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.tmf.dsmapi.service.qualification.req.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.tmf.dsmapi.service.qualification.model.QualificationStateEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value={"id","href","interactionDate",
    "provideAlternative","provideOnlyEligible","description",
    "eligibilityDate","qualificationState","address",
    "physicalTerminationPoint","serviceQualificationItem"})
public class ServiceQualificationRsp implements Serializable {

    private final static long serialVersionUID = 11L;

    private String id = null;
    private String href = null;
    private Date interactionDate = null;
    private String provideAlternative = null;
    private String provideOnlyEligible = null;
    private String description = null;
    private Date eligibilityDate = null;

    private QualificationStateEnum qualificationState = null;
    private AddressReq address = null;
    private AddressDescriptionReq addressDescription = null;
    private GeoCodeReq geoCode = null;
    private String publicKey = null;
    private List<AccessTypeRsp> physicalTerminationPoint = null;
    private List<ServiceQualificationItemRsp> serviceQualificationItem = null;

    
    
    /**
     * 
     * @param item 
     */
    public void addItem(ServiceQualificationItemRsp item) {
        this.serviceQualificationItem.add(item);
    }
    
    
    /**
     *
     */
    public ServiceQualificationRsp id(String id) {
        this.id = id;
        return this;
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
    public ServiceQualificationRsp href(String href) {
        this.href = href;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     */
    public ServiceQualificationRsp interactionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("interactionDate")
    public Date getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
    }

    /**
     *
     */
    public ServiceQualificationRsp provideAlternative(String provideAlternative) {
        this.provideAlternative = provideAlternative;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("provideAlternative")
    public String getProvideAlternative() {
        return provideAlternative;
    }

    public void setProvideAlternative(String provideAlternative) {
        this.provideAlternative = provideAlternative;
    }

    /**
     *
     */
    public ServiceQualificationRsp provideOnlyEligible(String provideOnlyEligible) {
        this.provideOnlyEligible = provideOnlyEligible;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("provideOnlyEligible")
    public String getProvideOnlyEligible() {
        return provideOnlyEligible;
    }

    public void setProvideOnlyEligible(String provideOnlyEligible) {
        this.provideOnlyEligible = provideOnlyEligible;
    }

    /**
     *
     */
    public ServiceQualificationRsp description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     */
    public ServiceQualificationRsp eligibilityDate(Date eligibilityDate) {
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
    public ServiceQualificationRsp qualificationState(QualificationStateEnum qualificationState) {
        this.qualificationState = qualificationState;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("qualificationState")
    public QualificationStateEnum getQualificationState() {
        return qualificationState;
    }

    public void setQualificationState(QualificationStateEnum qualificationState) {
        this.qualificationState = qualificationState;
    }

    /**
     *
     */
    public ServiceQualificationRsp address(AddressReq address) {
        this.address = address;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("address")
    public AddressReq getAddress() {
        return address;
    }

    public void setAddress(AddressReq address) {
        this.address = address;
    }

    /**
     *
     */
    public ServiceQualificationRsp addressDescription(AddressDescriptionReq addressDescription) {
        this.addressDescription = addressDescription;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("addressDescription")
    public AddressDescriptionReq getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(AddressDescriptionReq addressDescription) {
        this.addressDescription = addressDescription;
    }

    /**
     *
     */
    public ServiceQualificationRsp geoCode(GeoCodeReq geoCode) {
        this.geoCode = geoCode;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("geoCode")
    public GeoCodeReq getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCodeReq geoCode) {
        this.geoCode = geoCode;
    }

    /**
     *
     */
    public ServiceQualificationRsp publicKey(String publicKey) {
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
    public ServiceQualificationRsp physicalTerminationPoint(List<AccessTypeRsp> physicalTerminationPoint) {
        this.physicalTerminationPoint = physicalTerminationPoint;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("physicalTerminationPoint")
    public List<AccessTypeRsp> getPhysicalTerminationPoint() {
        return physicalTerminationPoint;
    }

    public void setPhysicalTerminationPoint(List<AccessTypeRsp> physicalTerminationPoint) {
        this.physicalTerminationPoint = physicalTerminationPoint;
    }

    /**
     *
     */
    public ServiceQualificationRsp serviceQualificationItem(List<ServiceQualificationItemRsp> serviceQualificationItem) {
        this.serviceQualificationItem = serviceQualificationItem;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceQualificationItem")
    public List<ServiceQualificationItemRsp> getServiceQualificationItem() {
        return serviceQualificationItem;
    }

    public void setServiceQualificationItem(List<ServiceQualificationItemRsp> serviceQualificationItem) {
        this.serviceQualificationItem = serviceQualificationItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceQualificationRsp serviceQualificationRsp = (ServiceQualificationRsp) o;
        return Objects.equals(id, serviceQualificationRsp.id)
                && Objects.equals(href, serviceQualificationRsp.href)
                && Objects.equals(interactionDate, serviceQualificationRsp.interactionDate)
                && Objects.equals(provideAlternative, serviceQualificationRsp.provideAlternative)
                && Objects.equals(provideOnlyEligible, serviceQualificationRsp.provideOnlyEligible)
                && Objects.equals(description, serviceQualificationRsp.description)
                && Objects.equals(eligibilityDate, serviceQualificationRsp.eligibilityDate)
                && Objects.equals(qualificationState, serviceQualificationRsp.qualificationState)
                && Objects.equals(address, serviceQualificationRsp.address)
                && Objects.equals(addressDescription, serviceQualificationRsp.addressDescription)
                && Objects.equals(geoCode, serviceQualificationRsp.geoCode)
                && Objects.equals(publicKey, serviceQualificationRsp.publicKey)
                && Objects.equals(physicalTerminationPoint, serviceQualificationRsp.physicalTerminationPoint)
                && Objects.equals(serviceQualificationItem, serviceQualificationRsp.serviceQualificationItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, interactionDate, provideAlternative, provideOnlyEligible, description, eligibilityDate, qualificationState, address, addressDescription, geoCode, publicKey, physicalTerminationPoint, serviceQualificationItem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceQualificationRsp {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    interactionDate: ").append(toIndentedString(interactionDate)).append("\n");
        sb.append("    provideAlternative: ").append(toIndentedString(provideAlternative)).append("\n");
        sb.append("    provideOnlyEligible: ").append(toIndentedString(provideOnlyEligible)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    eligibilityDate: ").append(toIndentedString(eligibilityDate)).append("\n");
        sb.append("    qualificationState: ").append(toIndentedString(qualificationState)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    addressDescription: ").append(toIndentedString(addressDescription)).append("\n");
        sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    physicalTerminationPoint: ").append(toIndentedString(physicalTerminationPoint)).append("\n");
        sb.append("    serviceQualificationItem: ").append(toIndentedString(serviceQualificationItem)).append("\n");
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
