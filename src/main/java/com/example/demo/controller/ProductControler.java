
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ImpServiceProduct;

@RestController

@RequestMapping("/api")
public class ProductControler {

	@Autowired
	ImpServiceProduct service;

//affichage
	@GetMapping("/Products")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> ct = new ArrayList<>();
		try {
			// ajouter les elements a la liste
			service.findall().forEach(ct::add);

			// si la liste est vide
			if (ct.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			// sinon retourner la liste
			return new ResponseEntity<>(ct, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") String code) {
		Optional<Product> ProductData = service.FindProductById(code);
		if (ProductData.isPresent()) {
			return new ResponseEntity<>(ProductData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product ct) {
		try {
			Product _Product = service.addProduct(ct);

			return new ResponseEntity<>(_Product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
