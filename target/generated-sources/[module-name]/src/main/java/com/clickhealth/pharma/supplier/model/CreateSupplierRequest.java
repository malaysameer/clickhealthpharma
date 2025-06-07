package com.clickhealth.pharma.supplier.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateSupplierRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-07T11:32:48.610850936+05:30[Asia/Kolkata]")
public class CreateSupplierRequest {

  private String name;

  private String contactEmail;

  private String phone;

  private String address;

  /**
   * Default constructor
   * @deprecated Use {@link CreateSupplierRequest#CreateSupplierRequest(String, String, String)}
   */
  @Deprecated
  public CreateSupplierRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateSupplierRequest(String name, String contactEmail, String phone) {
    this.name = name;
    this.contactEmail = contactEmail;
    this.phone = phone;
  }

  public CreateSupplierRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateSupplierRequest contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * Get contactEmail
   * @return contactEmail
  */
  @NotNull @jakarta.validation.constraints.Email
  @Schema(name = "contactEmail", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contactEmail")
  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public CreateSupplierRequest phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @NotNull 
  @Schema(name = "phone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public CreateSupplierRequest address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  
  @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSupplierRequest createSupplierRequest = (CreateSupplierRequest) o;
    return Objects.equals(this.name, createSupplierRequest.name) &&
        Objects.equals(this.contactEmail, createSupplierRequest.contactEmail) &&
        Objects.equals(this.phone, createSupplierRequest.phone) &&
        Objects.equals(this.address, createSupplierRequest.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, contactEmail, phone, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSupplierRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

