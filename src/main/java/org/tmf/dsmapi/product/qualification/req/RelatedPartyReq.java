package org.tmf.dsmapi.product.qualification.req;

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
import org.tmf.dsmapi.product.qualification.model.RelatedParty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "RelatedPartyReq")
@Table(name = "RELATED_PARTY_REQ")
public class RelatedPartyReq implements Serializable {

    private final static long serialVersionUID = 1L;

    private String id = null;
    private String role = null;
    private String href = null;
    private String name = null;
    
    
    public RelatedParty convert() {
        RelatedParty party = new RelatedParty();
        party.setRole(role);
        party.setName(name);
        party.setHref(href);
        
        return party;
    }

    /**
     *
     */
    public RelatedPartyReq id(String id) {
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
    public RelatedPartyReq role(String role) {
        this.role = role;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("role")
    @Basic
    @Column(name = "ROLE", length = 48)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     */
    public RelatedPartyReq href(String href) {
        this.href = href;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("href")
    @Basic
    @Column(name = "HREF", length = 128)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     */
    public RelatedPartyReq name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("name")
    @Basic
    @Column(name = "NAME", length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RelatedPartyReq relatedPartyReq = (RelatedPartyReq) o;
        return Objects.equals(id, relatedPartyReq.id)
                && Objects.equals(role, relatedPartyReq.role)
                && Objects.equals(href, relatedPartyReq.href)
                && Objects.equals(name, relatedPartyReq.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, href, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RelatedPartyReq {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
