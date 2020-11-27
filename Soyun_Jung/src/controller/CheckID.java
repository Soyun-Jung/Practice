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
 * Servlet implementation class CheckID
 */
@WebServlet("/CheckID")
public class CheckID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		MemberDTO uib = new MemberDTO();
		String ID = request.getParameter("userId");
		uib.setUserId(ID);
		System.out.println(ID);
		
		Access ac = new Access();
		
		
		boolean a = ac.CanUseID(uib);
		
		if(a) {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("joinForm2.jsp");
			 
			 request.setAttribute("ID", ID);
			 dispatcher.forward(request, response);
			 
			 //response.sendRedirect("joinForm2.jsp");
		
		}else {
			//history.go(-1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("joinFail.jsp");
			dispatcher.forward(request, response);		
			//session.invalidate();
		}

	}

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
