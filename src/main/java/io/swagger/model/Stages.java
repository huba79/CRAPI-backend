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
 * Stages belonging to  pond
 */
@Schema(description = "Stages belonging to  pond")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T16:04:50.838Z[GMT]")
@Entity

public class Stages   {
  @JsonProperty("id")
  private @Id @GeneratedValue Long id = null;

  @JsonProperty("stageNr")
  private Integer stageNr = null;

  @JsonProperty("pondId")
  private Long pondId = null;

  @JsonProperty("stageType")
  private Integer stageType = null;

  @JsonProperty("stageSize")
  private Integer stageSize = null;

  public Stages id(Long id) {
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

  public Stages stageNr(Integer stageNr) {
    this.stageNr = stageNr;
    return this;
  }

  /**
   * Get stageNr
   * @return stageNr
   **/
  @Schema(description = "")
  
    public Integer getStageNr() {
    return stageNr;
  }

  public void setStageNr(Integer stageNr) {
    this.stageNr = stageNr;
  }

  public Stages pondId(Long pondId) {
    this.pondId = pondId;
    return this;
  }

  /**
   * Get pondId
   * @return pondId
   **/
  @Schema(description = "")
  
    public Long getPondId() {
    return pondId;
  }

  public void setPondId(Long pondId) {
    this.pondId = pondId;
  }

  public Stages stageType(Integer stageType) {
    this.stageType = stageType;
    return this;
  }

  /**
   * Get stageType
   * @return stageType
   **/
  @Schema(description = "")
  
    public Integer getStageType() {
    return stageType;
  }

  public void setStageType(Integer stageType) {
    this.stageType = stageType;
  }

  public Stages stageSize(Integer stageSize) {
    this.stageSize = stageSize;
    return this;
  }

  /**
   * Get stageSize
   * @return stageSize
   **/
  @Schema(description = "")
  
    public Integer getStageSize() {
    return stageSize;
  }

  public void setStageSize(Integer stageSize) {
    this.stageSize = stageSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stages stages = (Stages) o;
    return Objects.equals(this.id, stages.id) &&
        Objects.equals(this.stageNr, stages.stageNr) &&
        Objects.equals(this.pondId, stages.pondId) &&
        Objects.equals(this.stageType, stages.stageType) &&
        Objects.equals(this.stageSize, stages.stageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, stageNr, pondId, stageType, stageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stages {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    stageNr: ").append(toIndentedString(stageNr)).append("\n");
    sb.append("    pondId: ").append(toIndentedString(pondId)).append("\n");
    sb.append("    stageType: ").append(toIndentedString(stageType)).append("\n");
    sb.append("    stageSize: ").append(toIndentedString(stageSize)).append("\n");
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
