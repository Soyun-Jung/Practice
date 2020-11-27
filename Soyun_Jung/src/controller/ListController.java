package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.Board;


@WebServlet("/bList")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListController() {
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
		
		String ID = request.getParameter("uID");
		String Name = request.getParameter("uName");
		Board bd = new Board();
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		boardlist = bd.BoardList(boardlist);
		
		if(boardlist != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("main2.jsp");
			request.setAttribute("ID", ID);
			request.setAttribute("Name", Name);
			request.setAttribute("board", boardlist);
			dispatcher.forward(request, response);
		}
    }

}
