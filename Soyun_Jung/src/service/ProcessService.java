package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.DataAccessObject;
import dao.DataAccessObject.*;
import dto.BoardDTO;

public class ProcessService {

	public int modiPro(BoardDTO board) {
		// 공통부분
		DataAccessObject dao = DataAccessObject.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int proResult = dao.modiPro(board);
		
		if(proResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return proResult;
	}

}
