package com.sterlite.hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.IfPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sterlite.hibernate.data.repos.ProductRepository;
import com.sterlite.hibernate.entities.Product;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Component
public class HibernateMain implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateMain.class);
	
	@Autowired
	ProductRepository productRepos;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Insert product records
		Product product1 = new Product();
		//product1.setId(23323);
		product1.setName("LED TV");
		product1.setBrand("Sony");
		product1.setPrice(BigDecimal.valueOf(74800.00));
		
		product1 = productRepos.save(product1);
		LOGGER.info("new product " + product1.getId()+ " saved successfully!");
		
		Product product2 = new Product();
		product2.setName("Laptop");
		product2.setBrand("HP");
		product2.setPrice(BigDecimal.valueOf(32500.00));
		
		product2 = productRepos.save(product2);
		LOGGER.info("new product " + product2.getId()+ " saved successfully!");
			
		
		Product product3 = new Product();
		product3.setName("Washing Machine");
		product3.setBrand("Whirlpool");
		product3.setPrice(BigDecimal.valueOf(35700.00));
		
		product3 = productRepos.save(product3);
		LOGGER.info("new product " + product3.getId()+ " saved successfully!");
		
		Product product4 = new Product();
		product4.setName("Laptop");
		product4.setBrand("Lenovo");
		product4.setPrice(BigDecimal.valueOf(28500.00));
		
		product4 = productRepos.save(product4);
		LOGGER.info("new product " + product4.getId()+ " saved successfully!");
	
		
		
		// get product by id
		Optional<Product> productOptional = productRepos.findById(1);
		productOptional.ifPresent(System.out::println);
		productOptional.ifPresent(p->LOGGER.info("Product Record: " + p));
		
		// get all products
		LOGGER.info("All Products");
		List<Product> products = productRepos.findAll();
		//products.stream().forEach(p->System.out.println(p));
		products.stream().forEach(p->LOGGER.info(p.toString()));
		
		// update price of product
		productOptional = productRepos.findById(1);
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			BigDecimal oldPrice = product.getPrice();
			product.setPrice(oldPrice.add(BigDecimal.valueOf(1000.00)));
			productRepos.save(product);
			LOGGER.info("Product with id 1 updated successfully!");
		}else
			LOGGER.info("Product with id 1 not found");
		
		// delete product
		productOptional = productRepos.findById(2);
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			productRepos.delete(product);
			LOGGER.info("Product with id 2 deleted successfully!");
		}else
			LOGGER.info("Product with id 2 not found");
		
		
		// Invoking other extra methods
		
		products = productRepos.findByBrand("Sony");
		LOGGER.info("Products By Brand");
		products.forEach(p->LOGGER.info(p.toString()));
		
		products = productRepos.findByPriceBetween(BigDecimal.valueOf(20000.00), BigDecimal.valueOf(40000.00));
		LOGGER.info("Products By Price Range");
		products.forEach(p->LOGGER.info(p.toString()));
		
		
		LOGGER.info("Product Id and Name By Product Name");
		List<Object[]> rows = productRepos.findByProductName("Laptop");
		rows.stream().forEach(row->LOGGER.info("Id: " + row[0] + "\tName: " + row[1]));
		
		LOGGER.info("Before Update : ");
		productRepos.findById(3).ifPresent(p->LOGGER.info(p.toString()));
		int updateCount = productRepos.updatePriceById(3, BigDecimal.valueOf(39000.00));
		LOGGER.info("No of records updated : " + updateCount);
		LOGGER.info("After Update : ");
		productRepos.findById(3).ifPresent(p->LOGGER.info(p.toString()));
		
		productRepos.removeByName("Washing Machine");
	}

}
