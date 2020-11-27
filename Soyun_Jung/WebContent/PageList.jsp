<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
table, tr, td, th {
margin:auto;
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td, th {
	padding: 5px;
}
a button:hover{
font-size: 15px;
font-weight: bold;
color : white;
}
#aa:visited{
color: black;
}
a:visited{
color: blue;
}
a:hover{
font-weight: bold;
}
#aa:hover{
color: black;
font-size: 17px;
font-weight: bold;
}
</style>
</head>
<body>
<div style="text-align: center;">
	<h1>페이징처리 게시판</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bNum}</td>
				<td><a href="boardView?bNum=${board.bNum}&page=${paging.page}" style="text-decoration: none;">${board.bTitle}</a></td>
				<td>${board.bWriter}</td>
				<td>${board.bDate}</td>
				<td><a href="boardDel?bNum=${board.bNum}" style="text-decoration: none;">삭제</a></td>
			</tr>
		</c:forEach>

	</table>
	<br/>
	<!-- 페이징 처리 -->

	<!-- 현재 페이지 1페이지 이거나 1페이지보다 작은 경우 -->
	<c:if test="${paging.page<=1}"><button>이전</button></c:if>

	<!-- 현재 페이지가 1페이지 보다 클 경우 -->
	<c:if test="${paging.page>1}">
		<a href="pagingList?page=${paging.page-1}"><button>이전</button></a>&nbsp;
	</c:if>

	<!-- 현재 페이지 표시 -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
		step="1">
		<c:choose>
			
			<c:when test="${i eq paging.page}">
				<strong style="font-size: 18px; color: blue;">${i}</strong> 
			</c:when>

			
			<c:otherwise>
				<a href="pagingList?page=${i}" style="text-decoration: none;" id="aa">${i}</a>

			</c:otherwise>

		</c:choose>

	</c:forEach>
	
	<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
		<c:if test="${paging.page >= paging.maxPage}">&nbsp; <button>다음</button> </c:if>

		<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
		<c:if test="${paging.page < paging.maxPage}">
			&nbsp;<a href="pagingList?page=${paging.page+1}" id="a"><button>다음</button></a>
		</c:if>


	<br/><br/>
	<button onclick="location.href='BoardWrite.jsp'">글쓰러 가기</button>
</div>
</body>
</html>