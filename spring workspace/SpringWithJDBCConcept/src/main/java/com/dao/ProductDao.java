package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {

	@Autowired 
	DataSource ds;			// byType auto wired 
	
	public int storeProduct(Product product) {
		try {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
		pstmt.setInt(1, product.getPid());
		pstmt.setString(2, product.getPname());
		pstmt.setFloat(3, product.getPrice());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int updateProductPrice(Product product) {
		try {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update product set price = ? where pid = ?");
		pstmt.setFloat(1, product.getPrice());
		pstmt.setInt(2, product.getPid());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int deleteProduct(int pid) {
		try {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from product where pid=?");
		pstmt.setInt(1, pid);
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Product> findAll() {
		List<Product> listOfProducts = new ArrayList<Product>();
		try {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from product");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			listOfProducts.add(p);
		}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfProducts;
	}
}
