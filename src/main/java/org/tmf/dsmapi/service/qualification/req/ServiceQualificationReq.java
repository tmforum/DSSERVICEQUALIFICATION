package org.tmf.dsmapi.service.qualification.req;

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
import org.tmf.dsmapi.service.qualification.model.QualificationStateEnum;
import org.tmf.dsmapi.service.qualification.rsp.ServiceQualificationRsp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceQualificationReq")
@Table(name = "SERVICE_QUALIFICATION_REQ")
public class ServiceQualificationReq implements Serializable {

    private final static long serialVersionUID = 11L;

    protected String id = null;
    protected String href = null;
    protected Date interactionDate = null;
    protected String provideAlternative = null;
    protected String provideOnlyEligible = null;
    protected String description = null;
    protected Date eligibilityDate = null;
    protected QualificationStateEnum qualificationState = null;
    protected AddressReq address = null;
    protected AddressDescriptionReq addressDescription = null;
    protected GeoCodeReq geoCode = null;
    protected String publicKey = null;
    protected List<ServiceQualificationReqItem> serviceQualificationItem = new ArrayList<ServiceQualificationReqItem>();
    
    
    public ServiceQualificationRsp convert() {
        ServiceQualificationRsp rsp = new ServiceQualificationRsp();
        rsp.setId(id);
        rsp.setHref(href);
        rsp.setInteractionDate(interactionDate);
        rsp.setProvideAlternative(provideAlternative);
        rsp.setProvideOnlyEligible(provideOnlyEligible);
        rsp.setEligibilityDate(eligibilityDate);
        rsp.setQualificationState(qualificationState);
        rsp.setDescription(description);
        
        rsp.setAddress(address);
        rsp.setAddressDescription(addressDescription);
        rsp.setGeoCode(geoCode);
        rsp.setPublicKey(publicKey);
        
        return rsp;
    }


    /**
     *
     */
    public ServiceQualificationReq interactionDate(Date interactionDate) {
        this.interactionDate = interactionDate;
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
    public ServiceQualificationReq href(String href) {
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

    /**
     *
     */
    public ServiceQualificationReq provideAlternative(String provideAlternative) {
        this.provideAlternative = provideAlternative;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("provideAlternative")
    @Basic
    @Column(name = "PROVIDE_ALT", length = 10)
    public String getProvideAlternative() {
        return provideAlternative;
    }

    public void setProvideAlternative(String provideAlternative) {
        this.provideAlternative = provideAlternative;
    }

    /**
     *
     */
    public ServiceQualificationReq provideOnlyEligible(String provideOnlyEligible) {
        this.provideOnlyEligible = provideOnlyEligible;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("provideOnlyEligible")
    @Basic
    @Column(name = "PROVIDE_ONLY_ELIGIBLE", length = 10)
    public String getProvideOnlyEligible() {
        return provideOnlyEligible;
    }

    public void setProvideOnlyEligible(String provideOnlyEligible) {
        this.provideOnlyEligible = provideOnlyEligible;
    }

    /**
     *
     */
    public ServiceQualificationReq description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("description")
    @Basic
    @Column(name = "DESCRIPTION", length = 1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     */
    public ServiceQualificationReq eligibilityDate(Date eligibilityDate) {
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
    public ServiceQualificationReq qualificationState(QualificationStateEnum qualificationState) {
        this.qualificationState = qualificationState;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("qualificationState")
    @Basic
    @Column(name = "QUALIFICATION_STATE", length = 10)
    public QualificationStateEnum getQualificationState() {
        return qualificationState;
    }

    public void setQualificationState(QualificationStateEnum qualificationState) {
        this.qualificationState = qualificationState;
    }

    /**
     *
     */
    public ServiceQualificationReq address(AddressReq address) {
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
    public ServiceQualificationReq addressDescription(AddressDescriptionReq addressDescription) {
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
    public ServiceQualificationReq geoCode(GeoCodeReq geoCode) {
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
    public ServiceQualificationReq publicKey(String publicKey) {
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
    public ServiceQualificationReq serviceQualificationItem(List<ServiceQualificationReqItem> serviceQualificationItem) {
        this.serviceQualificationItem = serviceQualificationItem;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceQualificationItem")
    @OneToMany(targetEntity = ServiceQualificationReqItem.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_QUALIFICATION_REQ_ID")
    public List<ServiceQualificationReqItem> getServiceQualificationItem() {
        return serviceQualificationItem;
    }

    public void setServiceQualificationItem(List<ServiceQualificationReqItem> serviceQualificationItem) {
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
        ServiceQualificationReq serviceQualificationReq = (ServiceQualificationReq) o;
        return Objects.equals(interactionDate, serviceQualificationReq.interactionDate)
                && Objects.equals(provideAlternative, serviceQualificationReq.provideAlternative)
                && Objects.equals(provideOnlyEligible, serviceQualificationReq.provideOnlyEligible)
                && Objects.equals(description, serviceQualificationReq.description)
                && Objects.equals(eligibilityDate, serviceQualificationReq.eligibilityDate)
                && Objects.equals(address, serviceQualificationReq.address)
                && Objects.equals(addressDescription, serviceQualificationReq.addressDescription)
                && Objects.equals(geoCode, serviceQualificationReq.geoCode)
                && Objects.equals(publicKey, serviceQualificationReq.publicKey)
                && Objects.equals(serviceQualificationItem, serviceQualificationReq.serviceQualificationItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interactionDate, provideAlternative, provideOnlyEligible, description, eligibilityDate, address, addressDescription, geoCode, publicKey, serviceQualificationItem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceQualificationReq {\n");

        sb.append("    interactionDate: ").append(toIndentedString(interactionDate)).append("\n");
        sb.append("    provideAlternative: ").append(toIndentedString(provideAlternative)).append("\n");
        sb.append("    provideOnlyEligible: ").append(toIndentedString(provideOnlyEligible)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    eligibilityDate: ").append(toIndentedString(eligibilityDate)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    addressDescription: ").append(toIndentedString(addressDescription)).append("\n");
        sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
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
