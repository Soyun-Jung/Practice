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
import dto.pageDTO;
import service.Board;
import service.PageService;

@WebServlet("/pagingList")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PageController() {
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
		
		String ID = request.getParameter("ID");
		String Name = request.getParameter("Name");
		
		// 한페이지 게시글 몇개 표시할지 정하기
		int page = 1;	// 처음 시작 페이지
		int limit = 5; 	// 한페이지에 표시되는 게시글의 수
		
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		// PageService만들기
				PageService pagesvc = new PageService();
		
				// DB에서 게시글의 갯수 가져오기
				int listCount = pagesvc.ListCount();
		
		//1페이지 : page = 1 / startRow = 1 / endRow = 5
		//2페이지 : page = 2 / startRow = 6 / endRow = 10
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		ArrayList<BoardDTO> boardList2 = new ArrayList<BoardDTO>();
		boardList2 = pagesvc.BoardList(startRow, endRow);
		
		
		// 글 갯수가 정해준 limit 갯수를 넘을때마다 페이지가 1개씩 자동으로 생기게 해주는 기능
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		// int로 변환하면 소숫점은 다 없애버림.
		// 나누기로 한 화면에 보여줄 페이지 갯수를 정해줌.  ->page/10  -> 1 2 3 4 5 6 7 8 9 10
		int startPage = (((int)((double)page/10 + 0.9))-1) * 10 +1;
		
		// 현재페이지에 보여줄 끝페이지
		int endPage = startPage + 10 -1;
		
		// endPage가 maxPage보다 클경우 
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		pageDTO paging = new pageDTO();
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);
		
		request.setAttribute("paging",paging);
		request.setAttribute("boardList",boardList2);
		request.setAttribute("Name", Name);
		request.setAttribute("ID", ID);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardPagingList.jsp");
		System.out.println("boardPagingList에 줌");
		dispatcher.forward(request, response);
	}
}













