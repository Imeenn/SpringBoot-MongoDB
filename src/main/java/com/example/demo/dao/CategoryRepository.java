package com.example.demo.dao;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Category;

public interface CategoryRepository  extends MongoRepository<Category, String>{
	
	
	/*
	 * Query query = new Query();
	 * query.addCriteria(Criteria.where("name").is("Eric")); List<User> users =
	 * mongoTemplate.find(query, User.class);
	 */
	//public List<Category>getallCatag();

public Optional<Category> findByName (String name);
}
