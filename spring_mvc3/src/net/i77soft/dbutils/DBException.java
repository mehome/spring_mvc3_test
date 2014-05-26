package net.i77soft.dbutils;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class DBException extends RuntimeException {

	private int a = 0;

	public DBException() {
		super();
	}

	public DBException(Exception e) {
		super(e);
	}

	public DBException(SQLException e) {
		super(e);
	}

}
