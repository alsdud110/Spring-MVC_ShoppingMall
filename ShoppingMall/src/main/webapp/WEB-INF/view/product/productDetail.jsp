<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import = "member.Member" %>
<!DOCTYPE html>
<html>
<head>

<!-- 헤더 -->
        <jsp:include page="../header.jsp"></jsp:include>
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
        
<!-- 메인로고 -->
<a href= "<c:url value = "/main"/>">
<center>
<img src="https://i.pinimg.com/236x/7e/64/6b/7e646bd7120da69b67240999098e2984.jpg"> <!-- 홈페이지 로고 -->
</center>
</a>



<meta charset="UTF-8">
<title>Insert title here</title>

 <style>
      table {
        width: 100%;
        border-top: 1px solid #444444;
        border-collapse: collapse;
      }
      th, td {
        border-bottom: 1px solid #444444;
        padding: 10px;
        text-align: center;
      }
    </style>

<script type="text/javascript">
function setQty() {
	  const qty=document.getElementById('qty').value;
	  const price=${product.p_PRICE};
	document.getElementById('sumMoney').value = price*qty;
}

function select(str) {
	const num=str;
	var p_size = new Array();
	var p_color = new Array();
	var stock = new Array();
	<c:forEach var="std" items="${productStd}">
	p_size.push("${std.p_size}");
	p_color.push("${std.p_color}");
	</c:forEach>
			
	document.getElementById('p_size').value =p_size[num];
	document.getElementById('p_color').value =p_color[num];

}

function InCart(){
	var name = "${product.p_NAME}";
	var size =document.getElementById('p_size').value;
	var color = document.getElementById('p_color').value;
	var qty = document.getElementById('qty').value;
	var sumMoney = document.getElementById('sumMoney').value;
	if(confirm(
			"아래의 상품이 맞습니까?? \n\n"+
			"상품명:" + name+"\n"+
			"사이즈="+size +"\n"+
			"컬러="+color +"\n"+
			"수량="+qty +"\n"+
			"총 가격="+sumMoney
			)== true){
		alert("담았어");
		}
	else{
		alert("취소했어");
		return false;
	}
}
</script>

<% 
String m_code=null;
Member authInfo=(Member)session.getAttribute("authInfo");
if(authInfo !=null){
	m_code=authInfo.getM_code();
}
%>
</head>
<body>

	<h2>상품 클릭시 넘어올 상세페이지. 카트or구매 쪽으로 데이터 넘길 예정</h2>
	<form:form modelAttribute="CartVO" onsubmit="return InCart()">	<!-- action 주소 = 현재주소/123주소     : productDetail/123  >>>>>카트나 구매쪽으로 넘길 예정-->
	<input type="hidden" name="p_code" value="${product.p_CODE}"/>	
	

	
	
	<center>
	<table>
		
	<tr>
	<div align="center" style="border-radius: 2em;">
	<td rowspan="8">${product.p_IMAGE}
	<input type="hidden" name="p_image" value="${product.p_IMAGE}"/>
	</td>
	</tr>
	
	<thread>
	<tr>
	<td colspan="2"><center><p>${product.p_NAME}</p></td>
	<input type="hidden" name="p_name" value="${product.p_NAME}"/>

	</tr>
	
	<tr>
	<td colspan="2"><center><p>${product.p_PRICE}</p></td>
	<input type="hidden" name="p_price" value="${product.p_PRICE}"/>
	</tr>
	
	<tr>
	<td>size</td>
	<td>
	<center>
	<select name="str" onchange="select(this.value)">
	<option value="none">=== 선택 ===</option>
	<c:forEach var="std" items="${productStd}" varStatus="status">
	<option value="${status.index}">${std.p_color}-${std.p_size}</option>
	</c:forEach>
	</select>
		<input type="hidden" id="p_color" name="p_color"/>  
		<input type="hidden" id="p_size" name="p_size"/>
	</td> 
	</tr>


	<tr>
	<td>qty</td>
	<td>

	<input class="product_count_item inumber-decrement" type="number" id="qty" name="qty" onblur='setQty()' value="1" min="1"><td>

   
	</td>
	</tr>
	
	<tr>
	<td>총 상품 금액</td>
	<div align="center"></div>
	<td><input type="text" id='sumMoney' name="sumMoney" value="" readonly onblur='choice()'></td> <!-- readonly : 수정불가, form 전달가능  -->
	<td></td>
	</tr>
<table>

    <td colspan="2"><div class="Proceed to checkout" padding:20px; align="right"> <input type="submit" class="genric-btn primary e-large" value=구매하기 formaction="<c:url value="/order"/>"></td>
	</tr>
	
	<tr>
	
	<td>   
	<div class="add_to_cart" align="right"> <input type="submit" class="genric-btn primary-border e-large" formaction="<c:url value="/AddCart"/>" value="장바구니 담기">
	</div></td>
	
	
	
	
	<td><div class="wishlist" align="left"> <a href="#" class="genric-btn primary-border e-large">위시리스트 담기</a> 
	</div></td>
    </tr>
	</table>
	<br></br>
	<br></br>
	<br></br>
	</form:form>
	</center>
	
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
	

