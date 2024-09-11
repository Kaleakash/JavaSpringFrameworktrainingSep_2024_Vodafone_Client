package com;

public class DemoTest {

	public static void main(String[] args) {
	
		try {
			// load the Driver 	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
