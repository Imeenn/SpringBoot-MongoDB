
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

import com.example.demo.model.Category;
import com.example.demo.service.ImpServiceCategory;

@RestController

@RequestMapping("/api")
public class CategoryControler {

	@Autowired
	ImpServiceCategory service;

//affichage
	@GetMapping("/Categorys")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> ct = new ArrayList<>();
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

	@GetMapping("/Categorys/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") String code) {
		Optional<Category> CategoryData = service.FindCategoryById(code);
		if (CategoryData.isPresent()) {
			return new ResponseEntity<>(CategoryData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/Categorys")
	public ResponseEntity<Category> addCategory(@RequestBody Category ct) {
		try {
			Category _Category = service.addCategory(ct);

			return new ResponseEntity<>(_Category, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

}
