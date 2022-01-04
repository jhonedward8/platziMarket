package com.platziMarket.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseItem {

	private int productId;
	private int quantity;
	private double total;
	private boolean active;
}
