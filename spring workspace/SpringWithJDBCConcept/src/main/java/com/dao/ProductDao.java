package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {

	//@Autowired 
	//DataSource ds;			// byType auto wired 
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	public int storeProduct(Product product) {
//		try {
//		Connection con = ds.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
//		pstmt.setInt(1, product.getPid());
//		pstmt.setString(2, product.getPname());
//		pstmt.setFloat(3, product.getPrice());
//		return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
	
	public int storeProduct(Product product) {
		try {
	return jdbcTemplate.update("insert into product values(?,?,?)", product.getPid(),product.getPname(),product.getPrice());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
//	public int updateProductPrice(Product product) {
//		try {
//		Connection con = ds.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("update product set price = ? where pid = ?");
//		pstmt.setFloat(1, product.getPrice());
//		pstmt.setInt(2, product.getPid());
//		return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
	
	public int updateProductPrice(Product product) {
		try {
return jdbcTemplate.update("update product set price = ? where pid = ?",product.getPrice(),product.getPid());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
//	public int deleteProduct(int pid) {
//		try {
//		Connection con = ds.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("delete from product where pid=?");
//		pstmt.setInt(1, pid);
//		return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
	
	public int deleteProduct(int pid) {
		try {
	return jdbcTemplate.update("delete from product where pid=?", pid);
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
//	public List<Product> findAll() {
//		List<Product> listOfProducts = new ArrayList<Product>();
//		try {
//		Connection con = ds.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("select * from product");
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()) {
//			Product p = new Product();
//			p.setPid(rs.getInt(1));
//			p.setPname(rs.getString(2));
//			p.setPrice(rs.getFloat(3));
//			listOfProducts.add(p);
//		}
//		} catch (Exception e) {
//			System.err.println(e);
//		}
//		return listOfProducts;
//	}
	
	public List<Product> findAll() {
		try {
			// 1st parameter query and 2nd para RowMapper interface reference. 
return jdbcTemplate.query("select * from product", new MyRowMapper());		
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	public List<Map<String, Object>> findAllProductAsMap() {
		try {
	return jdbcTemplate.queryForList("select * from product");
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
}
// Global while loop 
class MyRowMapper implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p1 = new Product();
		p1.setPid(rs.getInt(1));
		p1.setPname(rs.getString(2));
		p1.setPrice(rs.getFloat(3));
		return p1;
	}
}