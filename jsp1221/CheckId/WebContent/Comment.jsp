<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<style>
	table{
		width:500px;
	}
	table, tr, th, td{
		border : 1px solid black;
		border-collapse : collapse;
	}
</style>

</head>
<body>
	<table>
		<tr>
			<th>작성자</th>
			<td>inchoriya</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>Ajax로 댓글달기</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>댓글을 달아봅시다!</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>2020.12.21</td>
		</tr>
		
		<tr>
			<th>댓글</th>
			<td><textarea rows="2" cols="40" id="cContent" name="cContent"></textarea>
				<button onclick="commentWrite()">댓글작성</button></td>
		</tr>		
	</table>
	<br>
	<div id="commentArea"></div>

</body>

<script>
	$(document).ready(function(){
		$.ajax({
			type : "GET",
			url : "cList",
			dataType : "json",
			success : function(cmtlist){
				commentList(cmtlist);
			},
			error : function() {
				alert('통신 실패');
			}
		});	
	});
	
	function commentList(cmtlist){
		var output="";
		output += "<table>";
		output += "<tr>";
		output += "<th>작성자</th>";
		output += "<th>댓글내용</th>";
		output += "<th>작성일</th>";
		output += "</tr>";
		
		console.log("length : " + cmtlist.length);
		
		for(var i in cmtlist){
			output+="<tr>";
			output+="<td>" + cmtlist[i].cWriter + "</td>";
			output+="<td>" + cmtlist[i].cContent + "</td>";
			output+="<td>" + cmtlist[i].cDate + "</td>";
			output+="</tr>";
		}
		
		output += "</table>"
		$("#commentArea").html(output);
	}
	
	function commentWrite(){
		var cWriter = "icia1";
		var cContent = document.getElementById("cContent").value;
		
		$.ajax({
			type : "GET",
			url : "commentWrite",
			data : {
				"cWriter" : cWriter,
				"cContent" : cContent
			},
			dataType : "json",
			
			success : function(cmtlist){
				commentList(cmtlist);
				$("#cContent").val("");
			} ,
			error : function(){
				alert('통신 실패');
			} 
			
		});
		
	}
	
	
</script>
</html>











