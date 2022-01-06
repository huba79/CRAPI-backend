package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Reservations for a selected stage on a certain interval
 */
@Schema(description = "Reservations for a selected stage on a certain interval")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T16:04:50.838Z[GMT]")
@Entity

public class Reservations   {
  @JsonProperty("id")
  private @Id @GeneratedValue Long id = null;

  @JsonProperty("pondId")
  private Long pondId = null;

  @JsonProperty("stageId")
  private Long stageId = null;

  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("dateFrom")
  private OffsetDateTime dateFrom = null;

  @JsonProperty("dateTo")
  private OffsetDateTime dateTo = null;

  public Reservations id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "123456", description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Reservations pondId(Long pondId) {
    this.pondId = pondId;
    return this;
  }

  /**
   * Get pondId
   * @return pondId
   **/
  @Schema(example = "123457", required = true, description = "")
      @NotNull

    public Long getPondId() {
    return pondId;
  }

  public void setPondId(Long pondId) {
    this.pondId = pondId;
  }

  public Reservations stageId(Long stageId) {
    this.stageId = stageId;
    return this;
  }

  /**
   * Get stageId
   * @return stageId
   **/
  @Schema(example = "123458", required = true, description = "")
      @NotNull

    public Long getStageId() {
    return stageId;
  }

  public void setStageId(Long stageId) {
    this.stageId = stageId;
  }

  public Reservations userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @Schema(example = "123459", required = true, description = "")
      @NotNull

    public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Reservations status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(example = "1", description = "")
  
    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Reservations dateFrom(OffsetDateTime dateFrom) {
    this.dateFrom = dateFrom;
    return this;
  }

  /**
   * Get dateFrom
   * @return dateFrom
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(OffsetDateTime dateFrom) {
    this.dateFrom = dateFrom;
  }

  public Reservations dateTo(OffsetDateTime dateTo) {
    this.dateTo = dateTo;
    return this;
  }

  /**
   * Get dateTo
   * @return dateTo
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getDateTo() {
    return dateTo;
  }

  public void setDateTo(OffsetDateTime dateTo) {
    this.dateTo = dateTo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservations reservations = (Reservations) o;
    return Objects.equals(this.id, reservations.id) &&
        Objects.equals(this.pondId, reservations.pondId) &&
        Objects.equals(this.stageId, reservations.stageId) &&
        Objects.equals(this.userId, reservations.userId) &&
        Objects.equals(this.status, reservations.status) &&
        Objects.equals(this.dateFrom, reservations.dateFrom) &&
        Objects.equals(this.dateTo, reservations.dateTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pondId, stageId, userId, status, dateFrom, dateTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservations {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pondId: ").append(toIndentedString(pondId)).append("\n");
    sb.append("    stageId: ").append(toIndentedString(stageId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dateFrom: ").append(toIndentedString(dateFrom)).append("\n");
    sb.append("    dateTo: ").append(toIndentedString(dateTo)).append("\n");
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
