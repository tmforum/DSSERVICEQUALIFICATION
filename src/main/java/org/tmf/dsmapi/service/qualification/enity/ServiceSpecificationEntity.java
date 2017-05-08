package org.tmf.dsmapi.service.qualification.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hjid"}) 
@Entity(name = "ServiceSpec")
@Table(name = "SERVICE_SPEC")
public class ServiceSpecificationEntity implements Serializable   {
   
  private final static long serialVersionUID = 11L;
  
  protected String id = null;
  protected String href = null;
  protected String serviceCategoryId = null;
  protected List<ServiceSpecificationCharacteristicEntity> serviceSpecificationCharacteristic = null;
  
  @com.fasterxml.jackson.annotation.JsonIgnore
  protected Long hjid;
   
   /**
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getHjid() {
        return hjid;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }
  
    
  /**
   * 
   * @param id
   * @return 
   */
  public ServiceSpecificationEntity id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  @Basic
  @Column(name = "ID", length = 255)
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   **/
  public ServiceSpecificationEntity href(String href) {
    this.href = href;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("href")
  @Basic
  @Column(name = "HREF", length = 255)
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  /**
   **/
  public ServiceSpecificationEntity serviceCategoryId(String serviceCategoryId) {
    this.serviceCategoryId = serviceCategoryId;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("serviceCategoryId")
  @Basic
  @Column(name = "SERVICE_CATG_ID", length = 255)
  public String getServiceCategoryId() {
    return serviceCategoryId;
  }
  public void setServiceCategoryId(String serviceCategoryId) {
    this.serviceCategoryId = serviceCategoryId;
  }

  /**
   **/
  public ServiceSpecificationEntity serviceSpecificationCharacteristic(List<ServiceSpecificationCharacteristicEntity> serviceSpecificationCharacteristic) {
    this.serviceSpecificationCharacteristic = serviceSpecificationCharacteristic;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("serviceSpecificationCharacteristic")
  @OneToMany(targetEntity = ServiceSpecificationCharacteristicEntity.class, cascade = {
        CascadeType.ALL
    }, fetch = FetchType.EAGER)
  @JoinColumn(name = "SERVICE_SPEC_ID")
  public List<ServiceSpecificationCharacteristicEntity> getServiceSpecificationCharacteristic() {
    return serviceSpecificationCharacteristic;
  }
  public void setServiceSpecificationCharacteristic(List<ServiceSpecificationCharacteristicEntity> serviceSpecificationCharacteristic) {
    this.serviceSpecificationCharacteristic = serviceSpecificationCharacteristic;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecificationEntity serviceSpecification = (ServiceSpecificationEntity) o;
    return Objects.equals(id, serviceSpecification.id) &&
        Objects.equals(href, serviceSpecification.href) &&
        Objects.equals(serviceCategoryId, serviceSpecification.serviceCategoryId) &&
        Objects.equals(serviceSpecificationCharacteristic, serviceSpecification.serviceSpecificationCharacteristic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, serviceCategoryId, serviceSpecificationCharacteristic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    serviceCategoryId: ").append(toIndentedString(serviceCategoryId)).append("\n");
    sb.append("    serviceSpecificationCharacteristic: ").append(toIndentedString(serviceSpecificationCharacteristic)).append("\n");
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

