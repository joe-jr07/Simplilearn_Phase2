package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	
	public static Connection con;
	
	public static void initDatabase() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/world","root","kennaath");
			System.out.println("connection is establsihed");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean signIn(User user) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from users where username=? and password=?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs != null && rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean signUp(User user) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into users(username,password) values(?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (res == 1)? true:false;
	}

}
