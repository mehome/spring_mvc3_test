package net.i77soft;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.i77soft.dbutils.DBManager;

public class Configurations {

	static public DataSource dataSource = null;
	private Connection g_conn = null;

	public static Connection getConnection() throws SQLException {
		return DBManager.getConnection();
	}

}
