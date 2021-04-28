<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="http://localhost:8090/ShoppingMall/">
<center>
<img src="https://i.pinimg.com/236x/7e/64/6b/7e646bd7120da69b67240999098e2984.jpg"> <!-- 홈페이지 로고 -->
</center>
</a>

<a href="<c:url value='/123'/>">디테일페이지 </a> <!-- 미구현 -->

<a href="<c:url value='/productDetail'/>">디테일페이지2? </a>
	<center>
	<table border="0">
	<tr>
	<!-- product 테이블 P_KIND에서 TOP분류중 긴팔/반팔/아우터 분류를 위해 TOP_LONG 식으로 설정함. -->
	<td width="200"><input type="Button" style="WIDTH:150pt" value="TOP 전체보기" onclick="location.href='<c:url value='/product/viewCategory/TOP'/>'"></td>
	<td width="200"><input type="Button" style="WIDTH:150pt" value="긴팔" onclick="location.href='<c:url value='/product/viewCategory/TOP_LONG'/>'"></td>
	<td width="200"><input type="Button" style="WIDTH:150pt" value="반팔" onclick="location.href='<c:url value='/product/viewCategory/TOP_SHORT'/>'"></td>
	<td width="200"><input type="Button" style="WIDTH:150pt" value="아우터" onclick="location.href='<c:url value='/product/viewCategory/TOP_OUTER'/>'"></td>
	</tr>
	</center>
	</table>
</body>
</html>
