package org.tmf.dsmapi.service.qualification.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "GeoCode")
@Table(name = "GEO_CODE")
public class GeoCode implements Serializable   {
  
  private final static long serialVersionUID = 11L;
    
  protected String latitude = null;
  protected String longitude = null;
  protected String geographicDatum = null;
  
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
   * 
   * @param latitude
   * @return 
   */
  public GeoCode latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("latitude")
  @Basic
  @Column(name = "LATITUDE", length = 255)
  public String getLatitude() {
    return latitude;
  }
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * 
   * @param longitude
   * @return 
   */
  public GeoCode longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("longitude")
  @Basic
  @Column(name = "LONGITUDE", length = 255)
  public String getLongitude() {
    return longitude;
  }
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   * 
   * @param geographicDatum
   * @return 
   */
  public GeoCode geographicDatum(String geographicDatum) {
    this.geographicDatum = geographicDatum;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("geographicDatum")
  @Basic
  @Column(name = "GEOGRAPHIC_DATUM", length = 255)
  public String getGeographicDatum() {
    return geographicDatum;
  }
  public void setGeographicDatum(String geographicDatum) {
    this.geographicDatum = geographicDatum;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoCode geoCode = (GeoCode) o;
    return Objects.equals(latitude, geoCode.latitude) &&
        Objects.equals(longitude, geoCode.longitude) &&
        Objects.equals(geographicDatum, geoCode.geographicDatum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude, geographicDatum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoCode {\n");
    
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    geographicDatum: ").append(toIndentedString(geographicDatum)).append("\n");
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

