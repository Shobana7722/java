package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCode {
          
	    Connection con;
	    String dburl="jdbc:mysql://localhost:3306/accdb";
	    String dbuser="root";
		   String dbpass="shobana_77";
		   public DBCode() {
			   try {
				   con=DriverManager.getConnection(dburl,dbuser,dbpass);
				   System.out.println("DB Connected");
			   }catch (SQLException e) {
				   e.printStackTrace();
			   }
		   }

	public static void main(String[] args) {
		new DBCode();

	}

}
