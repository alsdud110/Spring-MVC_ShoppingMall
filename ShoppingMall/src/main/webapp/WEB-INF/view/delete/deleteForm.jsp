<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>">
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

.text{
	background-color : white;
	width : 85%;
}
</style>
<script>
	function deletePw(deletePwForm){
		if(!deletePwForm.m_pw.value){
			alert("비밀번호를 입력하십시오.");
			deletePwForm.m_pw.focus();
			return false;
		}
		
		deletePwForm.action = "deleteSuccess";
		deletePwForm.submit();
	}
</script>
<title>회원탈퇴</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4 w3-auto" style="width: 382px;height: 300.3px;">
			<div class="w3-center w3-large w3-margin-top">
				<h3>비밀번호를 입력하세요</h3>
			</div>
			<form:form action = "deleteSuccess" method = "post" name = "deletePwForm">
			<div class = "w3-center w3-large w3-margin-top">
				<input type = "password" id = "m_pw" name = "m_pw" placeholder = "비밀번호를 입력하세요." class = "w3-input w3-center">				
			</div>
			<br><br>
			<div class = "w3-center w3-large">
					<input type = "button" value = "회원탈퇴" onclick = "deletePw(this.form)" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">					
					<button type = "button" onclick = "location.href = '<c:url value = '/main'/>'" class="w3-button w3-hover-white w3-ripple w3-margin-top w3-round mybtn">메인으로</button>
			</div>
			</form:form>
		</div>
	</div>	
</body>
</html>