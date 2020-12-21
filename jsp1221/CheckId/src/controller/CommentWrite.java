package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import service.CommentService;


/**
 * Servlet implementation class CommentWrite
 */
@WebServlet("/commentWrite")
public class CommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentWrite() {
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
		
		JSONObject jComment = new JSONObject();
		jComment.put("cWriter", request.getParameter("cWriter"));
		jComment.put("cContent", request.getParameter("cContent"));
		
		CommentService cmtsvc = new CommentService();
		
		int insertResult = cmtsvc.cWrite(jComment);
		// 댓글작성 완료
		
		
		// 댓글목록 불러오기
		JSONArray cmtlist = cmtsvc.cList();
		PrintWriter out = response.getWriter();
		
		if(insertResult>0) {
			out.print(cmtlist);
			System.out.println("댓글작성 성공!");
		} else {
			System.out.println("댓글작성 실패!");
		}
		
		
	}

}
