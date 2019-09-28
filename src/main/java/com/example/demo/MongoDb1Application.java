package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@SpringBootApplication
public class MongoDb1Application {

	public static void main(String[] args) {
		
		
		SpringApplication.run(MongoDb1Application.class, args);
	}
	@Bean
	CommandLineRunner start(CategoryRepository c,ProductRepository p)
	{
		return args->{
			
			c.deleteAll();
			Category c1=c.save(new Category("C1", "C1", new ArrayList<>()));
			Category c2=c.save(new Category("C2", "C2", new ArrayList<>()));
			Category c3=c.save(new Category("C3", "C3", new ArrayList<>()));
			
			p.deleteAll();
         Product p1=   p.save(new Product("P1", "P1", 14, c1));
         Product p2=  p.save(new Product("P2", "P2", 15, c2));
         Product p3=  p.save(new Product("P3", "P3", 16, c3));

            c1.getProducts().add(p1);
            c2.getProducts().add(p2);
            c3.getProducts().add(p3);
            c.save(c1);
            c.save(c2);
            c.save(c3);


			c.findAll().forEach(System.out::println);
			p.findAll().forEach(System.out::println);
		
	};

}
	
}
