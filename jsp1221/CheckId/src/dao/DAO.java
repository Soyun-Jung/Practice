package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static db.JdbcUtil.*;

public class DAO {
	
	private static DAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static DAO getInstance() {
		if(dao==null) {
			dao = new DAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	
	// �븘�씠�뵒 以묐났 泥댄겕
	public String IdCheck(String userId) {
		String sql = "SELECT USERID FROM MEMBERT WHERE USERID=?";
		String checkResult = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkResult = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("checkResult DAO : " + checkResult);
		return checkResult;
	}

	public JSONArray cList() {
		String sql = "SELECT * FROM COMMENTT";
		
		JSONArray cmtlist = new JSONArray();
		JSONObject jComment = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				jComment = new JSONObject();
				jComment.put("cWriter", rs.getString(1) );
				jComment.put("cContent", rs.getString(2) );
				jComment.put("cDate", rs.getString(3) );
				
				cmtlist.add(jComment);
				System.out.println(jComment);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cmtlist;
	}

	public int cWriter(JSONObject jComment) {
		String sql = "INSERT INTO COMMENTT VALUES(?,?,SYSDATE)";
		int insertResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, (String)jComment.get("cWriter"));
			pstmt.setString(2, (String)jComment.get("cContent"));
			insertResult = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return insertResult;
	}
	
	
}








