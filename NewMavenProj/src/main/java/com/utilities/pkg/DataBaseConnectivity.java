package com.utilities.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.mysql.jdbc.Driver;

public class DataBaseConnectivity {
	public HashMap<String, String> mapdatasheet;
	String DBName = "Local instance MySQL57";
	String DBUser = "root";
	String DBPassword = "password";
	String DBType = "";
	String DBip = "";
	//static final String MYSQL_DRIVER = "com.mysql.jdbc.driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/auto";
	public Connection con = null;
	public ResultSet rs = null;
	public ResultSet rscol = null;
	LinkedHashMap<String,String> datamap = new LinkedHashMap<String,String>();

	public LinkedHashMap<String,String> getDatabase(String table, String testcase) throws ClassNotFoundException, SQLException {
		//Class.forName(MYSQL_DRIVER);
		try {
			con = DriverManager.getConnection(MYSQL_URL, DBUser, DBPassword);
			System.out.println("DB Connected successfully");
		} catch (Exception e) {
			System.out.println("DB NOT Connected");
		}
		//LinkedHashMap<String,String> datamap = new LinkedHashMap<String,String>();
		//String querycol = "show columns from user;";
		String querycol = "show columns from " + table + ";";
				Statement stmtcol = con.createStatement();
		rscol = stmtcol.executeQuery(querycol);
		List<String> cols = new ArrayList<String>();
		while (rscol.next())
		{
			cols.add(rscol.getString(1));
		}
		//System.out.println("cols size is:" + cols.size());
		String query = "select * from " + table + " where TestCaseID = '" + testcase + "';";
		System.out.println(query);
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			//System.out.println("DB data is:" + username + "," + password);
			for (int i = 1; i < cols.size(); i++) {				
				datamap.put(cols.get(i), rs.getNString(cols.get(i)));
				//System.out.println(datamap);
			}
		}
		return datamap;
		
		 
		}
	
	}	

