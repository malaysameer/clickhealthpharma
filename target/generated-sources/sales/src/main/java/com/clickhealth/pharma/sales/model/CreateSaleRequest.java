package com.clickhealth.pharma.sales.model;

import java.net.URI;
import java.util.Objects;
import com.clickhealth.pharma.sales.model.CreateSaleItemRequest;
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
 * CreateSaleRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-07T11:32:49.586830026+05:30[Asia/Kolkata]")
public class CreateSaleRequest {

  private Integer customerId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime saleDate;

  private Double totalAmount;

  @Valid
  private List<@Valid CreateSaleItemRequest> items = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link CreateSaleRequest#CreateSaleRequest(Integer, OffsetDateTime, List<@Valid CreateSaleItemRequest>)}
   */
  @Deprecated
  public CreateSaleRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateSaleRequest(Integer customerId, OffsetDateTime saleDate, List<@Valid CreateSaleItemRequest> items) {
    this.customerId = customerId;
    this.saleDate = saleDate;
    this.items = items;
  }

  public CreateSaleRequest customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @NotNull 
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerId")
  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public CreateSaleRequest saleDate(OffsetDateTime saleDate) {
    this.saleDate = saleDate;
    return this;
  }

  /**
   * Get saleDate
   * @return saleDate
  */
  @NotNull @Valid 
  @Schema(name = "saleDate", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("saleDate")
  public OffsetDateTime getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(OffsetDateTime saleDate) {
    this.saleDate = saleDate;
  }

  public CreateSaleRequest totalAmount(Double totalAmount) {
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

  public CreateSaleRequest items(List<@Valid CreateSaleItemRequest> items) {
    this.items = items;
    return this;
  }

  public CreateSaleRequest addItemsItem(CreateSaleItemRequest itemsItem) {
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
  public List<@Valid CreateSaleItemRequest> getItems() {
    return items;
  }

  public void setItems(List<@Valid CreateSaleItemRequest> items) {
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
    CreateSaleRequest createSaleRequest = (CreateSaleRequest) o;
    return Objects.equals(this.customerId, createSaleRequest.customerId) &&
        Objects.equals(this.saleDate, createSaleRequest.saleDate) &&
        Objects.equals(this.totalAmount, createSaleRequest.totalAmount) &&
        Objects.equals(this.items, createSaleRequest.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, saleDate, totalAmount, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSaleRequest {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    saleDate: ").append(toIndentedString(saleDate)).append("\n");
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

