package com.platziMarket.core.domain;

import java.util.List;

import com.platziMarket.core.persistence.entity.Categoria;
import com.platziMarket.core.persistence.entity.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
	
    private int categoryId;
    private String category;
    private boolean active;
    
}
