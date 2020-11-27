package dao;

import static db.JdbcUtil.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import db.JdbcUtil;
import dto.BoardDTO;
import dto.MemberDTO;


public class DataAccessObject {

	private static DataAccessObject dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	

	public static DataAccessObject getInstance() {
		
		if(dao==null) {
			dao=new DataAccessObject();
		}
		
		return dao;
	}
	
	//setConnection �ż���
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int putUserInfo(MemberDTO uib) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USERINFO_SY(USERID, USERPW, USERNAME, USERBIRTH, USERGENDER, USEREMAIL) VALUES( ? , ? , ? ,TO_DATE( ? ,'YYYY-MM-DD'), ? , ? )";
		
		int daoResult = 0;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, uib.getUserId());
			pstmt.setNString(2, uib.getUserPw());
			pstmt.setNString(3, uib.getUserName());
			pstmt.setNString(4, uib.getUserBirth());
			pstmt.setNString(5, uib.getUserGender());
			pstmt.setNString(6, uib.getUserEmail());
			
			daoResult=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return daoResult;
		
	}

	public void getMemberList(ArrayList<MemberDTO> memberList) {
		// TODO Auto-generated method stub
		String sql = "SELECT USERID AS ID, USERNAME AS NAME, USERBIRTH AS BIRTH, USERGENDER AS GENDER, USEREMAIL AS EMAIL FROM USERINFO_SY ORDER BY USERNAME";

		try {
			pstmt = con.prepareStatement(sql);
//
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO user = new MemberDTO();
				user.setUserId(rs.getNString("ID"));
				user.setUserName(rs.getNString("NAME"));
				user.setUserBirth(rs.getNString("BIRTH"));
				user.setUserGender(rs.getNString("GENDER"));
				user.setUserEmail(rs.getNString("EMAIL"));
				
				memberList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isAccess(MemberDTO uib) {
		boolean result = false;
		String sql = "{call LOGIN_SY(?,?,?,?,?,?)}";
		CallableStatement cs;

		try {
			cs = con.prepareCall(sql);

			cs.setNString(1, uib.getUserId());
			cs.setNString(2, uib.getUserPw());
			cs.registerOutParameter(3, Types.NVARCHAR);
			cs.registerOutParameter(4, Types.NVARCHAR);
			cs.registerOutParameter(5, Types.NVARCHAR);
			cs.registerOutParameter(6, Types.NVARCHAR);

			cs.execute();

			uib.setUserName(cs.getNString(3));
			uib.setUserGender(cs.getNString(4));
			uib.setUserBirth(cs.getNString(5));
			uib.setUserEmail(cs.getNString(6));

			result=uib.getUserName()!=null?true:false;
			System.out.println(result);

			close(cs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void getBoardList(ArrayList<BoardDTO> boardlist) {
		String sql = "SELECT * FROM BOARD_SY";

		BoardDTO board = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
		
	}
	
	public int bWrite(BoardDTO board) {
		System.out.println("3.dao");
		String sql = "INSERT INTO BOARD_SY VALUES(SEQ_SOYUN.NEXTVAL,?,?,?,?,SYSDATE,0,?)";
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

	public ArrayList<BoardDTO> BoardList(ArrayList<BoardDTO> boardlist) {
		String sql = "SELECT * FROM BOARD_SY ORDER BY BNUM";

		BoardDTO board = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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

	public int BoardDel(int bNum) {
		int delResult = 0;
		String sql = "DELETE BOARD_SY WHERE BNUM=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			delResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return delResult;
	}

	public BoardDTO BoardView(int bNum) {
		BoardDTO board = new BoardDTO();
		String sql = "SELECT * FROM BOARD_SY WHERE BNUM = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
		System.out.println("dao :: " + board.toString());
		return board;
	}

	public int modiPro(BoardDTO board) {
		String sql = "UPDATE BOARD_SY SET BPASSWORD=?, BTITLE=?, BCONTENT=? WHERE BNUM=? AND BWRITER=?";
		int proResult = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(5, board.getbWriter());
			pstmt.setString(1, board.getbPassword());
			pstmt.setString(2, board.getbTitle());
			pstmt.setString(3, board.getbContent());
			pstmt.setInt(4, board.getbNum());
			proResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return proResult;
	}

	public int BoardBhit(int bNum) {
		String sql = "UPDATE BOARD_SY SET BHIT = BHIT+1 WHERE BNUM=?";
		int hitResult = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			hitResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return hitResult;
	}

	public int ListCount() {
		String sql = "SELECT COUNT(*) FROM BOARD_SY";
		int listCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return listCount;
	}

	public ArrayList<BoardDTO> BoardList(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST_SY WHERE RN BETWEEN ? AND ?";
		
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		System.out.println("dao con : " + con);

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardDTO();

				board.setbNum(rs.getInt(1));
				board.setbWriter(rs.getString(2));
				board.setbPassword(rs.getString(3));
				board.setbTitle(rs.getString(4));
				board.setbContent(rs.getString(5));
				board.setbDate(rs.getString(6));
				board.setbHit(rs.getInt(7));
				board.setbFile(rs.getString(8));

				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;

	}

	public boolean CanUseID(MemberDTO uib) {
		String sql = "SELECT COUNT(*) AS CANUSE FROM USERINFO_SY WHERE USERID=?";
		Boolean CanUse = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, uib.getUserId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				CanUse = rs.getInt("CANUSE")==0?true:false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
				close(pstmt);
				close(rs);
			}
		return CanUse;
	}

	public void BoardModi(String uName, int bNum) {
		// TODO Auto-generated method stub
		
	}


}
