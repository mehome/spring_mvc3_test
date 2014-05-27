package net.i77soft;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.i77soft.dbutils.DBManager;

public class Configurations {

	public static DataSource dataSource = null;
	@SuppressWarnings("unused")
	private static Connection g_conn = null;

	public static Connection getConnection() throws SQLException {
		return DBManager.getConnection();
	}

	public static void closeConnection() throws SQLException {
		DBManager.closeConnection();
	}

}
