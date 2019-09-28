
  package com.example.demo.service;
  
  import java.util.List;
import java.util.Optional;
  
  import com.example.demo.model.Category;
  
  public interface ServiceCategory { 
	 public Optional <Category>  FindCategoryById(String id); 
	  public Category addCategory(Category p);
	  List<Category> findall();
public Optional <Category>  FindCategoryByname(String id); 

  
  
  }
 