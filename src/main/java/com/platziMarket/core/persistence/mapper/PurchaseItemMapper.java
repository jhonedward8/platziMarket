package com.platziMarket.core.persistence.mapper;

import java.util.List;

import com.platziMarket.core.domain.PurchaseItem;
import com.platziMarket.core.persistence.entity.ComprasProducto;

public interface PurchaseItemMapper {

	PurchaseItem toPurchaseItem(ComprasProducto producto);
	
	List<PurchaseItem> toPurchaseItems(List<ComprasProducto> comprasProductos);
	
	ComprasProducto toComprasProducto(PurchaseItem item);
	
	List<ComprasProducto> toComprasProductos(List<PurchaseItem> items);
}
