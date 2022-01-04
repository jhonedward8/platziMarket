package com.platziMarket.core.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.platziMarket.core.domain.Product;
import com.platziMarket.core.persistence.entity.Producto;

public interface ProductMapper {
	
    Product toProduct(Producto producto);
    
    List<Product> toProducts(List<Producto> productos);

    Producto toProducto(Product product);

}
