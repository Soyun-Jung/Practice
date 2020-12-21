<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.result1{
	color: blue;
}
</style>
</head>
<body>
	<form action="Join" method="POST">
		<table>

			<tr>
				<td>아이디</td>
				<!-- <td><input type="text" id="userId" name="userId"></td> -->
				<td><input type="text" id="userId" name="userId" value="${userId}"></td>
				<td><input type="button" onclick="idCheck()" value="중복체크"></td>
			</tr>
			<tr>
				<td colspan="3" class="result1">사용가능한 아이디 입니다!</td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td colspan="2"><input type="password" id="userPw"
					name="userPw"></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="회원가입"></td>
			</tr>

		</table>
	</form>
</body>
<script>
	function idCheck(){
		alert('이미 중복체크를 했습니다.');
		/* var userId = document.getElementById("userId").value;
		location.href="idCheck?userId=" + userId; */
		/* (1)idCheck의 주소를 가진 Servlet으로 이동(GET방식) */
		/* (2)userId값(input에서 입력해준 값)을 가지고 이동 */
	}
</script>
</html>














