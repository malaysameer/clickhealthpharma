package com.clickhealth.pharma.sales.model;

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
 * CreateSaleItemRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-07T11:32:49.586830026+05:30[Asia/Kolkata]")
public class CreateSaleItemRequest {

  private Integer medicineId;

  private Integer quantity;

  private Double price;

  /**
   * Default constructor
   * @deprecated Use {@link CreateSaleItemRequest#CreateSaleItemRequest(Integer, Integer, Double)}
   */
  @Deprecated
  public CreateSaleItemRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateSaleItemRequest(Integer medicineId, Integer quantity, Double price) {
    this.medicineId = medicineId;
    this.quantity = quantity;
    this.price = price;
  }

  public CreateSaleItemRequest medicineId(Integer medicineId) {
    this.medicineId = medicineId;
    return this;
  }

  /**
   * Get medicineId
   * @return medicineId
  */
  @NotNull 
  @Schema(name = "medicineId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("medicineId")
  public Integer getMedicineId() {
    return medicineId;
  }

  public void setMedicineId(Integer medicineId) {
    this.medicineId = medicineId;
  }

  public CreateSaleItemRequest quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public CreateSaleItemRequest price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @NotNull 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSaleItemRequest createSaleItemRequest = (CreateSaleItemRequest) o;
    return Objects.equals(this.medicineId, createSaleItemRequest.medicineId) &&
        Objects.equals(this.quantity, createSaleItemRequest.quantity) &&
        Objects.equals(this.price, createSaleItemRequest.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(medicineId, quantity, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSaleItemRequest {\n");
    sb.append("    medicineId: ").append(toIndentedString(medicineId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

