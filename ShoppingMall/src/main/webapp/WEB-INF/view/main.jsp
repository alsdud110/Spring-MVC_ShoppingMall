<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
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
<title>메인</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="new-product-area section-padding30"
		style="padding: 50px">
		<div class="container">
			<!-- Section tittle -->
			<div class="row">
				<div class="col-xl-12">
					<div class="section-tittle mb-70">
						<h2>Best Items</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="top3" items="${top3}">
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
						<div class="single-new-pro mb-30 text-center">
							
							<div class="product-img">
							<c:choose>
							<c:when test="${empty top3.productstdvo}">
							<div style="position: relative;">
							<img src="<c:url value = '${top3.p_IMAGE }'/>" style="opacity: 0.3"/>
							<div
											style="left: 50%; top: 50%; font-size: 1.8em; font-weight: bold; position: absolute; transform: translate(-50%, -50%);">
											<span style="color: red;">품 절</span>
										</div>

									</div>
							</c:when>
							<c:otherwise>
								<a href="<c:url value='/productDetail/${top3.p_CODE}'/>"> <img
									src="<c:url value = '${top3.p_IMAGE }'/>" /></a>
							</c:otherwise>
							</c:choose>
							</div>
							
							<div class="product-caption">
								<h3>
									<a>${top3.p_NAME }</a>
								</h3>
								<span><fmt:formatNumber pattern="###,###,###" value="${top3.p_PRICE}" />원</span>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>

	<hr>
	<section class="new-product-area section-padding30"
		style="padding: 50px">
		<div class="container">
			<!-- Section tittle -->
			<div class="row">
				<div class="col-xl-12">
					<div class="section-tittle mb-70">
						<h2>New Arrival</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="newtop3" items="${newtop3 }">
					<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
						<div class="single-new-pro mb-30 text-center">
							<div class="product-img">
								<c:choose>
							<c:when test="${empty newtop3.productstdvo}">
							<div style="position: relative;">
							<img src="<c:url value = '${newtop3.p_IMAGE }'/>" style="opacity: 0.3"/>
							<div
											style="left: 50%; top: 50%; font-size: 1.8em; font-weight: bold; position: absolute; transform: translate(-50%, -50%);">
											<span style="color: red;">품 절</span>
										</div>

									</div>
							</c:when>
							<c:otherwise>
								<a href="<c:url value='/productDetail/${newtop3.p_CODE}'/>"> <img
									src="<c:url value = '${newtop3.p_IMAGE }'/>" /></a>
							</c:otherwise>
							</c:choose>
							</div>
							<div class="product-caption">
								<h3>
									<a>${newtop3.p_NAME }</a>
								</h3>
								<span><fmt:formatNumber pattern="###,###,###" value="${newtop3.p_PRICE}" />원</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>


	<jsp:include page="footer.jsp"></jsp:include>

	<!-- JS here -->
	<!-- All JS Custom Plugins Link Here here -->
	<script
		src="<c:url value = "/resources/js/vendor/modernizr-3.5.0.min.js"/>"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script
		src="<c:url value = "/resources/js/vendor/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"></script>
	<!-- Jquery Mobile Menu -->
	<script src="<c:url value = "/resources/js/jquery.slicknav.min.js"/>"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="<c:url value = "/resources/js/owl.carousel.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/slick.min.js"/>"></script>

	<!-- One Page, Animated-HeadLin -->
	<script src="<c:url value = "/resources/js/wow.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/animated.headline.js"/>"></script>

	<!-- Scroll up, nice-select, sticky -->
	<script src="<c:url value = "/resources/js/jquery.scrollUp.min.js"/>"></script>
	<script
		src="<c:url value = "/resources/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.sticky.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.magnific-popup.js"/>"></script>

	<!-- contact js -->
	<script src="<c:url value = "/resources/js/contact.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.form.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.validate.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/mail-script.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.ajaxchimp.min.js"/>"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="<c:url value = "/resources/js/plugins.js"/>"></script>
	<script src="<c:url value = "/resources/js/main.js"/>"></script>
</body>
</html>
