<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  margin-top: 20px;
  border: solid 2px #212529; 
  transition: all 0.5s ease-in-out 0s;
}
.mybtn:hover .mybtn:focus {
  background: white;
  color: #212529;
  text-decoration: none;
}

.text{
	background-color : white;
	width : 85%;
}
</style>
<script>
function findId(findIdForm){
	
	if(!findIdForm.m_email.value){
	  alert("이메일을 입력하십시요.");
	  findIdForm.m_email.focus();
	  return false;
	}
	
	if(!findIdForm.m_name.value){
	  alert("이름을 입력하십시요.");
	  findIdForm.m_name.focus();
	  return false;
	}
	
	findIdForm.action = "findId";
	findIdForm.submit();
 };
 
 function findPw(findPwForm){
	 if(!findPwForm.m_id.value){
		alert('아이디를 입력하십시오.');
		findPwForm.m_id.focus();
		return false;
	 }
	 
	 if(!findPwForm.m_name.value){
		alert('이름을 입력하십시오.');
		findPwForm.m_name.focus();
		return false;
	 }
	 
	 if(!findPwForm.m_birth.value){
		alert('생년월일 8자리를 입력하십시오.');
		findPwForm.m_birth.focus();
		return false;
	 }
	 if(!findPwForm.m_email.value){
		alert('이메일을 입력하십시오.');
		findPwForm.m_email.focus();
		return false;
	 }
	 if(!findPwForm.m_contact.value){
		alert('연락처를(- 제외) 입력하십시오.');
		findPwForm.m_contact.focus();
		return false;
	 }
	 
	 findPwForm.action = "findPw";
	 findPwForm.submit();
 }
</script>
<title>아이디/비밀번호 찾기</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 300.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>아이디 찾기</h3>
			</div>
			<form:form modelAttribute = "findId" class="w3-center" action = "findId" method = "post" name = "findIdForm">
				<input type = "text"  id = "m_email" placeholder = "이메일을 입력하세요" name = "m_email" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text" />
				<input type = "text" id = "m_name" placeholder = "이름을 입력하세요" name = "m_name" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text" />
			<br><br>
			<div class = "w3-center w3-large">
					<input type="button" value = "아이디 찾기" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn" onclick = "findId(this.form)" style =" color : white;">
					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn" style =" color : white;">이전으로</button>
			</div>
			</form:form>
		</div>
	</div>	
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 456.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호 찾기</h3>
			</div>
			<form:form modelAttribute = "findPw" class="w3-center" action = "findPw" method = "post" name = "findPwForm">
				<input type="text" placeholder = "아이디를 입력하세요" name = "m_id" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text" >
				<input type="text" placeholder = "이름을 입력하세요" name = "m_name" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text" >
				<input type="text" placeholder = "생년월일(8자리)을 입력하세요" name = "m_birth" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text">
				<input type="text" placeholder = "이메일을 입력하세요" name = "m_email" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text">
				<input type="text" placeholder = "연락처(- 제외)를 입력하세요" name = "m_contact" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn text">
			<br><br>
			<div class = "w3-center w3-large">
					<input type="button" value = "비밀번호 찾기" onclick = "findPw(this.form)" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn" style =" color : white;">
					<button type="button" onclick="history.go(-1);" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn" style =" color : white;">이전으로</button>
			</div>
			</form:form>
		</div>
	</div>	
</body>
</html>