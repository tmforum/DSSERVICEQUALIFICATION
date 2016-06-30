package org.tmf.dsmapi.service.qualification.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "AccessType")
@Table(name = "ACCESS_TYPE")
public class AccessTypeRef  implements Serializable {
    
  
  private final static long serialVersionUID = 11L;  
  
  protected String accessType = null;
  
  protected String id;
  
   /**
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @com.fasterxml.jackson.annotation.JsonIgnore
    public String getId() {
        return id;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

  /**
   **/
  public AccessTypeRef accessType(String accessType) {
    this.accessType = accessType;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("accessType")
  public String getAccessType() {
    return accessType;
  }
  public void setAccessType(String accessType) {
    this.accessType = accessType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessTypeRef accessTypeRef = (AccessTypeRef) o;
    return Objects.equals(accessType, accessTypeRef.accessType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessTypeRef {\n");
    
    sb.append("    accessType: ").append(toIndentedString(accessType)).append("\n");
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

