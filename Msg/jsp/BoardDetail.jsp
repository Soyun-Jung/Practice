<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	text-align: center;
}

caption {
	font-weight: bold;
	font-size: 30px;
	margin-bottom: 15px;
}

table, tr, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table {
	margin: auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>글제목</th>
			<td colspan="9">${requestScope.view.getBD_TITLE()}</td>
		</tr>
		<tr>
			<th>글번호</th>
			<td>${requestScope.view.getBD_NUM()}</td>
			<th>지역</th>
			<td>${requestScope.view.getMB_LOC()}</td>
			<th>작성일</th>
			<td>${requestScope.view.getBD_DATE()}</td>
			<th>조회수</th>
			<td>${requestScope.view.getBD_HIT()}</td>
			<th>판매상태</th>
			<td><c:choose>
					<c:when test="${requestScope.view.getBD_STATE() eq 'AO'}">
						판매 중
					</c:when>
					<c:when test="${requestScope.view.getBD_STATE() eq 'AX'}">
						판매 완료
					</c:when>
					<c:when test="${requestScope.view.getBD_STATE() eq 'HO'}">
						나눔 중
					</c:when>
					<c:when test="${requestScope.view.getBD_STATE() eq 'HX'}">
						나눔 완료
					</c:when>
				</c:choose></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="9">${requestScope.view.getMB_ID()}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="9"><c:if
					test="${!empty requestScope.view.getBD_FILE()}">
					<img src="FileUpload/${requestScope.view.getBD_FILE()}"
						width="200px">
				</c:if>
				<div style="white-space: pre;">${requestScope.view.getBD_CONTENT()}</div>
			</td>
		</tr>
		<tr style="text-align: right;">
			<td colspan="10"><c:if
					test="${sessionScope.memberInfo.getMb_id() ne requestScope.view.getMB_ID()}">
					<form action="BoardReportController" method="POST"
						style="display: inline;">
						<input type="hidden" name="BR_BDNUM"
							value="${requestScope.view.getBD_NUM()}"> <input
							type="hidden" name="BR_BDMBID"
							value="${requestScope.view.getMB_ID()}"> <input
							type="hidden" name="BR_MBID"
							value="${sessionScope.memberInfo.getMb_id()}"> <input
							type="submit" value="신고">
					</form>
				</c:if> <a href="BoardGetModController"><button>글 쓰기</button></a> <c:choose>
					<c:when
						test="${sessionScope.memberInfo.getMb_id() eq requestScope.view.getMB_ID()}">
						<form action="BoardGetModController" method="POST"
							style="display: inline;">
							<input type="hidden" name="BD_NUM"
								value="${requestScope.view.getBD_NUM()}"> <input
								type="hidden" name="BD_TITLE"
								value="${requestScope.view.getBD_TITLE()}"> <input
								type="hidden" name="BD_MBID"
								value="${requestScope.view.getMB_ID()}"> <input
								type="hidden" name="BD_CONTENT"
								value="${requestScope.view.getBD_CONTENT()}"> <input
								type="hidden" name="BD_STATE"
								value="${requestScope.view.getBD_STATE()}"> <input
								type="hidden" name="BD_FILE"
								value="${requestScope.view.getBD_FILE()}"> <input
								type="submit" value="수정하기">
						</form>
						<form action="BD_Delete" method="POST" style="display: inline;">
							<input type="hidden" name="bd_num"
								value="${requestScope.view.getBD_NUM()}"> <input
								type="submit" value="삭제">
						</form>
					</c:when>
					<c:when test="${sessionScope.memberInfo.getMb_level() eq 'M'}">
						<form action="BD_Delete" method="POST" style="display: inline;">
							<input type="hidden" name="bd_num"
								value="${requestScope.view.getBD_NUM()}"> <input
								type="submit" value="삭제">
						</form>
					</c:when>
				</c:choose></td>
		</tr>
	</table>
	<a href="bList"><button>목록보기</button></a>
	<a href="Main.jsp"><button>메인페이지</button></a>
<%-- <a href="sendmsginfo?bdnum='${requestScope.view.getBD_NUM()}'&bdid='${requestScope.view.getMB_ID()}'&mbid='${sessionScope.memberInfo.getMb_id()}'">
	<button>쪽지보내기</button>
	</a> --%>
	
	<a href="sendmsginfo?bdnum=${requestScope.view.getBD_NUM()}&bdid=${requestScope.view.getMB_ID()}&mbid=${sessionScope.memberInfo.getMb_id()}">쪽지</a>
	
	<!-- <button onclick="sendmsg()">쪽지보내기</button> -->
	
	<table>
		<thead>
			<tr>
				<td colspan="4">
					<form action="CommentWrite" method="post">
						<input type="text" name="cmtext"> <input type="hidden"
							name="bNum" value="${requestScope.view.getBD_NUM()}"> <input
							type="hidden" name="mbid"
							value="${sessionScope.memberInfo.getMb_id()}"> <input
							type="submit" value="작성">
					</form>
				</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty requestScope.comment}">
				<tr>
					<td>작성자</td>
					<td>내용</td>
					<td>작성일</td>
					<td>삭제</td>
				</tr>
				<c:forEach items="${requestScope.comment}" var="comment">
					<tr>
						<td><c:if test="${comment.getCm_state() eq 1}">
							${comment.getCm_mbid()}
							</c:if></td>
						<td><c:choose>
								<c:when test="${comment.getCm_state() eq 1}">
								${comment.getCm_content()}
								</c:when>
								<c:otherwise>
								삭제된 댓글
								</c:otherwise>
							</c:choose></td>
						<td><c:if test="${comment.getCm_state() eq 1}">
							${comment.getCm_date()}
							</c:if></td>
						<td><c:if
								test="${comment.getCm_state() eq 1 and comment.getCm_mbid() eq sessionScope.memberInfo.getMb_id()}">
								<form action="CmDelete">
									<input type="hidden" name="bNum"
										value="${requestScope.view.getBd_num()}"> <input
										type="hidden" name="mbid" value="${comment.getCm_mbid()}">
									<input type="hidden" name="date"
										value="${comment.getCm_date()}"> <input type="submit"
										value="삭제">
								</form>
							</c:if></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
<script>
    function sendmsg() {
        
    	location.href="sendmsginfo?Bdnum="+${requestScope.view.getBD_NUM()}+"&Reciever="+${requestScope.view.getMB_ID()};

  
    }
</script>
</html>