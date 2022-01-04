package com.platziMarket.core.persistence.mapper;

import org.springframework.stereotype.Component;

import com.platziMarket.core.domain.Category;
import com.platziMarket.core.persistence.entity.Categoria;

@Component
public class CategoryMapperImpl implements CategoryMapper{

	@Override
	public Category toCategory(Categoria categoria) {
		return Category.builder()
				.category(categoria.getDescripcion())
				.categoryId(categoria.getIdCategoria())
				.active(categoria.getEstado())
				.build();
	}

	@Override
	public Categoria toCategoria(Category category) {
		return Categoria.builder()
				.idCategoria(category.getCategoryId())
				.descripcion(category.getCategory())
				.estado(category.isActive())
				.build();
	}

}
