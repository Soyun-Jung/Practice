package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IdcheckService;


@WebServlet("/idCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("html/text; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		System.out.println("userId : " + userId);
		
		IdcheckService idsvc = new IdcheckService();
		String checkResult = idsvc.IdCheck(userId);
		
		if(checkResult==null) {		// 아이디 중복 X , 사용가능
			RequestDispatcher dispatcher = request.getRequestDispatcher("JoinForm1.jsp");
			request.setAttribute("userId", userId);
			dispatcher.forward(request, response);
		} else {					// 아이디 중복 O , 사용불가능
			RequestDispatcher dispatcher = request.getRequestDispatcher("JoinForm2.jsp");
			request.setAttribute("checkResult", checkResult);
			dispatcher.forward(request, response);
		}
		
		
	}

}



















