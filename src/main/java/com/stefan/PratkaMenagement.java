package com.stefan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.UUID;

public class PratkaMenagement {
	String url = "jdbc:mysql://localhost:3306/SledenjeNaPratki";
	String username = "root";
	String password = "123456";
	
	public void newShipment(String datumOd, String datumDo, String lokacija) {
		String id = UUID.randomUUID().toString();
		String[] newId = id.split("-");
		
		String sql = "insert into pratka values('"+newId[4]+"','"+datumOd+"','"+datumDo+"','Delivering','"+lokacija+"')";
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
	
	public void deleteShipment(String id) {
		String sql = "delete from pratka where id='"+id+"'";
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
	public void changeShipment(String id, String lokacija, String status,String datumDo) {
		String sql = "update pratka set status='"+status+"',lokacija='"+lokacija+"', datumDo='"+datumDo+"' where id='"+id+"'";
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
