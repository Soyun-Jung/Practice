package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DataAccessObject;
import dao.DataAccessObject.*;
import dto.MemberDTO;
import static db.JdbcUtil.*;
public class Access {

	DataAccessObject dao = DataAccessObject.getInstance();
	Connection con = db.JdbcUtil.getConnection();
	
	public Access() {
	}
	
	public boolean joinInfo(MemberDTO uib) {
		// TODO Auto-generated method stub
		
		boolean svc = false;
		
		dao.setConnection(con);
		
		if(dao.putUserInfo(uib)>0) {
			commit(con);
			svc=true;
			close(con);
		} else {
//			uib=null;
			uib.setUserName(null);
			close(con);
		}
		
		return svc;
	}

	public ArrayList<MemberDTO> getMemberList(ArrayList<MemberDTO> memberList) {
		// TODO Auto-generated method stub
		boolean svc = false;
		
		dao.setConnection(con);
		
		dao.getMemberList(memberList);
		
		return memberList;
	}

	public boolean IsAccess(MemberDTO uib) {
		
		boolean svc = false;
		Connection con = db.JdbcUtil.getConnection();
		dao.setConnection(con);

		if(dao.isAccess(uib)) {			
			commit(con);
			svc=true;
			close(con);
		}
		else {
			close(con);
		}
		return svc;
	}

	public boolean CanUseID(MemberDTO uib) {
		boolean svc = false;
		Connection con = db.JdbcUtil.getConnection();
		dao.setConnection(con);

		if(dao.CanUseID(uib)) {			
			commit(con);
			svc=true;
			close(con);
		}
		else {
			close(con);
		}
		return svc;
	
	}

}
