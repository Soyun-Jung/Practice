<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
a {
	text-decoration: none;
}

li {
	font-size: 30px;
}
</style>
</head>

<body>
	<h1>
		<a href="#">Ajax Practice</a>
	</h1>
	<nav id='list'>
<!-- 		<ol>
			<a href="#!Java" onclick="getInfo('Java')"><li>JAVA</li></a>
			<a href="#!C++" onclick="getInfo('C++')"><li>C++</li></a>
			<a href="#!Python" onclick="getInfo('Python')"><li>Python</li></a>
			<a href="#!Go" onclick="getInfo('Go')"><li>GO</li></a>
		</ol> -->
	</nav>

	<div id="here"></div>

	<div id="end">감사합니다!</div>

</body>

<script>	
		fetch("List.jsp").then((response)=>{
			response.text().then((text)=>{
				let langlist = text.split(",");
				console.log(langlist);	
				
				let arr = "";
				
				for(let i of langlist) {
					
					console.log(i);
					
					arr += '<a href=\"#!'+ i +'\" onclick="getInfo(\''+i+'\')"><li>'+i+'</li></a>';
				}
				document.querySelector('#list').innerHTML=arr;
			})
		});
	
	
	function getInfo(language){
		let lang = language+".jsp";
		fetch(lang).then((response)=>{
			//console.log(response);
			response.text().then((text)=>{
				//console.log(text);
				document.querySelector('#here').innerHTML=text;
			});
		})
	}
	
	if(location.hash){
		getInfo(location.hash.substr(2));
	}
	else{
		getInfo('index');
	}
	
	
</script>
</html>