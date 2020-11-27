package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Board;

/**
 * Servlet implementation class modifyController
 */
@WebServlet("/bModify")
public class modifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyController() {
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
		response.setContentType("text/html; charset=UTF-8");
		
		String uName = request.getParameter("uName");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		Board bd=new Board();
		
		bd.boardModi(uName, bNum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModiForm.jsp");
		request.setAttribute("bNum", bNum);
		request.setAttribute("uName",uName);
		dispatcher.forward(request, response);
		
	}

}
