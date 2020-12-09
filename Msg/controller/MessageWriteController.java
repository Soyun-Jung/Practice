package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import dto.MessageDTO;
import service.BoardWriteService;
import service.MsgWriteService;

/**
 * Servlet implementation class MessageWriteController
 */
@WebServlet("/SendMsg")
public class MessageWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MessageDTO ms = new MessageDTO();
		MsgWriteService mws = new MsgWriteService();
		
		ms.setMs_bdmbid(request.getParameter("Reciever"));
		ms.setMs_mbid(request.getParameter("Sender"));
		ms.setMs_text(request.getParameter("message"));
		ms.setMs_bdnum(Integer.parseInt(request.getParameter("Bdnum")));
		
		if(mws.MsgWrite(ms)) { // BoardWrite.1
			RequestDispatcher dispatcher = request.getRequestDispatcher("MessageList.jsp");
			dispatcher.forward(request, response); // BoardWrite.8
		}else {
			response.sendRedirect("BoardWrite.jsp"); // BoardWrite.8
		}
	}
	
}
