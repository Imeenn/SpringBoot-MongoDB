
  package com.example.demo.service;
  
  import java.util.List;
import java.util.Optional;
  
  import com.example.demo.model.Product;
  
  public interface ServiceProduct { 
	 public Optional <Product>  FindProductById(String id); 
	  public Product addProduct(Product p);
	  List<Product> findall();
  
  
  }
 