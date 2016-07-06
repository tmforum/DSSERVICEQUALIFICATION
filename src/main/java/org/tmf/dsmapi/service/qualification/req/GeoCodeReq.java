package org.tmf.dsmapi.service.qualification.req;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
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
@Entity(name = "GeoCodeReq")
@Table(name = "GEO_CODE_REQ")
public class GeoCodeReq implements Serializable {

    private final static long serialVersionUID = 11L;

    private String latitude = null;
    private String longitude = null;
    private String geographicDatum = null;

    protected Long hjid;

    /**
     *
     * @return possible object is {@link Long }
     *
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Long getHjid() {
        return hjid;
    }

    /**
     *
     * @param value allowed object is {@link Long }
     *
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    /**
     *
     */
    public GeoCodeReq latitude(String latitude) {
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
     */
    public GeoCodeReq longitude(String longitude) {
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
     */
    public GeoCodeReq geographicDatum(String geographicDatum) {
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
        GeoCodeReq geoCodeReq = (GeoCodeReq) o;
        return Objects.equals(latitude, geoCodeReq.latitude)
                && Objects.equals(longitude, geoCodeReq.longitude)
                && Objects.equals(geographicDatum, geoCodeReq.geographicDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, geographicDatum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GeoCodeReq {\n");

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
