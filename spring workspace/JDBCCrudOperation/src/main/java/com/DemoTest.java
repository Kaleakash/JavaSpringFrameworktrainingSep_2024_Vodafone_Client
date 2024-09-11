package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DemoTest {

	public static void main(String[] args) {
	
		try {
			// load the Driver 	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			// Establish the connection 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/v_db", "root", "root@123");
	System.out.println("connected db");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
