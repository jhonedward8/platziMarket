package com.platziMarket.core.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.platziMarket.core.domain.PurchaseItem;
import com.platziMarket.core.persistence.entity.ComprasProducto;
import com.platziMarket.core.persistence.entity.ComprasProductoPK;

@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper{

	@Override
	public PurchaseItem toPurchaseItem(ComprasProducto producto) {
		return PurchaseItem.builder()
				.active(producto.getEstado())
				.quantity(producto.getCantidad())
				.productId(producto.getId().getIdProducto())
				.build();
	}

	@Override
	public ComprasProducto toComprasProducto(PurchaseItem item) {		
		return ComprasProducto.builder()
				.estado(item.isActive())
				.cantidad(item.getQuantity())
				.id(ComprasProductoPK.builder()
						.idProducto(item.getProductId())
						.build())
				.build();
	}

	@Override
	public List<PurchaseItem> toPurchaseItems(List<ComprasProducto> comprasProductos) {
		return comprasProductos.stream()
				.map(compraprod -> toPurchaseItem(compraprod))
				.collect(Collectors.toList());
	}

	@Override
	public List<ComprasProducto> toComprasProductos(List<PurchaseItem> items) {
		return items.stream()
				.map(item -> toComprasProducto(item))
				.collect(Collectors.toList());
	}

	
}
