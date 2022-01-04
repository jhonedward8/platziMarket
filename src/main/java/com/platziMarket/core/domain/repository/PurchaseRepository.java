package com.platziMarket.core.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platziMarket.core.domain.Purchase;

public interface PurchaseRepository {
	
	List<Purchase> getAll();
	
	Optional<List<Purchase>> getByClient(String clientId);
	
	Purchase save(Purchase purchase);

}
