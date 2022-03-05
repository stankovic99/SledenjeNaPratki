package com.stefan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserManagement {
	
	String url = "jdbc:mysql://localhost:3306/SledenjeNaPratki";
	String username = "root";
	String password = "123456";
	
	public boolean checkUserLogin(String uname, String pass)
	{
		String sql = "select * from user where username=? and pass=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkUsername(String uname)
	{
		String sql = "select * from user where username=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,uname);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public String getFullName(String uname) {
		String celoIme = "";
		String sql = "select * from user where username=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,uname);
			ResultSet rs = st.executeQuery();
			rs.next();
			celoIme = rs.getString(3) + " " + rs.getString(4);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return celoIme;
	}
	
	public void createUser(String uname, String pass, String name, String surname) {
		String sql = "insert into user values('"+uname+"','"+pass+"','"+name+"','"+surname+"')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement st = conn.createStatement();
			st.execute(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
