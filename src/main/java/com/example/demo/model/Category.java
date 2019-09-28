package com.example.demo.model;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Category {
	public Category() {
		super();
	}

	public Category(String id, String name, Collection<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	@Id
	private String id;
	private String name;
	@DBRef
	private Collection<Product> products = new ArrayList<Product>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	

}
