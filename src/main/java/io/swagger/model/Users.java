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
 * Guests, clients, admins and managers(owners)
 */
@Schema(description = "Guests, clients, admins and managers(owners)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T16:04:50.838Z[GMT]")
@Entity

public class Users   {
  @JsonProperty("id")
  private @Id @GeneratedValue Long id = null;

  @JsonProperty("loginname")
  private String loginname = null;

  @JsonProperty("displayname")
  private String displayname = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("status")
  private int status = 0;
    
  public Users id(Long id) {
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

  public Users loginname(String loginname) {
    this.loginname = loginname;
    return this;
  }

  @Schema(description = "")
  
    public String getLoginname() {
    return loginname;
  }

  public void setLoginname(String loginname) {
    this.loginname = loginname;
  }

  public Users displayname(String displayname) {
    this.displayname = displayname;
    return this;
  }

  /**
   * Get displayname
   * @return displayname
   **/
  @Schema(description = "")
  
    public String getDisplayname() {
    return displayname;
  }

  public void setDisplayname(String displayname) {
    this.displayname = displayname;
  }

  public Users email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(description = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Users password(String password) {
    this.password = password;
    return this;
  }

  @Schema(description = "")
  
    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

    public Users status(int status) {
    this.status = status;
    return this;
  }

  @Schema(description = "")
  
    public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Users users = (Users) o;
    return Objects.equals(this.id, users.id) &&
        Objects.equals(this.loginname, users.loginname) &&
        Objects.equals(this.displayname, users.displayname) &&
        Objects.equals(this.email, users.email) &&
        Objects.equals(this.password, users.password) &&
        Objects.equals(this.status, users.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, loginname, displayname, email, password, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Users {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    loginname: ").append(toIndentedString(loginname)).append("\n");
    sb.append("    displayname: ").append(toIndentedString(displayname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
