
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <c:forEach var = "code" items = "${orderCode }" varStatus = "i">
	 	<a href = "<c:url value = '/order/orderHistory/${code.o_code}'/>" >${code.o_code}</a>
	 </c:forEach>
	
	<!-- 
	 <div id = "aaa">
	 	<c:forEach var = "list" items = "${order_List}" varStatus = "i">
	 		<span id = "aaa">${list.p_color }</span>
	 		<span id = "aaa" >${list.p_size }</span>
	 		<span id = "aaa">${list.qty }</span>
	 		<span id = "aaa">${list.p_name }</span>
	 		<span id = "aaa"><img src = "<c:url value = '${list.p_image}'/>"></span>
	 	</c:forEach>
	 </div>
	  -->
	 
	 <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	  <script>
	  /*
	  $('#aaa').hide();
	function button(){
	 		var o_code = $('#o_code').val();
	 		
	 		alert(o_code);
	 		var data = {code : o_code};
	 		$.ajax({
				type : "post",
				url : "orderHistory",
				data : data,
				success : function(result){
	    			if(result == "fail"){
						alert("데이터가 없습니다.");
					} else if(result == "true"){
						alert("데이터가 있습니다!!!!!!!");
						$('#aaa').show();
						
					} 
				}
	 		});
	 	}*/
	 </script>
	  		<!-- JS here -->
    <!-- All JS Custom Plugins Link Here here -->
    <script src="<c:url value = "/resources/js/vendor/modernizr-3.5.0.min.js"/>"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="<c:url value = "/resources/js/vendor/jquery-1.12.4.min.js"/>"></script>
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
    <script src="<c:url value = "/resources/js/jquery.nice-select.min.js"/>"></script>
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