package com.demko.grpc_soc;

import java.sql.*;
import org.postgresql.Driver;

public class DBWorker {
	private final String HOST = "jdbc:postgresql://rogue.db.elephantsql.com:5432/zkingcll";
	private final String USERNAME = "zkingcll";
	private final String PASSWORD = "EZJxuBtaPBs76YSmzYwtPEMPjoSffdGA";

	private Connection connection;

	
	private static DBWorker instance;

	public static synchronized DBWorker getInstance() {
		if (instance == null) {
			instance = new DBWorker();
		}
		return instance;
	}
	
	public DBWorker() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}



}
