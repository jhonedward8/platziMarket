package com.platziMarket.core.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platziMarket.core.domain.Purchase;
import com.platziMarket.core.domain.service.PurchaseService;
import com.platziMarket.core.persistence.entity.Compra;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/purchases")
@AllArgsConstructor
public class PurchaseController {
	
	private PurchaseService purchaseService; 
	
	@GetMapping("/")
	public ResponseEntity<List<Purchase>> getAll() {
		return ResponseEntity.ok(purchaseService.getAll());
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
		return ResponseEntity.of(purchaseService.getByClient(clientId));
	}

	@PostMapping("/")
	public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
		return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
	}

}
