package org.tmf.dsmapi.service.qualification.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
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




@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "ServiceQualification")
@Table(name = "SERVICE_QUALIFICATION")
public class ServiceQualification implements Serializable  {
  
  private final static long serialVersionUID = 11L;
    
  protected String id = null;
  protected String href = null;
  protected String addressId = null;
  protected String addressDescId = null;
  protected String geoCodeId = null;
  protected String publicKey = null;
  protected String qualificationState = null;
  protected List<AccessTypeRef> physicalTerminationPoint = null;
  protected List<ServiceSpecification> serviceSpecification = null;

  
  
  /**
   **/
  public ServiceQualification id(String id) {
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
  @JsonProperty("addressId")
  @Basic
  @Column(name = "ADDRESS_ID", length = 30)
  public String getAddressId() {
    return addressId;
  }
  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("addressDescriptionId")
  @Basic
  @Column(name="ADDRESS_DESC_ID", length = 30)
  public String getAddressDescId() {
    return addressDescId;
  }
  public void setAddressDescId(String addressDescId) {
    this.addressDescId = addressDescId;
  }


  
  @ApiModelProperty(value = "")
  @JsonProperty("geoCodeId")
  @Basic
  @Column(name="GEO_CODE_ID")
  public String getGeoCodeId() {
    return geoCodeId;
  }
  public void setGeoCodeId(String geoCodeId) {
    this.geoCodeId = geoCodeId;
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

  
  @ApiModelProperty(value = "")
  @JsonProperty("physicalTerminationPoint")
  @OneToMany(targetEntity = AccessTypeRef.class, cascade = {
        CascadeType.ALL
    })
  @JoinColumn(name = "SERVICE_QUALIFICATION_RELA_ID")
  public List<AccessTypeRef> getPhysicalTerminationPoint() {
    return physicalTerminationPoint;
  }
  public void setPhysicalTerminationPoint(List<AccessTypeRef> physicalTerminationPoint) {
    this.physicalTerminationPoint = physicalTerminationPoint;
  }

  /**
   **/
  public ServiceQualification serviceSpecification(List<ServiceSpecification> serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("serviceSpecification")
  @OneToMany(targetEntity = ServiceSpecification.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
  @JoinColumn(name = "SERVICE_QUALIFICATION_ID")
//  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//  @JoinColumn(name="SERV_SPEC_ID")
  public List<ServiceSpecification> getServiceSpecification() {
    return serviceSpecification;
  }
  public void setServiceSpecification(List<ServiceSpecification> serviceSpecification) {
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
    ServiceQualificationRelation serviceQualification = (ServiceQualificationRelation) o;
    return Objects.equals(id, serviceQualification.id) &&
        Objects.equals(href, serviceQualification.href) &&
        Objects.equals(addressId, serviceQualification.address) &&
        Objects.equals(addressDescId, serviceQualification.addressDescription) &&
        Objects.equals(geoCodeId, serviceQualification.geoCode) &&
        Objects.equals(publicKey, serviceQualification.publicKey) &&
        Objects.equals(physicalTerminationPoint, serviceQualification.physicalTerminationPoint) &&
        Objects.equals(serviceSpecification, serviceQualification.serviceSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, addressId, addressDescId, geoCodeId, publicKey, physicalTerminationPoint, serviceSpecification);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceQualification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    address: ").append(toIndentedString(addressId)).append("\n");
    sb.append("    addressDescription: ").append(toIndentedString(addressDescId)).append("\n");
    sb.append("    geoCode: ").append(toIndentedString(geoCodeId)).append("\n");
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


