package com.platziMarket.core.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComprasProductoPK implements Serializable {
	@Column(name = "id_compra")
	private Integer idCompra;

	@Column(name = "id_producto")
	private Integer idProducto;

}
