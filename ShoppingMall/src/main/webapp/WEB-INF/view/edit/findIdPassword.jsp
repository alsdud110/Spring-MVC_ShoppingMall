<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">
.mybtn{
  width:150px;
  height:40px;
  padding:0;
  display:inline; 
  border-radius: 4px; 
  background: #212529;
  color: #fff;
  margin-top: 20px;
  border: solid 2px #212529; 
  transition: all 0.5s ease-in-out 0s;
}
.mybtn:hover .mybtn:focus {
  background: white;
  color: #212529;
  text-decoration: none;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>아이디/비밀번호 찾기</h3>
			</div>
			<form class="w3-center" action = "findId" method = "post">
				<input type="submit" value = "아이디찾기" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn" >
			</form>
			<form class = "w3-center" action = "findPw" method = "post">
				<input type="submit" value = "비밀번호찾기" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">
			</form>
			<br><br><br><br><br><br><br><br><br>
			<div class = "w3-center w3-large">
					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">이전으로</button>
			</div>
		</div>
	</div>	
</body>
</html>