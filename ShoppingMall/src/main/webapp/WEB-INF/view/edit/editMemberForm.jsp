<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "spring.AuthInfo" %>
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
    <title><spring:message code="edit.member.title" /></title>
</head>
<body>
	<jsp:include page = "../header.jsp"/>
	<div class = "container text-center col-lg-4">
		<form:form modelAttribute = "editMemberCommand">
		<%
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			String name = authInfo.getM_name();
			String email = authInfo.getM_email();
			String contact = authInfo.getM_contact();
		%>
		<p>
			<label><spring:message code="name" /> :<br>
			 <form:input path="m_name"  value = "<%=name %>"/> 
			 <form:errors path="m_name" /> 
			 </label>
		</p>
		<p>
			<label><spring:message code="tel" /> : <br> 
			<form:input path="m_contact" value = "<%=contact %>"  />
			<form:errors path="m_contact" />
			</label>
		</p>
		<p>
			<label><spring:message code = "birth" /> : <br>
				<form:select path = "year" name="year" id="year" title="년도" />
				<form:select path = "month" name="month" id="month" title="월"/>
				<form:select path = "day" name="day" id="day" title="일" />
			</label>
		</p>
		<p>			
			<input type="text" id="sample6_postcode" placeholder="우편번호">
			<input type="button" onclick="findAddr()" value="우편번호 찾기"><br>
			<form:input path = "addr_road" id="sample6_address" placeholder="주소"/><br>
			<form:input path = "addr_detail" id="sample6_detailAddress" placeholder="상세주소"/>
			<input type="text" id="sample6_extraAddress" placeholder="참고항목">
		</p>
		<p>
			<label><spring:message code="email" /> : <br>
			<form:input path="m_email" value = "<%=email %>"/>
			<form:errors path="m_email" />
			 </label>
		</p>
		<input type="submit" value= "수정 완료" class = "btn btn-primary">
	</form:form>
	</div>
	


	<jsp:include page = "../footer.jsp"/>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<!-- 생년월일 -->
	<script>
	  $(document).ready(function () {
		    setDateBox();
		});
		function setDateBox(){
			var date = new Date();
			var year = "";
			var com_year = date.getFullYear();
			
			$("#year").append("<option value = ''>년도</option>");
			
			for(var y = com_year ; y >= (com_year - 80); y--){
				$("#year").append("<option value = '" + y +"'>" + y + " 년" + "</option>");
			}
			
			var month = "";
			$("#month").append("<option value = ''>월</option>");
			for(var y = 1 ; y <= 12 ; y++){
				$("#month").append("<option value = '" + y +"'>" + y + " 월" + "</option>");
			}
			
			var day = "";
			$("#day").append("<option value = ''>일</option>");
			for(var y = 1; y <= 31; y++){
				$("#day").append("<option value = '" + y + "'>" + y + " 일" + "</option>");
			}
		}
	</script>
	
	<!-- 아이디 중복확인 절차 -->
	<script>
		$(".id_check").click(function(){
    		
    			console.log('${pageContext.request.contextPath}');
    			var memberId = $('.id_input').val();			// .id_input에 입력되는 값
    			if(memberId === null){
    				$('.msg1').css("display","none");
					$('.msg2').css("display", "none");		
    			}
    			var data = {memberId : memberId}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
    			$.ajax({
    				type : "post",
    				url : "id_check",
    				data : data,
    				success : function(result){
    					console.log("성공 여부 " + result);
    					if(result != 'fail'){
    						$('.msg1').css("display","inline-block");
    						$('.msg2').css("display", "none");				
    					} else {
    						$('.msg2').css("display","inline-block");
    						$('.msg1').css("display", "none");				
    					}
    				}
    			});

    		});

  	</script>
  	
  	<!-- 다음 주소 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function findAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

</body>
</html>
