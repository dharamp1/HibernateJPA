package com.sterlite.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sterlite.hibernate.entities.Product;
/*
 * @author dharamraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd
 * @creationdate 1st Sep 2020
 */
public class HibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		
		// Heavyweight and Singleton object
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Lightweight and there can be sessions in one hibernate app
		Session session = factory.openSession();
		
		
		Transaction tx = session.beginTransaction();
		
		Product product = new Product();
		product.setId(1002);
		product.setName("Laptop");
		product.setBrand("HP");
		product.setPrice(32500.00f);
		
		session.save(product);
		
		tx.commit();
		session.close();
	}

}
