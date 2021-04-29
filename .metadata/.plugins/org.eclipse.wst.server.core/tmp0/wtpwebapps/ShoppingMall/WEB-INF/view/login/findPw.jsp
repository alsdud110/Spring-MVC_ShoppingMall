<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>

/* 	$(function(){
		$("#findBtn").click(function(){
			$.ajax({
				url : "/findPw",
				type : "POST",
				data : {
					id : $("#m_id").val(),
					email : $("#m_email").val()
				},
				success : function(result) {
					alert(result);
				},
			})
		});
	})
 */</script>
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
<title>비밀번호 찾기</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호 찾기</h3>
			</div>
			<div>
			<form action = "findPw" method = "post">
				<p>
					<label>아이디</label>
					<input type = "text" name = "m_id" class = "w3-input" id = "m_id" placeholder = "회원가입한 아이디를 입력하세요"/>
				</p>
				<p>
					<label>이메일</label>
					<input type = "text" name = "m_email" class = "w3-input" id = "m_email" placeholder = "회원가입한 아이디를 입력하세요"/>
				</p>
				<p class="w3-center">
					<input type="submit" value = "찾기" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">
					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button>
				</p>
			</form>
			</div>
		</div>
	</div>
</body>
</html>