package com.clickhealth.pharma.purchase.model;

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
 * CreatePurchaseItemRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-07T11:32:50.093250446+05:30[Asia/Kolkata]")
public class CreatePurchaseItemRequest {

  private Integer medicineId;

  private Integer quantity;

  private Double cost;

  /**
   * Default constructor
   * @deprecated Use {@link CreatePurchaseItemRequest#CreatePurchaseItemRequest(Integer, Integer, Double)}
   */
  @Deprecated
  public CreatePurchaseItemRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreatePurchaseItemRequest(Integer medicineId, Integer quantity, Double cost) {
    this.medicineId = medicineId;
    this.quantity = quantity;
    this.cost = cost;
  }

  public CreatePurchaseItemRequest medicineId(Integer medicineId) {
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

  public CreatePurchaseItemRequest quantity(Integer quantity) {
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

  public CreatePurchaseItemRequest cost(Double cost) {
    this.cost = cost;
    return this;
  }

  /**
   * Get cost
   * @return cost
  */
  @NotNull 
  @Schema(name = "cost", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cost")
  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePurchaseItemRequest createPurchaseItemRequest = (CreatePurchaseItemRequest) o;
    return Objects.equals(this.medicineId, createPurchaseItemRequest.medicineId) &&
        Objects.equals(this.quantity, createPurchaseItemRequest.quantity) &&
        Objects.equals(this.cost, createPurchaseItemRequest.cost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(medicineId, quantity, cost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePurchaseItemRequest {\n");
    sb.append("    medicineId: ").append(toIndentedString(medicineId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
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

