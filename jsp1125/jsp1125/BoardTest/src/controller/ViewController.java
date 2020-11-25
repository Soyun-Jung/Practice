package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.ViewService;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/boardView")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
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
		
		String bTitle = request.getParameter("bTitle");
		ViewService viewsvc = new ViewService();
		BoardDTO  board = viewsvc.BoardView(bTitle); 
		
		if(board != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardView.jsp");
			request.setAttribute("view", board);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("BoardWrite.jsp");
		}
		
	}

}
