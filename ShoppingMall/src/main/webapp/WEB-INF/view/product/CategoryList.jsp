<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="../header.jsp"></jsp:include>

<html>
<head>
<link rel="stylesheet"
	href="<c:url value = "/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/owl.carousel.min.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/flaticon.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/slicknav.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/animate.min.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/magnific-popup.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/fontawesome-all.min.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/themify-icons.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/slick.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/nice-select.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/style.css"/>">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/imgArray.css"/>">
<meta charset="utf-8">
<meta name = "viewport" content = "width=device-width, initial-scale = 1.0">
<title>상품보기</title>
</head>
<body>
<a href= "<c:url value = "/main"/>">
<center>
<img src="https://i.pinimg.com/236x/7e/64/6b/7e646bd7120da69b67240999098e2984.jpg"> <!-- 홈페이지 로고 -->
</center>
</a>

<center>
<table border="0">
	<tr>

	<!-- product 테이블 P_KIND에서 TOP분류중 긴팔/반팔/아우터 분류를 위해 TOP_LONG 식으로 설정함. -->
	<c:forEach var="list" items="${list}">
	<td width="200"><input type="Button" class="genric-btn primary-border circle" style="WIDTH:150pt" value="${list.p_KIND }" onclick="location.href='<c:url value='/product/viewCategory/${list.p_KIND }'/>'"></td>
	</c:forEach>

	</tr>
	</table>
</center>

<br>
</br>

	<div class="imgCollage">
		<c:forEach var="kind" items="${kind }">
			<div style="padding-left: 9%; padding-top : 50px; text-align: center; width : 30%" >
				<div>
					<dl class="item-list">
						<dd class="thumb" style="height: 400px;">
							<a href="<c:url value='/productDetail/${kind.p_CODE}'/>"><img
								src="<c:url value='${kind.p_IMAGE}'/>" style="width: 350px; height: 400px;"></a>
						</dd>
						<dd>
							<ul>
								<li class="prd-name">${kind.p_NAME}</li>

								<li class="org_price"><font
									style="font-weight: bold; color: #ff0000;">${kind.p_PRICE}</font></li>
								<li><span class='MK-product-icons'></span></li>
							</ul>
						</dd>
					</dl>
				</div>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
