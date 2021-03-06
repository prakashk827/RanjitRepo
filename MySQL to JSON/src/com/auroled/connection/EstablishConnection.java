package com.auroled.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {
	static Connection con = null;
		public void getConnection() {

		try {
			Class.forName(ConnectionParameters.getDriverName());
			try {
				con = DriverManager.getConnection(ConnectionParameters.getDbUrl() + ConnectionParameters.getDbName(), ConnectionParameters.getDbUser(),
						ConnectionParameters.getDbPassword());
			} catch (SQLException e) {
				System.out.println("Error while establishing connection between database");
				System.out.println("Please check database name , user name and password");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error while loading mysql driver");
			e.printStackTrace();
		}

	}
}
