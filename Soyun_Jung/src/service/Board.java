package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DataAccessObject;
import dto.BoardDTO;

public class Board {

	DataAccessObject dao = DataAccessObject.getInstance();
	Connection con = getConnection();

	public int bWrite(BoardDTO board) {
		System.out.println("2.service");
		dao.setConnection(con);


		int writeResult = dao.bWrite(board);
		System.out.println("6.service : " + writeResult);

		if(writeResult>0) {
			commit(con);
		} else {
			rollback(con);
		}

		return writeResult;
	}

	public int BoardDel(int bNum) {
		dao.setConnection(con);

		int delResult = dao.BoardDel(bNum);

		if(delResult>0) {
			commit(con);
		} else {
			rollback(con);
		}


		return delResult;
	}
	
	//리스트불러오기
	public ArrayList<BoardDTO> BoardList(ArrayList<BoardDTO> boardlist) {

		dao.setConnection(con);
		// 여기까지
		
		boardlist = dao.BoardList(boardlist);
		close(con);
		
		return boardlist;
	}

	public BoardDTO BoardView(int bNum) {
		dao.setConnection(con);

		// (1)조회수 증가
		int hitResult = dao.BoardBhit(bNum);
		if(hitResult>0) {
			commit(con);
		} else {
			rollback(con);
		}

		// (2)상세보기
		BoardDTO board = dao.BoardView(bNum);
		close(con);
		return board;
	}

	public void boardModi(String uName, int bNum) {
		dao.setConnection(con);
		
		dao.BoardModi(uName,bNum);
		
		
	}



}


