package com.sterlite.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
@Entity
//@Table(name = "PRODUCT")
public class Product {
	
	@Id
	private int id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String brand;
	
	private float price;
	
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
}
