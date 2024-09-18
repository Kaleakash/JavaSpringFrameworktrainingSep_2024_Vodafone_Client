package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;	// get database details from properties files. 
	
	public int storeProduct(Product product) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran  = manager.getTransaction();
		try {
		tran.begin();
			manager.persist(product);   // like save the record using insert query 
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.err.println(e);
			tran.rollback();
			return 0;
		}
		
	}
}
