package com.platziMarket.core.persistence.mapper;

import java.util.List;

import com.platziMarket.core.domain.Purchase;
import com.platziMarket.core.persistence.entity.Compra;

public interface PurchaseMapper {

	Purchase topPurchase(Compra compra);
	
	List<Purchase> toPurchases(List<Compra> compras);
	
	Compra tocomCompra(Purchase purchase);
}
