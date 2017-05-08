package org.tmf.dsmapi.service.qualification.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceQualificationRela")
@Table(name = "SERVICE_QUALIFICATION_RELA")
public class ServiceQualificationRelationEntity implements Serializable {

    private final static long serialVersionUID = 11L;

    protected String id = null;
    protected String href = null;
    protected AddressEntity address = null;
    protected AddressDescriptionEntity addressDescription = null;
    protected GeoCodeEntity geoCode = null;
    protected String publicKey = null;
    protected String qualificationState = null;
    protected List<AccessTypeRefEntity> physicalTerminationPoint = new ArrayList<AccessTypeRefEntity>();
    protected List<ServiceSpecificationEntity> serviceSpecification = new ArrayList<ServiceSpecificationEntity>();

    /**
     * 
     * @return 
     */
    public ServiceQualificationEntity convert() {
        ServiceQualificationEntity serviceQualification = new ServiceQualificationEntity();
        serviceQualification.setId(id);
        serviceQualification.setHref(href);
        serviceQualification.setPublicKey(publicKey);
        serviceQualification.setQualificationState(qualificationState);
        serviceQualification.setPhysicalTerminationPoint(physicalTerminationPoint);
        serviceQualification.setServiceSpecification(serviceSpecification);
        return serviceQualification;
    }

    /**
     *
     */
    public ServiceQualificationRelationEntity id(String id) {
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
    public ServiceQualificationRelationEntity href(String href) {
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
    public ServiceQualificationRelationEntity address(AddressEntity address) {
        this.address = address;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("address")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_ID")
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    /**
     *
     */
    public ServiceQualificationRelationEntity addressDescription(AddressDescriptionEntity addressDescription) {
        this.addressDescription = addressDescription;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("addressDescription")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ADDRESS_DESC_ID")
    public AddressDescriptionEntity getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(AddressDescriptionEntity addressDescription) {
        this.addressDescription = addressDescription;
    }

    /**
     *
     */
    public ServiceQualificationRelationEntity geoCode(GeoCodeEntity geoCode) {
        this.geoCode = geoCode;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("geoCode")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "GEO_CODE_ID")
    public GeoCodeEntity getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCodeEntity geoCode) {
        this.geoCode = geoCode;
    }

    /**
     *
     */
    public ServiceQualificationRelationEntity publicKey(String publicKey) {
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
    public ServiceQualificationRelationEntity physicalTerminationPoint(List<AccessTypeRefEntity> physicalTerminationPoint) {
        this.physicalTerminationPoint = physicalTerminationPoint;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("physicalTerminationPoint")
    @OneToMany(targetEntity = AccessTypeRefEntity.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SERVICE_QUALIFICATION_RELA_ID")
    public List<AccessTypeRefEntity> getPhysicalTerminationPoint() {
        return physicalTerminationPoint;
    }

    public void setPhysicalTerminationPoint(List<AccessTypeRefEntity> physicalTerminationPoint) {
        this.physicalTerminationPoint = physicalTerminationPoint;
    }

    /**
     *
     */
    public ServiceQualificationRelationEntity serviceSpecification(List<ServiceSpecificationEntity> serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("serviceSpecification")
    @OneToMany(targetEntity = ServiceSpecificationEntity.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "SERVICE_QUALIFICATION_RELA_ID")
//  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//  @JoinColumn(name="SERV_SPEC_ID")
    public List<ServiceSpecificationEntity> getServiceSpecification() {
        return serviceSpecification;
    }

    public void setServiceSpecification(List<ServiceSpecificationEntity> serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("qualificationState")
    @Basic
    @Column(name = "SERVICE_STATE", length = 24)
    public String getQualificationState() {
        return this.qualificationState;
    }

    public void setQualificationState(String qualificationState) {
        this.qualificationState = qualificationState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceQualificationRelationEntity serviceQualification = (ServiceQualificationRelationEntity) o;
        return Objects.equals(id, serviceQualification.id)
                && Objects.equals(href, serviceQualification.href)
                && Objects.equals(address, serviceQualification.address)
                && Objects.equals(addressDescription, serviceQualification.addressDescription)
                && Objects.equals(geoCode, serviceQualification.geoCode)
                && Objects.equals(publicKey, serviceQualification.publicKey)
                && Objects.equals(physicalTerminationPoint, serviceQualification.physicalTerminationPoint)
                && Objects.equals(serviceSpecification, serviceQualification.serviceSpecification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, address, addressDescription, geoCode, publicKey, physicalTerminationPoint, serviceSpecification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceQualification {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    addressDescription: ").append(toIndentedString(addressDescription)).append("\n");
        sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    physicalTerminationPoint: ").append(toIndentedString(physicalTerminationPoint)).append("\n");
        sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
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
