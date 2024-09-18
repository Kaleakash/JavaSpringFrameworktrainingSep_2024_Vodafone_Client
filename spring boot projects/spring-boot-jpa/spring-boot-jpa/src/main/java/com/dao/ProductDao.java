package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

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
	
	public int deleteProduct(int pid) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran  = manager.getTransaction();
		Product p	= manager.find(Product.class, pid);	// select * from product where pid =1
		if(p==null) {
			return 0;
		}else {
			tran.begin();
				manager.remove(p);		// delete from product where pid=1
			tran.commit();
			return 1;
		}
	}
	
	
	public int updateProductPrice(Product product) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran  = manager.getTransaction();
		Product p	= manager.find(Product.class, product.getPid());	// select * from product where pid =1
		if(p==null) {
			return 0;
		}else {
			tran.begin();
				p.setPrice(product.getPrice());
				manager.merge(p);            // update the product 
 			tran.commit();
			return 1;
		}
	}
	
	public Product searchProductByPid(int pid) {
		EntityManager manager = emf.createEntityManager();
		Product p	= manager.find(Product.class, pid);
		return p;
	}
	
	public List<Product> findAllProduct() {
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select p from Product p");
		List<Product> listOfProuct = qry.getResultList();
		return listOfProuct;
	}
}
