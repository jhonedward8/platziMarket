package com.platziMarket.core.persistence.mapper;

import com.platziMarket.core.domain.PurchaseItem;
import com.platziMarket.core.persistence.entity.ComprasProducto;

public interface PurchaseItemMapper {

	PurchaseItem toPurchaseItem(ComprasProducto producto);
	
	ComprasProducto toComprasProducto(PurchaseItem item);
}
