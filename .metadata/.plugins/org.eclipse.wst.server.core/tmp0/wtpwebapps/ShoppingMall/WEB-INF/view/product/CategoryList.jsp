<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="testfolder/CategoryMenu.jsp" flush="false" />
<html>
<head>
<head>
		<link rel="stylesheet" href="<c:url value = "/resources/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/flaticon.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/slicknav.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/animate.min.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/magnific-popup.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/fontawesome-all.min.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/themify-icons.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/slick.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/nice-select.css"/>">
        <link rel="stylesheet" href="<c:url value = "/resources/css/style.css"/>">
    <title><spring:message code="login.title" /></title>
    
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
</body>
			<td>상품 코드</td>
			<br>
			<br>
			<td>상품 이름</td>
			<br>
			<br>
			<td>상품 종류</td>
			<br>
			<br>
			<td>상품 이미지</td>
			<br>
			<br>
			<td>상품 가격</td>
		</tr>

		<c:forEach var="list" items="${kind}">
			<tr>
				<td>${list.p_CODE}</td>
				<td>${list.p_NAME}</td>
				<td>${list.p_KIND}</td>
				<td><a href="<c:url value='/productDetail/${list.p_CODE}'/>"><img
						src="${list.p_IMAGE}"></a></td>
				<td>${list.p_PRICE}</td>
			</tr>
		</c:forEach>

	</table>
	
</body>
</html>