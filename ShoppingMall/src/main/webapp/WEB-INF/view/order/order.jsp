<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매 목록</title>
<jsp:include page="../header.jsp"></jsp:include>
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>

<script>
	$(document).ready(function() {
		// 리스트 페이지로 이동
		$("#delete").click(function() {
			//  alert("언제되냐");
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[name=user_CheckBox]:checked");

			// 체크된 체크박스 값을 가져온다
			checkbox.each(function(i) {

				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();

				// 체크된 row의 모든 값을 배열에 담는다.
				rowData.push(tr.text());

				// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
				var p_image = td.eq(1).text() + ", "
				var p_name = td.eq(2).text() + ", ";
				var p_size = td.eq(3).text() + ", ";
				var color = td.eq(4).text() + ", ";

				// 가져온 값을 배열에 담는다.
				tdArr.push(p_image);
				tdArr.push(p_name);
				tdArr.push(p_size);
				tdArr.push(color);
				CartVO[i].val(tdArr);
				//console.log("no : " + no);
				//console.log("userid : " + userid);
				//console.log("name : " + name);
				//console.log("email : " + email);
			});
			alert("체크된 ROW의 모든 데이터 =" + rowData + "행 값 " + tdArr);
			//	$("#ex3_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);	
			//	$("#ex3_Result2").html(tdArr);	
			$("#test").submit();
		});
	});
</script>
</head>
<body>
	<!-- ${cartlist} -->

	<div class="container text-center" style = "margin-top : 40px;">
		<div class="row">
			<div class="col-xl-12">
				<div class="section-tittle mb-70">
					<h2>Shopping Order</h2>
				</div>
			</div>
		</div>
	</div>

		<div class = "text-center">
			<span>Cart</span> 
			<span class="this" title="현재페이지"><b>Order</b></span>
			<span class="end">Order confirmed</span>
		</div>
	<form:form modelAttribute = "CartVO" id="test">
	<table border="1" width = "80%" class = "text-center" style = "margin-left : 160px;">
		<tr>
			<td>상품</td>
			<td>사이즈</td>
			<td>컬러</td>
			<td>가격</td>
			<td>수량</td>
			<td>total</td>
		</tr>

		<c:forEach var="list" items="${cartlist}">
			<tr>
				<td><c:url value = "${list.p_image}"/></td>
				<td>${list.p_size }</td>
				<td>${list.p_color }</td>
				<td><fmt:formatNumber pattern="###,###,###" value="${list.p_price}" />원</td>
				<td>${list.qty }</td>
				<td><fmt:formatNumber pattern="###,###,###" value="${list.sumMoney}" />원</td>
			</tr>
		</c:forEach>
		
		
	</table>
	<button id="delete"  value="테스트" formaction="<c:url value="/test"/>">테스트</button>
	</form:form>
 


	<!-- Footer -->
	<jsp:include page="../footer.jsp"></jsp:include>

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