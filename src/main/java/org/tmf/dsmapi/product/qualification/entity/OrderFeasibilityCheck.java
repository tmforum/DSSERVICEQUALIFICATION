package org.tmf.dsmapi.product.qualification.entity;

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
@Entity(name = "OrderFeasibilityCheck")
@Table(name = "ORDER_FEASIBILITY_CHECK")
public class OrderFeasibilityCheck implements Serializable {
    
    private final static long serialVersionUID = 1L;
    
    protected String eligibilityResult = "available";
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    protected Long hjid;

    /**
     *
     * @return possible object is {@link Long }
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
     * @param value allowed object is {@link Long }
     *
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    /**
     *
     */
    public OrderFeasibilityCheck eligibilityResult(String eligibilityResult) {
        this.eligibilityResult = eligibilityResult;
        return this;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("eligibilityResult")
    @Basic
    @Column(name = "ELIGIBILITY_RESULT", length = 20)
    public String getEligibilityResult() {
        return eligibilityResult;
    }

    public void setEligibilityResult(String eligibilityResult) {
        this.eligibilityResult = eligibilityResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderFeasibilityCheck orderFeasibilityCheck = (OrderFeasibilityCheck) o;
        return Objects.equals(eligibilityResult, orderFeasibilityCheck.eligibilityResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligibilityResult);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderFeasibilityCheck {\n");

        sb.append("    eligibilityResult: ").append(toIndentedString(eligibilityResult)).append("\n");
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
