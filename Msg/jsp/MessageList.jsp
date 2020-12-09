<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>내 쪽지함</caption>
		<thead>
			<tr>
				<th>보낸 사람</th>
				<th>날짜</th>
				<th>글내용</th>
			</tr>
		</thead>
				<tbody>
			<c:forEach items="${requestScope.msglist}" var="list">
				<tr>
					<td>${list.getMs_mbid()}</td>
					<td>${list.getMs_date()}</td>
					<td>${list.getMs_text()}</td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
</body>
</html>