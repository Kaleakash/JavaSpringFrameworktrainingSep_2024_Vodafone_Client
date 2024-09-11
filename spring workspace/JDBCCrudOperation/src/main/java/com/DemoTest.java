package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DemoTest {

	public static void main(String[] args) {
	
		try {
			// load the Driver 	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			// Establish the connection 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_db", "root", "root@123");
	//We can use Statement, PreparedStatement or CallableStatement etc 
	PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the product pid");
	int pid = sc.nextInt();
		pstmt.setInt(1, pid);
	
	System.out.println("Enter the pname");
	String pname = sc.next();
		pstmt.setString(2, pname);
	
	System.out.println("Enter the price");
	float price = sc.nextFloat();
		pstmt.setFloat(3, price);
	
	int res = pstmt.executeUpdate();		// DML insert, delete and update 
	
	if(res>0) {
		System.out.println("Record inserted successfully");
	}
	System.out.println("connected db");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
