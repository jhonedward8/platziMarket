package com.platziMarket.core.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.platziMarket.core.domain.Purchase;
import com.platziMarket.core.persistence.entity.Compra;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PurchaseMapperImpl implements PurchaseMapper{
	
	private PurchaseItemMapper purchaseItemMapper;

	@Override
	public Purchase topPurchase(Compra compra) {
		return Purchase.builder()
				.purchaseId(compra.getIdCompra())
				.clientId(compra.getIdCliente())
				.date(compra.getFecha())
				.paymentMethod(compra.getMedioPago())
				.comment(compra.getComentario())
				.state(compra.getEstado())
				.items(purchaseItemMapper.toPurchaseItems(compra.getProductos()))
				.build();
	}

	@Override
	public List<Purchase> toPurchases(List<Compra> compras) {
		return compras.stream()
				.map(comp -> topPurchase(comp))
				.collect(Collectors.toList());
	}

	@Override
	public Compra tocomCompra(Purchase purchase) {
		return Compra.builder()
				.idCompra(purchase.getPurchaseId())
				.idCliente(purchase.getClientId())
				.fecha(purchase.getDate())
				.medioPago(purchase.getPaymentMethod())
				.comentario(purchase.getComment())
				.estado(purchase.getState())
				.productos(purchaseItemMapper.toComprasProductos(purchase.getItems()))
				.build();
	}

}
