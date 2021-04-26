<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="https://drive.google.com/uc?id=173P8AUPIxf9KSYWyoZ1iSLVL73pU4pk8"> <!-- 홈페이지 로고 -->
<a href="<c:url value='/123'/>">디테일페이지 </a> <!-- 미구현 -->
	<table border="1">
	<tr>

	<!-- product 테이블 P_KIND에서 TOP분류중 긴팔/반팔/아우터 분류를 위해 TOP_LONG 식으로 설정함. -->
	<td width="200"><input type="Button" style="WIDTH:300pt" value="TOP 전체보기" onclick="location.href='<c:url value='/product/viewCategory/TOP'/>'"></td>
	<td width="200"><input type="Button" style="WIDTH:300pt" value="긴팔" onclick="location.href='<c:url value='/product/viewCategory/TOP_LONG'/>'"></td>
	<td width="200"><input type="Button" style="WIDTH:300pt" value="반팔" onclick="location.href='<c:url value='/product/viewCategory/TOP_SHORT'/>'"></td>
	<td width="200"><input type="Button" style="WIDTH:300pt" value="아우터" onclick="location.href='<c:url value='/product/viewCategory/TOP_OUTER'/>'"></td>
	<td><a href="<c:url value='/productDetail'/>">디테일페이지 </a></td>
	</tr>
	</table>
</body>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 92755a5a4faddeaf8c45c3e25885439a4f2c62bb
