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

<style>
.order-page .tit-supplier {
    padding: 0 0 15px 0;
    color: #000;
    font-size: 28px;
    font-family: "notokrB";
    font-weight: normal;
}


colgroup {
  display: table-column-group;
}

.table2 > table > tbody > tr > th {
    padding: 10px 0;
    color: #8f8f8f;
    font-weight: normal;
    text-indent: 8px;
} 

.mt10 {
    margin-top: 10px;
}
</style>


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
			>
			<span class="this" title="현재페이지"><b>Order</b></span>
			>
			<span class="end">Order confirmed</span>
		</div>
	<form name="form1" id="form1" method="post" action="order">
        <div class="container">
          <div class="cart_inner">
          	<div class = "table-responsive">
              		<table class="table">
              		  <thead>
                 		 <tr>
							<th scope = "col">상품</th>
							<th scope = "col">단가</th>
							<th scope = "col">수량</th>
							<th scope = "col">금액</th>
                 		</tr>
               		 </thead>
                <tbody>
                <c:forEach var="list" items="${orderlist}" varStatus="i">
                  <tr>
                    <td>
                      <div class="media">
                        <div class="d-flex">
                          <img src=	"<c:url value = "${list.p_image }"/>" alt="" />
                        </div>
                        <div class="media-body">
                          <p>${list.p_name }</p>
                        </div>
                      </div>
                    </td>
                    <td>
                      <h5><fmt:formatNumber pattern="###,###,###" value="${list.p_price}" /></h5>
                    </td>
                    <td>
						<input type="number" style="width: 50px" name="amount"
						value="${list.qty}" min="1" readonly> <input type="hidden"
						name="p_code" value="${list.p_code}">
                    </td>
                    <td id = "sumMoney" >
                      <h5><fmt:formatNumber pattern="###,###,###" value="${list.sumMoney}" /></h5>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        
 
               <!-- 주문자 정보-->
               <div style= "margin-left:13%"> 
                    <h3 class="tit-supplier mt90"><b>주문자  정보</b></h3>
                     <hr width =85% color="black" align="left" size="35"/>
                     <br>
                    
                    <div class="table2">
                        <table>
                            <colgroup>
                                <col style="width:140px;">
                                <col>
                            </colgroup>
                            
                           
                            <tbody>
                            <tr>
                                <th class="ta-l required" aria-required="true">주문하시는 분</th>
                                <td>
                                    <div class="txt-field hs" style="width:380px;">
                                        <input type="text" name="orderName" maxlength="20" class="text">
                                        <br>
           						
                                    </div>
                                </td>
                            </tr>
							
                            <tr>
                                <th class="ta-l required" aria-required="true">휴대폰 번호</th>
                                
                                <td>
                                    <div class="txt-field hs" style="width:380px;">
                                        <input type="text" id="mobileNum" name="orderCellPhone" value="" maxlength="20" class="text" placeholder=" - 제외 입력">
                                    </div>
                                </td>
                            </tr>
                            
                            <tr>
                                <th class="ta-l required" aria-required="true">이메일</th>
                                <td>
                                    <div class="email">
                                        <span class="txt-field hs" style="width:250px;">
                                       
                                            <input type="text" name="orderEmail" value="" class="text">
                                        </span>
                                       </div>
                                       </td>
                                       </tr>
                                       
                            </tbody>
                        
                        </table>
                    </div>
                    </div>
                  
                    
                    <!-- 주문자 정보 끝 -->
                    
                    <br>
                    <br>
                    
                    <!-- 배송 정보 -->
                     <div style= "margin-left:13%"> 
                    <h3 class="tit-supplier mt90"><b>배송 정보</b></h3>
                    <hr width =85% color="black" align="left" size=35/>
                   <br>
                    <div class="table2">
                        <table>
                            <colgroup>
                                <col style="width:140px;">
                                <col>
                            </colgroup>
                            <tbody>
                            
                            
                            <tr>
                                <th class="ta-l required" aria-required="true">받으실분</th>
                                <td>
                                    <div class="txt-field hs" style="width:380px;">
                                        <input type="text" name="receiverName" value="" maxlength="20" class="text">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th class="ta-l required" aria-required="true">배송지 입력</th>
                                <td>
                                    <div class="post">
                                        <span class="txt-field hs" style="width:250px;">
                                            <input type="text" name="receiverZonecode" value="" readonly="readonly" style="width:150px;" class="text">
                                            <input type="hidden" name="receiverZipcode" value="">
                                            <span id="receiverZipcodeText" class="text"></span>
                                        </span>
                                        <button type="button" onclick="postcode_search('receiverZonecode', 'receiverAddress', 'receiverZipcode');"  class="genric-btn primary small"><em>우편번호검색</em></button>
                                    </div>
                                    <div class="sa mt10">
                                        <span class="txt-field hs" style="width:420px;">
                                            <input type="text" name="receiverAddress" value="" readonly="readonly" class="text">
                                        </span>
                                        <span class="txt-field hs" style="width:420px;">
                                            <input type="text" name="receiverAddressSub" value="" class="text" placeholder="상세주소 입력">
                                        </span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th class="ta-l">전화번호</th>
                                <td>
                                    <span class="txt-field hs" style="width:380px;">
                                        <input type="text" id="receiverPhone" name="receiverPhone" value="" class="text" numberonly="true">
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <th class="ta-l required" aria-required="true">휴대폰 번호</th>
                                <td>
                                    <span class="txt-field hs" style="width:380px;">
                                        <input type="text" id="receiverCellPhone" name="receiverCellPhone" value="" class="text" placeholder=" - 제외 입력" numberonly="true">
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <th class="ta-l">배송 메시지</th>
                                <td>
                                    <div class="txt-field hs" style="width:380px;">
                                        <input type="text" name="orderMemo" value="" class="text">
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                         </form>
				  <input type="submit" value="구매하기" id="updateCart" class="genric-btn primary radius" style = "margin-left : 75%;">
	     </form>
	     
	     
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