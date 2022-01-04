package com.platziMarket.core.persistence.mapper;

import com.platziMarket.core.domain.Category;
import com.platziMarket.core.persistence.entity.Categoria;

public interface CategoryMapper {

	Category toCategory(Categoria categoria);

	Categoria toCategoria(Category category);

}
