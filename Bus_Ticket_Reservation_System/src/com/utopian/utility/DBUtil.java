package com.utopian.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection provideConnection() {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException cnfe) {

			cnfe.printStackTrace();

		}

		String url = "jdbc:mysql://localhost:3306/sb101_mini_project";

		try {

			conn = DriverManager.getConnection(url, "root", "root");

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return conn;

	}

}
