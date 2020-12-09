<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="SendMsg" method="post">
	받는 사람 : ${reciever} <br>
	<input type="hidden" name="Reciever" value=${reciever}>
	<input type="hidden" name="Bdnum" value=${bdnum}>
	보내는 사람 : ${sessionScope.memberInfo.getMb_id()} <br>
	<input type="hidden" name="Sender" value="${sessionScope.memberInfo.getMb_id()}">
	내용 : <textarea name="message" row="5" cols="30"></textarea> <br>
	<input type="submit" value="보내기">
</form>
</body>
</html>