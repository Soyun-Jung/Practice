package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.DAO;

public class CommentService {

	public JSONArray cList() {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		JSONArray cmtlist = dao.cList();
		
		return cmtlist;
	}

	public int cWrite(JSONObject jComment) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int insertResult = dao.cWriter(jComment);
		
		if(insertResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return insertResult;
	}

}















