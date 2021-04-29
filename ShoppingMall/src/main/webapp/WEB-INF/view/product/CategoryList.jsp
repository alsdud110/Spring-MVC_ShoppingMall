<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="../header.jsp"></jsp:include>
<<<<<<< HEAD
<jsp:include page="testfolder/CategoryMenu.jsp"></jsp:include>

=======
>>>>>>> Ìô©ÎØºÏòÅ
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
<<<<<<< HEAD
<meta name="viewport" content="width=device-width, initial-scale=1.0">

=======
<meta name = "viewport" content = "width=device-width, initial-scale = 1.0">
>>>>>>> Ìô©ÎØºÏòÅ
<title>ªÛ«∞∫∏±‚</title>
</head>
<body>
<center>
<table border="0">
	<tr>
	<!-- product ≈◊¿Ã∫Ì P_KINDø°º≠ TOP∫–∑˘¡ﬂ ±‰∆»/π›∆»/æ∆øÏ≈Õ ∫–∑˘∏¶ ¿ß«ÿ TOP_LONG Ωƒ¿∏∑Œ º≥¡§«‘. -->
	<td width="200"><input type="Button" class = "btn-secondary" style="WIDTH:150pt" value="TOP ¿¸√º∫∏±‚" onclick="location.href='<c:url value='/product/viewCategory/TOP'/>'"></td>
	<td width="200"><input type="Button" class = "btn-secondary" style="WIDTH:150pt" value="±‰∆»" onclick="location.href='<c:url value='/product/viewCategory/TOP_LONG'/>'"></td>
	<td width="200"><input type="Button" class = "btn-secondary" style="WIDTH:150pt" value="π›∆»" onclick="location.href='<c:url value='/product/viewCategory/TOP_SHORT'/>'"></td>
	<td width="200"><input type="Button" class = "btn-secondary" style="WIDTH:150pt" value="æ∆øÏ≈Õ" onclick="location.href='<c:url value='/product/viewCategory/TOP_OUTER'/>'"></td>
	</tr>
	</table>
</center>
	<hr>
	<div class="imgCollage">
		<c:forEach var="list" items="${kind }">
			<div style="padding-left: 9%; padding-top : 50px; text-align: center; width : 30%" >
				<div>
					<dl class="item-list">
						<dd class="thumb" style="height: 400px;">
							<a href="<c:url value='/productDetail/${list.p_CODE}'/>"><img
								src="${list.p_IMAGE}" style="width: 350px; height: 400px;"></a>
						</dd>
						<dd>
							<ul>
								<li class="prd-name">${list.p_NAME}</li>

<<<<<<< HEAD
	<hr>
	<div class="imgCollage">
		<c:forEach var="list" items="${kind }">
			<div style="padding-left: 180px; text-align: center; width : 30%">
				<div>
					<dl class="item-list">
						<dd class="thumb" style="height: 400px;">
							<a href="<c:url value='/productDetail/${list.p_CODE}'/>"><img
								src="${list.p_IMAGE}" style="width: 350px; height: 400px;"></a>
						</dd>
						<dd>
							<ul>
								<li class="prd-name">${list.p_NAME}</li>

=======
>>>>>>> Ìô©ÎØºÏòÅ
								<li class="org_price"><font
									style="font-weight: bold; color: #ff0000;">${list.p_PRICE}</font></li>
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