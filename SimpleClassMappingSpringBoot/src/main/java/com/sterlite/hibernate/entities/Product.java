package com.sterlite.hibernate.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Entity
@Table(name = "PRODUCT1")
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 20)
	private String brand;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String name, String brand, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	

}
