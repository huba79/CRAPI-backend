/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author huba.tanczos
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-28T16:04:50.838Z[GMT]")

public class LoginResponse {
    @JsonProperty("userid")
    private Long userId;
    @JsonProperty("displayname")
    private String displayName;

    public LoginResponse(Long userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    sb.append("    userid: ").append(toIndentedString(userId)).append("\n");
    sb.append("    displayname: ").append(toIndentedString(displayName)).append("\n");
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
