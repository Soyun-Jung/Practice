package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// getInstance메소드
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글작성하기
	public int bWrite(BoardDTO board) {
		System.out.println("3.dao");
		String sql = "INSERT INTO BOARDT VALUES(BOARD_SEQ.NEXTVAL,?,?,?,?,SYSDATE,0,?)";
		int writeResult = 0;
		
		try {
			System.out.println("4.DB");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbTitle());
			pstmt.setString(4, board.getbContent());
			pstmt.setString(5, board.getbFile());
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("5.dao : " + writeResult);
		return writeResult;
	}

	public ArrayList<BoardDTO> BoardList() {
		String sql = "SELECT * FROM BOARDT";
		
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board= null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardDTO();
				
				board.setbNum(rs.getInt(1));
				board.setbWriter(rs.getString(2));
				board.setbPassword(rs.getString(3));
				board.setbTitle(rs.getString(4));
				board.setbContent(rs.getString(5));
				board.setbDate(rs.getString(6));
				board.setbHit(rs.getInt(7));
				board.setbFile(rs.getString(8));
				
				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardlist;
	}

	public int BoardDel(String bTitle) {
		int delResult = 0;
		String sql = "DELETE BOARDT WHERE bTitle=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			delResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return delResult;
	}

	public BoardDTO BoardView(String bTitle) {
		BoardDTO board = new BoardDTO();
		String sql = "SELECT * FROM BOARDT WHERE BTITLE = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setbNum(rs.getInt(1));
				board.setbWriter(rs.getString(2));
				board.setbPassword(rs.getString(3));
				board.setbTitle(rs.getString(4));
				board.setbContent(rs.getString(5));
				board.setbDate(rs.getString(6));
				board.setbHit(rs.getInt(7));
				board.setbFile(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println("dao :: "+board.toString());
		return board;
	}

	public int modiPro(BoardDTO board) {
		String sql = "UPDATE BOARDT SET BWRITER=?, BPASSWORD=?, BCONTENT=? WHERE BTITLE=?";
		int proResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbContent());
			pstmt.setString(4, board.getbTitle());
			proResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return proResult;
	}

	public int BoardBhit(String bTitle) {
		String sql = "UPDATE BOARDT SET BHIT = BHIT+1 WHERE BTITLE=?";
		int hitResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			hitResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return hitResult;
	}
}












