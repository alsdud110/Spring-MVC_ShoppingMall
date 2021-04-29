<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>구매하기 버튼 크릭시 이동</h2>
<%String size=request.getParameter("size"); 
String color=request.getParameter("color"); 
String price=request.getParameter("price");
String qty=request.getParameter("qty");
String name=request.getParameter("name");
String image=request.getParameter("image");
%>

<%=size %> 사이즈
<%=color %> 컬러
<%=price %> 토탈가격
<%=qty %> 수량
<%=name %> 상품명
<%=image %> 상품 이미지
</body>
</html>