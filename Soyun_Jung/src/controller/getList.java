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


@WebServlet("/getList")
public class getList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getList() {
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
		System.out.println("getList에 옴");
		Board bd = new Board();
		String ID = request.getParameter("uID");
		String Name = request.getParameter("uName");
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		boardlist = bd.BoardList(boardlist);
//		
//		uID=${ID}&uName=${Name}
		
		if(boardlist != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardList.jsp");
			request.setAttribute("ID", ID);
			request.setAttribute("Name", Name);
			request.setAttribute("board", boardlist);
			dispatcher.forward(request, response);
		}
    }

}
