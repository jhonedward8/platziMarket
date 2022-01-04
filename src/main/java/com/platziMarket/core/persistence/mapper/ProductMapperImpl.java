package com.platziMarket.core.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.platziMarket.core.domain.Category;
import com.platziMarket.core.domain.Product;
import com.platziMarket.core.persistence.entity.Categoria;
import com.platziMarket.core.persistence.entity.Producto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductMapperImpl implements ProductMapper{
	
	private CategoryMapper categoryMapper;

	@Override
	public Product toProduct(Producto producto) {
		return Product.builder()
				.active(producto.getEstado())
				.category(categoryMapper.toCategory(producto.getCategoria()))
				.categoryId(producto.getIdCategoria())
				.productId(producto.getIdProducto())
				.stock(producto.getCantidadStock())
				.price(producto.getPrecioVenta())
				.name(producto.getNombre())
				.build();
	}

	@Override
	public List<Product> toProducts(List<Producto> productos) {
		return productos.stream()
				.map(prod -> toProduct(prod)).collect(Collectors.toList());
	}

	@Override
	public Producto toProducto(Product product) {
		return Producto.builder()
				.categoria(categoryMapper.toCategoria(product.getCategory()))
				.estado(product.isActive())
				.idCategoria(product.getCategoryId())
				//.idProducto(product.getProductId())
				.cantidadStock(product.getStock())
				.precioVenta(product.getPrice())
				.nombre(product.getName())
				.build();
	}

}
