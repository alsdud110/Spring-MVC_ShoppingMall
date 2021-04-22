<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  
<title><spring:message code="member.register"/></title>
</head>
<body>
	<h2>
		<spring:message code="member.info"/>
	</h2>
	<form:form action="congrats" modelAttribute="registerCommand">
		<p>
			<label><spring:message code="id" />:<br> 
			<form:input class="id_input" path = "m_id" />
			<button type = "button" class = "id_check">중복확인</button><br>
			<form:errors path="m_id" />
			</label>										
			<span class = "msg1" style = "display : none; color : green;">사용 가능합니다.</span>
			<span class = "msg2" style = "display : none; color : red">중복된 아이디 입니다. 다시 입력해 주세요.</span>
		</p>
		<p>
			<label><spring:message code="password" />:<br> <form:password
					path="m_pw" /> <form:errors path="m_pw" /> </label>
		</p>
		<p>
			<label><spring:message code="password.confirm" />:<br>
				<form:password path="m_confirmpw" /> <form:errors path="m_confirmpw" />
			</label>
		</p>
		<p>
			<label><spring:message code="name" /> :<br> <form:input
					path="m_name" /> <form:errors path="m_name" /> </label>
		</p>
		<p>
			<label><spring:message code="tel" /> : <br> </label>
			<form:input path="m_contact" />
			<form:errors path="m_contact" />
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
			<label><spring:message code="email" /> : <br> </label>
			<form:input path="m_email" />
			<form:errors path="m_email" />
		</p>
		<input type="submit" value="<spring:message code="register.btn" />">
	</form:form>

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
