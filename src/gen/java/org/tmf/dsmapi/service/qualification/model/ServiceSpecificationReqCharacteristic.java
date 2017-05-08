/*
 * API ProductOrdering
 * 
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.tmf.dsmapi.service.qualification.model;

import java.util.Objects;
import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

/**
 * ServiceSpecificationReqCharacteristic
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:45.112+05:30")
public class ServiceSpecificationReqCharacteristic   {
  
    
    
  
  
  private String id = null;

  
    
    
  
  
  private String name = null;

  
    
    
  
  
  private String valuefrom = null;

  
    
    
  
  
  private String valueto = null;

  
  
  
  public ServiceSpecificationReqCharacteristic id(String id) {
    this.id = id;
    return this;
  }
  
  

  
   /**
  
  
   * Get id
  
  
  
   * @return id
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("id")
   public String getId() {
    return id;
  }
  

  public void setId(String id) {
    this.id = id;
  }
  

  
  
  public ServiceSpecificationReqCharacteristic name(String name) {
    this.name = name;
    return this;
  }
  
  

  
   /**
  
  
   * Get name
  
  
  
   * @return name
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("name")
   public String getName() {
    return name;
  }
  

  public void setName(String name) {
    this.name = name;
  }
  

  
  
  public ServiceSpecificationReqCharacteristic valuefrom(String valuefrom) {
    this.valuefrom = valuefrom;
    return this;
  }
  
  

  
   /**
  
  
   * Get valuefrom
  
  
  
   * @return valuefrom
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("valuefrom")
   public String getValuefrom() {
    return valuefrom;
  }
  

  public void setValuefrom(String valuefrom) {
    this.valuefrom = valuefrom;
  }
  

  
  
  public ServiceSpecificationReqCharacteristic valueto(String valueto) {
    this.valueto = valueto;
    return this;
  }
  
  

  
   /**
  
  
   * Get valueto
  
  
  
   * @return valueto
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("valueto")
   public String getValueto() {
    return valueto;
  }
  

  public void setValueto(String valueto) {
    this.valueto = valueto;
  }
  

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpecificationReqCharacteristic serviceSpecificationReqCharacteristic = (ServiceSpecificationReqCharacteristic) o;
    return Objects.equals(this.id, serviceSpecificationReqCharacteristic.id) &&
        Objects.equals(this.name, serviceSpecificationReqCharacteristic.name) &&
        Objects.equals(this.valuefrom, serviceSpecificationReqCharacteristic.valuefrom) &&
        Objects.equals(this.valueto, serviceSpecificationReqCharacteristic.valueto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, valuefrom, valueto);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpecificationReqCharacteristic {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    valuefrom: ").append(toIndentedString(valuefrom)).append("\n");
    sb.append("    valueto: ").append(toIndentedString(valueto)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

