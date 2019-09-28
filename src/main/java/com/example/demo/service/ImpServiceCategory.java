package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CategoryRepository;
import com.example.demo.model.Category;

@Service
public class ImpServiceCategory implements ServiceCategory {

	@Autowired
	private CategoryRepository service;

	@Override
	public Optional<Category> FindCategoryById(String id) {
		return service.findById(id);
	}

	@Override
	public Category addCategory(Category p) {
		return service.insert(p);
	}

	@Override
	public List<Category> findall() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public Optional<Category> FindCategoryByname(String nom) {
		// TODO Auto-generated method stub
		return service.findByName(nom);

	}

}
