package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.Access;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinController() {

		super();
		// TODO Auto-generated constructor stub


	}

	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		MemberDTO uib = new MemberDTO();
		Access ac = new Access();

		uib.setUserId(request.getParameter("userId"));
		uib.setUserPw(request.getParameter("userPw"));
		uib.setUserName(request.getParameter("userName"));
		uib.setUserGender(request.getParameter("userGender"));
		uib.setUserBirth(request.getParameter("userBirth"));
		uib.setUserEmail(request.getParameter("userEmail"));
		
		ac.joinInfo(uib);

		if(uib.getUserName()!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("joinMember.jsp");
			 request.setAttribute("userId", uib.getUserId());
			 request.setAttribute("userName", uib.getUserName());
			 request.setAttribute("userGender", uib.getUserGender());
			 request.setAttribute("userBirth", uib.getUserBirth());
			 request.setAttribute("userEmail", uib.getUserEmail());
			 dispatcher.forward(request, response);		
			
		}	
		else {
			response.sendRedirect("joinFail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProccess(request, response);
	}

}
