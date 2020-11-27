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
<style>
table, tr, td, th {

}

tr, td, th {
	padding: 5px;
}

input {
	weight : 70%;
}

.
</style>
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
					href="login.jsp">MAIN</a></li>
				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="#join">JOIN</a></li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid p-0">
		<form action="JoinController" method="POST">
			<section class="resume-section" id="join">
				<div class="resume-section-content">
					<h2 class="mb-5">Join Us</h2>
					<div class="resume-section-content">
						<div
							class="d-flex flex-column flex-md-row justify-content-between mb-5">
							<div class="flex-grow-1">
								<div class="subheading mb-3">
									<table>
										<legend>회원가입</legend>
										<br>

										<tr>
											<td>아이디 :</td>
											<td>${ID}</td>
											<input type="hidden" value="${ID}" name="userId">
											<td style="color:blue">사용가능한 아이디입니다 </td>
										</tr>
										<tr>
											<td>비밀번호 :</td>
											<td><input type="password" name="userPw"
												placeholder="15자 이내로 입력"></td>
										</tr>
										<tr>
											<td>이 름 :</td>
											<td><input type="text" name="userName"></td>
										</tr>
										<tr>
											<td>생년월일 :</td>
											<td><input type="date" name="userBirth"></td>
										</tr>
										<tr>
											<td>성별 :</td>
											<td>여자 <input type="radio" name="userGender" value="여자">
												남자 <input type="radio" name="userGender" value="남자"></td>
										</tr>
										<tr>
											<td>이메일 :</td>
											<td><input type="email" name="userEmail"
												placeholder="@ 꼭 포함"></td>
										</tr>
									</table>
									<br>
								</div>
								<input type="submit" value="회원가입"> 
								<a href="login.jsp"><input type="button" value="이전으로"></a>
							</div>
						</div>
					</div>

					<br>
				</div>

			</section>


		</form>
	</div>
</body>
</html>