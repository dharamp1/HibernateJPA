package com.sterlite.hibernate.data.repos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sterlite.hibernate.entities.Product;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByBrand(String brand);
	
	List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
	
	@Query("select p.id,p.name from Product p where p.name=?1")
	List<Object[]> findByProductName(String name);
	
	@Modifying
	@Query("update Product p set p.price = ?2 where p.id = ?1")
	int updatePriceById(int id,BigDecimal price);
	
	@Modifying
	@Query("delete from Product p where p.name=?1")
	void removeByName(String name);
	
}
