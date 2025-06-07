package com.clickhealth.pharma.purchase.model;

import java.net.URI;
import java.util.Objects;
import com.clickhealth.pharma.purchase.model.CreatePurchaseItemRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreatePurchaseRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-07T11:32:50.093250446+05:30[Asia/Kolkata]")
public class CreatePurchaseRequest {

  private Integer supplierId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime purchaseDate;

  private Double totalAmount;

  @Valid
  private List<@Valid CreatePurchaseItemRequest> items = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link CreatePurchaseRequest#CreatePurchaseRequest(Integer, OffsetDateTime, List<@Valid CreatePurchaseItemRequest>)}
   */
  @Deprecated
  public CreatePurchaseRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreatePurchaseRequest(Integer supplierId, OffsetDateTime purchaseDate, List<@Valid CreatePurchaseItemRequest> items) {
    this.supplierId = supplierId;
    this.purchaseDate = purchaseDate;
    this.items = items;
  }

  public CreatePurchaseRequest supplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  /**
   * Get supplierId
   * @return supplierId
  */
  @NotNull 
  @Schema(name = "supplierId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("supplierId")
  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  public CreatePurchaseRequest purchaseDate(OffsetDateTime purchaseDate) {
    this.purchaseDate = purchaseDate;
    return this;
  }

  /**
   * Get purchaseDate
   * @return purchaseDate
  */
  @NotNull @Valid 
  @Schema(name = "purchaseDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("purchaseDate")
  public OffsetDateTime getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(OffsetDateTime purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public CreatePurchaseRequest totalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * @return totalAmount
  */
  
  @Schema(name = "totalAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAmount")
  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public CreatePurchaseRequest items(List<@Valid CreatePurchaseItemRequest> items) {
    this.items = items;
    return this;
  }

  public CreatePurchaseRequest addItemsItem(CreatePurchaseItemRequest itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @NotNull @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid CreatePurchaseItemRequest> getItems() {
    return items;
  }

  public void setItems(List<@Valid CreatePurchaseItemRequest> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePurchaseRequest createPurchaseRequest = (CreatePurchaseRequest) o;
    return Objects.equals(this.supplierId, createPurchaseRequest.supplierId) &&
        Objects.equals(this.purchaseDate, createPurchaseRequest.purchaseDate) &&
        Objects.equals(this.totalAmount, createPurchaseRequest.totalAmount) &&
        Objects.equals(this.items, createPurchaseRequest.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(supplierId, purchaseDate, totalAmount, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePurchaseRequest {\n");
    sb.append("    supplierId: ").append(toIndentedString(supplierId)).append("\n");
    sb.append("    purchaseDate: ").append(toIndentedString(purchaseDate)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

