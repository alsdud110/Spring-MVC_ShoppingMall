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
<style type="text/css">
.mybtn{
  width:110px;
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
<script>
function changePw(changePwForm){
	if(!changePwForm.m_pw.value){
		alert('새 비밀번호를 입력하십시요.');
		changePwForm.m_pw.focus();
		return false;
	}
	
	if(!changePwForm.m_pw_new.value){
		alert('새 비밀번호 확인을 입력하십시오.');
		changePwForm.m_pw_new.focus();
		return false;
	}
	changePwForm.action = "findPwSuccess";
	changePwForm.submit();
}
</script>
<title>비밀번호 찾기</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호 변경</h3>
			</div>
			<div>
			<form:form modelAttribute = "findPw" action = "findPwSuccess" method = "post" name = "changePwForm">
				<p>
					<label>새 비밀번호</label>
					<input type = "password" name = "m_pw" class = "w3-input" id = "m_pw" placeholder = "새 비밀번호를 입력하세요"/>
				</p>
				<p>
					<label>새 비밀번호 확인</label>
					<input type = "password" name = "m_pw_new" class = "w3-input" id = "m_pw_new" placeholder = "새 비밀번호를 입력하세요"/>
				</p>
				<br><br><br><br>
				<p class="w3-center">
					<input type="button" value = "변경하기" onclick = "changePw(this.form)" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">
					<button type="button" onclick = "location.href = '<c:url value = '/main'/>'" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">메인으로</button>
					<button type="button" onclick = "location.href = '<c:url value = '/login/loginForm'/>'" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">로그인으로</button>
				</p>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>