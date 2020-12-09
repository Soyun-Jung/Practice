package dao;


import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MessageDTO;

public class MessageDAO {
	private static MessageDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MessageDAO() {
		
	}
	
	public static MessageDAO getInstance() {
		if (dao == null) {
			dao = new MessageDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public boolean MessageSend(MessageDTO ms) {
		boolean result = false;
		String sql = "INSERT INTO MESSAGE VALUES(?,?,?,SYSDATE,?)";
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, ms.getMs_mbid());
			pstmt.setNString(2, ms.getMs_bdmbid());
			pstmt.setNString(3, ms.getMs_text());
			pstmt.setInt(4, ms.getMs_bdnum());
			result = (pstmt.executeUpdate()==1)?true:false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public ArrayList<MessageDTO> getMsgList(String ID) {
		ArrayList<MessageDTO> msglist = new ArrayList<MessageDTO>();
		MessageDTO msg = null;

		String sql = "SELECT MS_MBID AS SENDER, MS_BDMBID AS RECEIVER, MS_TEXT AS MESSAGE, MS_DATE AS DATES FROM MESSAGE WHERE MS_BDMBID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, ID);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				msg=new MessageDTO();
				
				msg.setMs_bdmbid(rs.getNString("RECEIVER"));
				msg.setMs_mbid(rs.getNString("SENDER"));
				msg.setMs_date(rs.getNString("DATES"));
				msg.setMs_text(rs.getNString("MESSAGE"));
				
				msglist.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return msglist;
	}

}
