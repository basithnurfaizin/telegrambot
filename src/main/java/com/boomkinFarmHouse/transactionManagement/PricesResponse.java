package com.boomkinFarmHouse.transactionManagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public  class PricesResponse {
	private String displayCurrency;
	private Boolean isGroupDisplay;
	private String qtyMetric;
	private Boolean isUnique;
	private String description;
	private Long createdAt;
	private Long expiredAt;
	private String title;
	private Integer onlineHr;
	private Double convertedUnitPrice;
	private Double score;
	private String offerCurrency;
	private Long updatedAt;
	private String offerGroup;
	private String serviceId;
	private String sellerId;
	@JsonProperty("display_price")
	private String displayPrice;
	private Integer minQty;
	private String regionId;
	private Integer availableQty;
	private Double unitPrice;
	private String offerId;
	private String relationId;
	private String brandId;
	private Integer actualQty;
	private Integer totalOffer;
	private String sellerRanking;
	private Integer userLevel;
	private Integer offlineHr;
	private String status;
	private String username;
}