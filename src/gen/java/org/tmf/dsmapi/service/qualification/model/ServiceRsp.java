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
import org.tmf.dsmapi.service.qualification.model.ServiceSpecification;
import java.util.*;
import org.tmf.dsmapi.service.qualification.model.ServiceRspCharacteristic;
import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

/**
 * ServiceRsp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:45.112+05:30")
public class ServiceRsp   {
  
    
    
  
  
  private List<ServiceRspCharacteristic> serviceCharacteristic = new ArrayList<ServiceRspCharacteristic>();

  
    
    
  
  
  private ServiceSpecification serviceSpecification = null;

  
  
  
  public ServiceRsp serviceCharacteristic(List<ServiceRspCharacteristic> serviceCharacteristic) {
    this.serviceCharacteristic = serviceCharacteristic;
    return this;
  }
  
  

  
   /**
  
  
   * Get serviceCharacteristic
  
  
  
   * @return serviceCharacteristic
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("serviceCharacteristic")
   public List<ServiceRspCharacteristic> getServiceCharacteristic() {
    return serviceCharacteristic;
  }
  

  public void setServiceCharacteristic(List<ServiceRspCharacteristic> serviceCharacteristic) {
    this.serviceCharacteristic = serviceCharacteristic;
  }
  

  
  
  public ServiceRsp serviceSpecification(ServiceSpecification serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
    return this;
  }
  
  

  
   /**
  
  
   * Get serviceSpecification
  
  
  
   * @return serviceSpecification
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("serviceSpecification")
   public ServiceSpecification getServiceSpecification() {
    return serviceSpecification;
  }
  

  public void setServiceSpecification(ServiceSpecification serviceSpecification) {
    this.serviceSpecification = serviceSpecification;
  }
  

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceRsp serviceRsp = (ServiceRsp) o;
    return Objects.equals(this.serviceCharacteristic, serviceRsp.serviceCharacteristic) &&
        Objects.equals(this.serviceSpecification, serviceRsp.serviceSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceCharacteristic, serviceSpecification);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceRsp {\n");
    
    sb.append("    serviceCharacteristic: ").append(toIndentedString(serviceCharacteristic)).append("\n");
    sb.append("    serviceSpecification: ").append(toIndentedString(serviceSpecification)).append("\n");
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

