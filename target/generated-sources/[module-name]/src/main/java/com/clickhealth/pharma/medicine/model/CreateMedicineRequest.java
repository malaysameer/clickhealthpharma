package com.clickhealth.pharma.medicine.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateMedicineRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-07T11:32:45.713557141+05:30[Asia/Kolkata]")
public class CreateMedicineRequest {

  private String name;

  private String batchNumber;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate expiryDate;

  private Integer quantity;

  private Double price;

  private Integer supplierId;

  /**
   * Default constructor
   * @deprecated Use {@link CreateMedicineRequest#CreateMedicineRequest(String, String, LocalDate, Integer, Double)}
   */
  @Deprecated
  public CreateMedicineRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateMedicineRequest(String name, String batchNumber, LocalDate expiryDate, Integer quantity, Double price) {
    this.name = name;
    this.batchNumber = batchNumber;
    this.expiryDate = expiryDate;
    this.quantity = quantity;
    this.price = price;
  }

  public CreateMedicineRequest name(String name) {
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

  public CreateMedicineRequest batchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
    return this;
  }

  /**
   * Get batchNumber
   * @return batchNumber
  */
  @NotNull 
  @Schema(name = "batchNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("batchNumber")
  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public CreateMedicineRequest expiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Get expiryDate
   * @return expiryDate
  */
  @NotNull @Valid 
  @Schema(name = "expiryDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("expiryDate")
  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }

  public CreateMedicineRequest quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * minimum: 0
   * @return quantity
  */
  @NotNull @Min(0) 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public CreateMedicineRequest price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * minimum: 0.01
   * @return price
  */
  @NotNull @DecimalMin("0.01") 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public CreateMedicineRequest supplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  /**
   * Get supplierId
   * @return supplierId
  */
  
  @Schema(name = "supplierId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("supplierId")
  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateMedicineRequest createMedicineRequest = (CreateMedicineRequest) o;
    return Objects.equals(this.name, createMedicineRequest.name) &&
        Objects.equals(this.batchNumber, createMedicineRequest.batchNumber) &&
        Objects.equals(this.expiryDate, createMedicineRequest.expiryDate) &&
        Objects.equals(this.quantity, createMedicineRequest.quantity) &&
        Objects.equals(this.price, createMedicineRequest.price) &&
        Objects.equals(this.supplierId, createMedicineRequest.supplierId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, batchNumber, expiryDate, quantity, price, supplierId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateMedicineRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    batchNumber: ").append(toIndentedString(batchNumber)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    supplierId: ").append(toIndentedString(supplierId)).append("\n");
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

