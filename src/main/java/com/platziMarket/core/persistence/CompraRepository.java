package com.platziMarket.core.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.platziMarket.core.domain.Purchase;
import com.platziMarket.core.domain.repository.PurchaseRepository;
import com.platziMarket.core.persistence.crud.CompraCrudRepository;
import com.platziMarket.core.persistence.entity.Compra;
import com.platziMarket.core.persistence.mapper.PurchaseMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CompraRepository implements PurchaseRepository{
	
	private CompraCrudRepository compraCrudRepository;
	private PurchaseMapper purchaseMapper;

	@Override
	public List<Purchase> getAll() {
		return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
	}

	@Override
	public Optional<List<Purchase>> getByClient(String clientId) {
		return compraCrudRepository.findByIdCliente(clientId)
				.map(compras -> purchaseMapper.toPurchases(compras));
	}

	@Override
	public Purchase save(Purchase purchase) {
		Compra compra = purchaseMapper.tocomCompra(purchase);
		compra.getProductos().forEach(products -> products.setCompra(compra));
		return purchaseMapper.topPurchase(compraCrudRepository.save(compra));
	}

}
