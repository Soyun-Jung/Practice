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

h5 {
	text-align: right;
}

table, tr, td, th {
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
}

h1 {
	text-align: center;
}

td, th {
	padding: 5px;
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
					<span class="text-primary">게시판 수정하기</span><br> <br>

				</h1>
				<div class="subheading mb-5">
					<form action="modiProcess" name="boardModiForm">
						<table>
							<tr>
								<th>글번호</th>
								<td>${bNum}</td>
								<input type="hidden" value="${bNum}" name="bNum">
							</tr>
							<tr>
								<th>제목</th>
								<td><input type="text" name="bTitle" size="40"></td>

							</tr>
							<tr>
								<th>이름</th>
								<td>${Writer}</td>
								<input type="hidden" value="${bWriter}" name="bWriter">
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="bPassword" size="40"></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea rows="20" cols="40" name="bContent"></textarea></td>
							</tr>

							<tr style="text-align: center;">
								<td colspan="2"><button onclick="bmodify()?bNum=${bNum}&bName=${Name}&uID=${ID}">수정</button> <input
									type="button" onclick="location.href='getList?uID=${ID}&uName=${Name}'" value="목록보기">
							</tr>
						</table>
					</form>
				</div>
			</div>
		</section>
	</div>

</body>
<script>
	function bmodify() {
		boardModiForm.submit();
	}
</script>
</html>











