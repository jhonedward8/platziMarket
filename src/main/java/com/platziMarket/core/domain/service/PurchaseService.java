package com.platziMarket.core.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.platziMarket.core.domain.Purchase;
import com.platziMarket.core.persistence.CompraRepository;
import com.platziMarket.core.persistence.entity.Compra;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PurchaseService {

	private CompraRepository compraRepository;
	
	public List<Purchase> getAll() {
		return compraRepository.getAll();
	}

	public Optional<List<Purchase>> getByClient(String clientId) {
		return compraRepository.getByClient(clientId);
	}

	public Purchase save(Purchase purchase) {
		return compraRepository.save(purchase);
	}
}
