package com.auroled.connection;

public class ConnectionParameters {
	
	private static final String DRIVER_NAME= "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "cricket_scoring";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD ="";
	
	public static String getDriverName() {
		return DRIVER_NAME;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	public static String getDbName() {
		return DB_NAME;
	}
	public static String getDbUser() {
		return DB_USER;
	}
	public static String getDbPassword() {
		return DB_PASSWORD;
	}
	
	
	
	
	
	
	
}
