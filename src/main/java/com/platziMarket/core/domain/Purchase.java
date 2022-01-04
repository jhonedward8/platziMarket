package com.platziMarket.core.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

	private int purchaseId;
	private String clientId;
	private LocalDateTime date;
	private String paymentMethod;
	private String comment;
	private String state;
	private List<PurchaseItem> items;
}
