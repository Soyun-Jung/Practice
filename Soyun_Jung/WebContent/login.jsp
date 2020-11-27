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
					href="#about">ABOUT</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#login">LogIn</a></li>
			</ul>
		</div>
	</nav>
	<!-- Page Content-->
	<div class="container-fluid p-0">

		<!-- About-->
		<section class="resume-section" id="about">
			<div class="resume-section-content">
				<h1 class="mb-0">
					Soyun <span class="text-primary">Jung</span>
				</h1>
				<div class="subheading mb-5">
					인천광역시 남동구 구월동 인하로 · 010-9495-9361 · <a
						href="mailto:jsy940221@naver.com">jsy940221@naver.com</a>
				</div>
				<p class="lead mb-5">
					소윤이의 홈페이지입니다.<br>로그인 후 이용 가능합니다!
				</p>
				<p class="lead mb-5"></p>
				<div class="social-icons">
					<a class="social-icon" href="#"><i class="fab fa-linkedin-in"></i></a>
					<a class="social-icon" href="#"><i class="fab fa-github"></i></a> <a
						class="social-icon" href="#"><i class="fab fa-twitter"></i></a> <a
						class="social-icon" href="#"><i class="fab fa-facebook-f"></i></a>
				</div>
			</div>
		</section>
		<hr class="m-0" />

		<!-- 로그인 -->
		<form action="CheckMember" method="post" name="login">
			<section class="resume-section" id="login">
				<div class="resume-section-content">
					<h2 class="mb-5">Log In</h2>
					<div
						class="d-flex flex-column flex-md-row justify-content-between mb-5">
						<div class="flex-grow-1">
							<h3 class="mb-0">USER ID</h3>
							<div class="subheading mb-3">
								<input type="text" name="sID">
							</div>
						</div>

						<div class="flex-grow-1">
							<h3 class="mb-0">PASSWORD</h3>
							<div class="subheading mb-3">
								<input type="password" name="sPW">
							</div>
						</div>
				
					</div>
					<button onclick="login()">로그인</button>
				<input type="button" onclick="join()" value="회원가입">
				</div>

			</section>

		</form>
		<div class="subheading mb-3"></div>
	</div>
</body>
<script>
	function login() {
		login.submit();
	}
	
	function join() {
		location.href="joinForm.jsp";
		
	}
</script>
</html>