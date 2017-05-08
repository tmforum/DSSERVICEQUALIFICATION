package org.tmf.dsmapi.service.qualification.enity;

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
@Entity(name = "AddressDescriptionReq")
@Table(name = "ADDRESS_DESC_REQ")
public class AddressDescriptionReqEntity implements Serializable {

    protected String streetNr = null;
    protected String streetNrSuffix = null;
    protected String streetNrLast = null;
    protected String streetNrLastSuffix = null;
    protected String streetName = null;
    protected String streetType = null;
    protected String streetSuffix = null;
    protected String postcode = null;
    protected String locality = null;
    protected String city = null;
    protected String stateOrProvince = null;
    protected String country = null;

    protected String id;

    /**
     *
     * @return possible object is {@link Long }
     *
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    /**
     *
     * @param value allowed object is {@link Long }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetNr(String streetNr) {
        this.streetNr = streetNr;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetNr")
    @Basic
    @Column(name = "STREET_NR", length = 512)
    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetNrSuffix(String streetNrSuffix) {
        this.streetNrSuffix = streetNrSuffix;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetNrSuffix")
    @Basic
    @Column(name = "STREET_NR_SUFFIX", length = 512)
    public String getStreetNrSuffix() {
        return streetNrSuffix;
    }

    public void setStreetNrSuffix(String streetNrSuffix) {
        this.streetNrSuffix = streetNrSuffix;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetNrLast(String streetNrLast) {
        this.streetNrLast = streetNrLast;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetNrLast")
    @Basic
    @Column(name = "STREET_NR_LAST", length = 512)
    public String getStreetNrLast() {
        return streetNrLast;
    }

    public void setStreetNrLast(String streetNrLast) {
        this.streetNrLast = streetNrLast;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetNrLastSuffix(String streetNrLastSuffix) {
        this.streetNrLastSuffix = streetNrLastSuffix;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetNrLastSuffix")
    @Basic
    @Column(name = "STREET_NR_LAST_SUFFIX", length = 512)
    public String getStreetNrLastSuffix() {
        return streetNrLastSuffix;
    }

    public void setStreetNrLastSuffix(String streetNrLastSuffix) {
        this.streetNrLastSuffix = streetNrLastSuffix;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetName")
    @Basic
    @Column(name = "STREET_NAME", length = 512)
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetType(String streetType) {
        this.streetType = streetType;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetType")
    @Basic
    @Column(name = "STREET_TYPE", length = 128)
    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity streetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("streetSuffix")
    @Basic
    @Column(name = "STREET_SUFFIX", length = 512)
    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("postcode")
    @Basic
    @Column(name = "POST_CODE", length = 128)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity locality(String locality) {
        this.locality = locality;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("locality")
    @Basic
    @Column(name = "LOCALITY", length = 512)
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity city(String city) {
        this.city = city;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("city")
    @Basic
    @Column(name = "CITY", length = 128)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity stateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("stateOrProvince")
    @Basic
    @Column(name = "STATE_OR_PROVINCE", length = 512)
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    /**
     *
     */
    public AddressDescriptionReqEntity country(String country) {
        this.country = country;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("country")
    @Basic
    @Column(name = "COUNTRY", length = 512)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddressDescriptionReqEntity addressDescriptionReq = (AddressDescriptionReqEntity) o;
        return Objects.equals(streetNr, addressDescriptionReq.streetNr)
                && Objects.equals(streetNrSuffix, addressDescriptionReq.streetNrSuffix)
                && Objects.equals(streetNrLast, addressDescriptionReq.streetNrLast)
                && Objects.equals(streetNrLastSuffix, addressDescriptionReq.streetNrLastSuffix)
                && Objects.equals(streetName, addressDescriptionReq.streetName)
                && Objects.equals(streetType, addressDescriptionReq.streetType)
                && Objects.equals(streetSuffix, addressDescriptionReq.streetSuffix)
                && Objects.equals(postcode, addressDescriptionReq.postcode)
                && Objects.equals(locality, addressDescriptionReq.locality)
                && Objects.equals(city, addressDescriptionReq.city)
                && Objects.equals(stateOrProvince, addressDescriptionReq.stateOrProvince)
                && Objects.equals(country, addressDescriptionReq.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNr, streetNrSuffix, streetNrLast, streetNrLastSuffix, streetName, streetType, streetSuffix, postcode, locality, city, stateOrProvince, country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddressDescriptionReq {\n");

        sb.append("    streetNr: ").append(toIndentedString(streetNr)).append("\n");
        sb.append("    streetNrSuffix: ").append(toIndentedString(streetNrSuffix)).append("\n");
        sb.append("    streetNrLast: ").append(toIndentedString(streetNrLast)).append("\n");
        sb.append("    streetNrLastSuffix: ").append(toIndentedString(streetNrLastSuffix)).append("\n");
        sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
        sb.append("    streetType: ").append(toIndentedString(streetType)).append("\n");
        sb.append("    streetSuffix: ").append(toIndentedString(streetSuffix)).append("\n");
        sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
        sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
