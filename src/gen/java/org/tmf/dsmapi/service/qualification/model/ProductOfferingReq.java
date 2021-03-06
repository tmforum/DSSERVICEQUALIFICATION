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
import org.tmf.dsmapi.service.qualification.model.ProductReq;
import org.tmf.dsmapi.service.qualification.model.ProductOfferingCategoryReq;
import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

/**
 * ProductOfferingReq
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.TMFJaxRSServerCodegen", date = "2017-04-28T19:12:29.034+05:30")
public class ProductOfferingReq   {
  
    
    
  
  
  private String id = null;

  
    
    
  
  
  private String href = null;

  
    
    
  
  
  private ProductOfferingCategoryReq productOfferingCategory = null;

  
    
    
  
  
  private ProductReq product = null;

  
  
  
  public ProductOfferingReq id(String id) {
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
  

  
  
  public ProductOfferingReq href(String href) {
    this.href = href;
    return this;
  }
  
  

  
   /**
  
  
   * Get href
  
  
  
   * @return href
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("href")
   public String getHref() {
    return href;
  }
  

  public void setHref(String href) {
    this.href = href;
  }
  

  
  
  public ProductOfferingReq productOfferingCategory(ProductOfferingCategoryReq productOfferingCategory) {
    this.productOfferingCategory = productOfferingCategory;
    return this;
  }
  
  

  
   /**
  
  
   * Get productOfferingCategory
  
  
  
   * @return productOfferingCategory
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("productOfferingCategory")
   public ProductOfferingCategoryReq getProductOfferingCategory() {
    return productOfferingCategory;
  }
  

  public void setProductOfferingCategory(ProductOfferingCategoryReq productOfferingCategory) {
    this.productOfferingCategory = productOfferingCategory;
  }
  

  
  
  public ProductOfferingReq product(ProductReq product) {
    this.product = product;
    return this;
  }
  
  

  
   /**
  
  
   * Get product
  
  
  
   * @return product
  **/
 
  @ApiModelProperty(value = "")
  @JsonProperty("product")
   public ProductReq getProduct() {
    return product;
  }
  

  public void setProduct(ProductReq product) {
    this.product = product;
  }
  

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOfferingReq productOfferingReq = (ProductOfferingReq) o;
    return Objects.equals(this.id, productOfferingReq.id) &&
        Objects.equals(this.href, productOfferingReq.href) &&
        Objects.equals(this.productOfferingCategory, productOfferingReq.productOfferingCategory) &&
        Objects.equals(this.product, productOfferingReq.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, productOfferingCategory, product);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingReq {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    productOfferingCategory: ").append(toIndentedString(productOfferingCategory)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

