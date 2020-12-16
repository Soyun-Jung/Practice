package Dao;

import static Util.JdbcUtil.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;




public class DataAccessObject {

	private static DataAccessObject dao;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	CallableStatement cs;

	public DataAccessObject() {

	}

	// getInstance메소드
	public static DataAccessObject getInstance() {
		if (dao == null) {
			dao = new DataAccessObject();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}


}
