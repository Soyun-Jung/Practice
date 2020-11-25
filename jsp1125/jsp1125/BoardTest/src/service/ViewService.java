package service;

import static dao.BoardDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class ViewService {

	public BoardDTO BoardView(String bTitle) {
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		
		// (1)조회수 증가
		int hitResult = dao.BoardBhit(bTitle);
		if(hitResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		// (2)상세보기
		BoardDTO board = dao.BoardView(bTitle);
		close(con);
		return board;
	}

}
