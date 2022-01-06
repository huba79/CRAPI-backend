package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Ponds of an owner company
 */
@Schema(description = "Ponds of an owner company")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T16:04:50.838Z[GMT]")
@Entity

public class Ponds   {
  @JsonProperty("id")
  private @Id @GeneratedValue Long id = null;

  @JsonProperty("pondName")
  private String pondName = null;

  @JsonProperty("pondAddress")
  private String pondAddress = null;

  @JsonProperty("pondNr")
  private Integer pondNr = null;

  public Ponds id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Ponds pondName(String pondName) {
    this.pondName = pondName;
    return this;
  }

  /**
   * Get pondName
   * @return pondName
   **/
  @Schema(description = "")
  
    public String getPondName() {
    return pondName;
  }

  public void setPondName(String pondName) {
    this.pondName = pondName;
  }

  public Ponds pondAddress(String pondAddress) {
    this.pondAddress = pondAddress;
    return this;
  }

  /**
   * Get pondAddress
   * @return pondAddress
   **/
  @Schema(description = "")
  
    public String getPondAddress() {
    return pondAddress;
  }

  public void setPondAddress(String pondAddress) {
    this.pondAddress = pondAddress;
  }

  public Ponds pondNr(Integer pondNr) {
    this.pondNr = pondNr;
    return this;
  }

  /**
   * Get pondNr
   * @return pondNr
   **/
  @Schema(description = "")
  
    public Integer getPondNr() {
    return pondNr;
  }

  public void setPondNr(Integer pondNr) {
    this.pondNr = pondNr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ponds ponds = (Ponds) o;
    return Objects.equals(this.id, ponds.id) &&
        Objects.equals(this.pondName, ponds.pondName) &&
        Objects.equals(this.pondAddress, ponds.pondAddress) &&
        Objects.equals(this.pondNr, ponds.pondNr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pondName, pondAddress, pondNr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ponds {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pondName: ").append(toIndentedString(pondName)).append("\n");
    sb.append("    pondAddress: ").append(toIndentedString(pondAddress)).append("\n");
    sb.append("    pondNr: ").append(toIndentedString(pondNr)).append("\n");
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
