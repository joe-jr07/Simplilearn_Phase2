package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Drvier is loaded");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/world","root","kennaath");
		System.out.println("connection is establsihed");
		
		Statement st = con.createStatement();
//		int res = st.executeUpdate("insert into books values(105,'hey sinamika',5000)");
//		System.out.println("Rows affected:"+ res);
		
		ResultSet rs = st.executeQuery("select * from books");
		
		while(rs.next()) {
			System.out.println("Id="+rs.getInt(1));
			System.out.println("name="+rs.getString(2));
			System.out.println("Price="+rs.getFloat(3));
			System.out.println();
		}
		
		con.close();
		
		
	}

}
