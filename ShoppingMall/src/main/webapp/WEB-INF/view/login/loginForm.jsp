<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
</head>
<body>
	<!-- Header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<main>
		 <section class="login_part section_padding ">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>처음 방문 해주시나요?</h2>
                                <p>울트라 패션보다 더 멋진 사이트를 만들거예요!!</p>
                                <a href="join" class="btn_3">회원가입하기</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>어서오세요! <br>
                                    4조 프로젝트 의류 쇼핑몰입니다!!</h3>
                                <form:form modelAttribute = "loginCommand" class="row contact_form" novalidate="novalidate">
                                    <div class="col-md-12 form-group p_star">
                                        <label><spring:message code="id" />:<br>
       										<form:input path="m_id" class = "form-control" />
									      	<form:errors path="m_id"/>
									        </label>
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                       <label><spring:message code="password" />:<br>
									        <form:password path="m_pw" class = "form-control"/>
									        <form:errors path="m_pw" />
									        </label>
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <div class="creat_account d-flex align-items-center">              
                                             <label><spring:message code="rememberId" />:
										        <form:checkbox path="rememberId" /> 
										      </label>
                                        </div>
                                        <input type="submit" class = "btn_3" value="<spring:message code="login.btn" />">
                                        <a class="lost_pass" href="#">forget password?</a>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================login_part end =================-->
	</main>
	<!-- 
    <form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
        <label><spring:message code="id" />:<br>
        <form:input path="m_id" />
        <form:errors path="m_id"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="m_pw" />
        <form:errors path="m_pw"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberId" />:
        <form:checkbox path="rememberId"/> 
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
    </form:form>
    -->
    
    <!-- Footer -->
    <jsp:include page = "../footer.jsp"></jsp:include>
    
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
