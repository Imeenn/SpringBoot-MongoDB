
  package com.example.demo.service;
  
  import java.util.List;
import java.util.Optional;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;
  
  import com.example.demo.dao.ProductRepository; import
  com.example.demo.model.Product;
  
  @Service public class ImpServiceProduct implements ServiceProduct {
  
  
  @Autowired private ProductRepository service;
  
  @Override public Optional <Product> FindProductById(String id) { return
  service.findById(id); }
  
  @Override public Product addProduct(Product p) { return service.insert(p); }

@Override
public List<Product> findall() {
	// TODO Auto-generated method stub
	return service.findAll();
}
  
  }
 