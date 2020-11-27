<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>

<body id="page-top">
	<!-- Navigation-->
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
					href="#join">HELLO</a></li>
			</ul>
		</div>
	</nav>
	<!-- Page Content-->
	<div class="container-fluid p-0">

		<!-- About-->
		<section class="resume-section" id="join">
			<div class="resume-section-content">
				<h1 class="mb-0">
					<span class="text-primary">${userName}</span>
				</h1>
				<h3>님 회원가입 축하드립니다!</h3>


				<div class="subheading mb-5">
					<table>
						<tr>
							<td>아이디 :</td>
							<td>
								<%= request.getAttribute("userId") %>
							</td>
						</tr>
						<tr>
							<td>성별 :</td>
							<td>
								<%= request.getAttribute("userGender") %>
							</td>
						</tr>
						<tr>
							<td>생년월일 :</td>
							<td>
								<%= request.getAttribute("userBirth") %>
							</td>
						</tr>
						<tr>
							<td>이메일 :</td>
							<td>
								<%= request.getAttribute("userEmail") %>
							</td>
						</tr>
					</table>
				</div>
				<p class="lead mb-5">
				<input type="button" onclick="location.href='login.jsp'" value="로그인하기">
				</p>
			</div>
		</section>
	</div>

</body>

</html>