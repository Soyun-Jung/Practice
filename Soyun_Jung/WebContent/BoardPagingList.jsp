<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Resume - Start Bootstrap Theme</title>
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/style.css" rel="stylesheet" />
<style>
table, tr, td, th {
	
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td, th {
	padding: 5px;
}

h5 {
	text-align: right;
}
</style>
</head>


<body id="page-top">

	<form action="logOut" method="post">
		<h5>${Name}님
			환영합니다! ID : ${ID} <br> <input type="submit" value="로그아웃">
		</h5>
	</form>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top"
		id="sideNav">

		<a class="navbar-brand js-scroll-trigger" href="#page-top"> <span
			class="d-block d-lg-none">Soyun Jung</span> <span
			class="d-none d-lg-block"><img
				class="img-fluid img-profile rounded-circle mx-auto mb-2"
				src="assets\img\Soyun.jpg" alt="" /></span>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href='main.jsp'>MAIN</a></li>
			</ul>
		</div>
	</nav>
	<!-- Page Content-->
	<div class="container-fluid p-0">

		<!-- About-->
		<section class="resume-section" id="join">
			<div class="resume-section-content">
				<h1 class="mb-0">
					<span class="text-primary">게시판</span><br> <br>

				</h1>
				<div class="subheading mb-5">
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
					<br />
					<!-- 페이징 처리 -->

					<!-- 현재 페이지 1페이지 이거나 1페이지보다 작은 경우 -->
					<c:if test="${paging.page<=1}">
						<button>이전</button>
					</c:if>

					<!-- 현재 페이지가 1페이지 보다 클 경우 -->
					<c:if test="${paging.page>1}">
						<a href="pagingList?page=${paging.page-1}"><button>이전</button></a>&nbsp;
					</c:if>

					<!-- 현재 페이지 표시 -->
					<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
						var="i" step="1">
						<c:choose>

							<c:when test="${i eq paging.page}">
								<strong style="font-size: 18px; color: blue;">${i}</strong>
							</c:when>


							<c:otherwise>
								<a href="pagingList?page=${i}" style="text-decoration: none;"
									id="aa">${i}</a>

							</c:otherwise>

						</c:choose>

					</c:forEach>

					<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
					<c:if test="${paging.page >= paging.maxPage}">&nbsp; <button>다음</button>
					</c:if>

					<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
					<c:if test="${paging.page < paging.maxPage}">
			&nbsp;<a href="pagingList?page=${paging.page+1}" id="a"><button>다음</button></a>
					</c:if>


					<br /> <br />
					<button onclick="location.href='BoardWrite.jsp'">글쓰러 가기</button>
				</div>
			</div>
		</section>
	</div>

</body>
<script>
	
</script>
</html>


