package com.platziMarket.core.persistence.mapper;

import com.platziMarket.core.domain.PurchaseItem;
import com.platziMarket.core.persistence.entity.ComprasProducto;
import com.platziMarket.core.persistence.entity.ComprasProductoPK;

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

	
}
