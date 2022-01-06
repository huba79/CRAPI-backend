package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Payments for the reservations
 */
@Schema(description = "Payments for the reservations")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T16:04:50.838Z[GMT]")
@Entity

public class Payments   {
  @JsonProperty("id")
  private @Id @GeneratedValue Long id = null;

  @JsonProperty("reservationId")
  private Long reservationId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("paidOn")
  private OffsetDateTime paidOn = null;

  public Payments id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(example = "12345670", description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Payments reservationId(Long reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * Get reservationId
   * @return reservationId
   **/
  @Schema(example = "12345671", description = "")
  
    public Long getReservationId() {
    return reservationId;
  }

  public void setReservationId(Long reservationId) {
    this.reservationId = reservationId;
  }

  public Payments amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(example = "12345672", required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Payments currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Payments status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Payments paidOn(OffsetDateTime paidOn) {
    this.paidOn = paidOn;
    return this;
  }

  /**
   * Get paidOn
   * @return paidOn
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getPaidOn() {
    return paidOn;
  }

  public void setPaidOn(OffsetDateTime paidOn) {
    this.paidOn = paidOn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payments payments = (Payments) o;
    return Objects.equals(this.id, payments.id) &&
        Objects.equals(this.reservationId, payments.reservationId) &&
        Objects.equals(this.amount, payments.amount) &&
        Objects.equals(this.currency, payments.currency) &&
        Objects.equals(this.status, payments.status) &&
        Objects.equals(this.paidOn, payments.paidOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reservationId, amount, currency, status, paidOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payments {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    paidOn: ").append(toIndentedString(paidOn)).append("\n");
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
