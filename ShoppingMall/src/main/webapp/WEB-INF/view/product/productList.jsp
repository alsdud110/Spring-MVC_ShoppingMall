<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>전체 상품 리스트</title>
</head>
<body>
    <table>
		<tr>
			<td>상품 이미지1</td><td>상품 이미지2</td><td>상품 이미지3</td>
		</tr>	
		<tr>
			<td>상품 이이름</td><td>상품 이미지2</td><td>상품 이미지3</td>
		</tr>	
		<tr>
			<td>상품 가격</td><td>상품 이미지2</td><td>상품 이미지3</td>
		</tr>
		<c:forEach var="list" items="${list}">
        <tr>
      		<td>${list.p_CODE}</td>
        	<td>${list.p_IMAGE}</td>
        	
            <td>${list.p_NAME}</td>
			<td>${list.p_KIND}</td>
			
			<td>${list.p_PRICE}</td>
        </tr>
        </c:forEach>
	
	</table>
</body>
</html>

<!-- <td><a href="<c:url value="/members/${mem.id}"/>">
<<<<<<< HEAD
                ${mem.email}</a></td> -->
=======
                ${mem.email}</a></td> -->
>>>>>>> 92755a5a4faddeaf8c45c3e25885439a4f2c62bb
