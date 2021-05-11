<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta charset="UTF-8">
<title>상품 상세페이지</title>

 <style>
      table {
        width: 100%;
        border-top: 1px solid #444444;
        border-collapse: collapse;
      }
      th, td, tr {
        border-bottom: 1px solid #444444;
        padding: 10px;
        text-align: center;
       }
       
       .jungmin{
<<<<<<< HEAD
       		margin-left : 150px;
       }
  
=======
       		margin-left : 350px;
       		
       }
       
       .jungmin2{
       		margin-left : 500px;
       }
>>>>>>> 이상훈
  
    </style>

<script type="text/javascript">
function setQty() {
	  const qty=document.getElementById('qty').value;
	  const price=${product.p_PRICE};
	document.getElementById('sumMoney').value = price*qty;
}

<<<<<<< HEAD
=======
function setQty2(){
	const qty2=document.getElementById('qty').value;
	  const price=${product.p_PRICE};
	document.getElementById('sumMoney').value = price*qty2;
}

>>>>>>> 이상훈
function select(str) {
	const num=str;
	var p_size = new Array();
	var p_color = new Array();
	var stock = new Array();
	<c:forEach var="std" items="${productStd}">
	p_size.push("${std.p_size}");
	p_color.push("${std.p_color}");
	</c:forEach>
<<<<<<< HEAD

=======
>>>>>>> 이상훈
		
	document.getElementById('p_size').value =p_size[num];
	document.getElementById('p_color').value =p_color[num];

}
	
function checkdata(){
	var name = "${product.p_NAME}";
	var size =document.getElementById('p_size').value;
	var color = document.getElementById('p_color').value;
	var qty = document.getElementById('qty').value;
	var sumMoney = document.getElementById('sumMoney').value;
<<<<<<< HEAD
	
	if(size == "" || color == ""){
		alert('사이즈와 색상을 선택해주세요.');
		return false;
	}
		
	if(confirm(
			"선택하신 상품 내역을 확인해주세요. \n\n"+
			"상품명 : " + name+"\n"+
			"사이즈 : "+size +"\n"+
			"컬러 : "+color +"\n"+
			"수량 : "+qty +"\n"+
			"총 가격 : "+sumMoney + "원")== true){
		}
	else{
		alert('취소하셨습니다.');
=======
	if(size==null || size==""){
		alert("컬러 & 사이즈를 선택하세요.");
>>>>>>> 이상훈
		return false;
	}
		if(confirm(
				"선택하신 상품 내역을 확인해주세요. \n\n"+
				"상품명=" + name+"\n"+
				"컬러="+color +"\n"+
				"사이즈="+size +"\n"+
				"수량="+qty +"\n"+
				"총 가격="+sumMoney)== true){
			alert("장바구니에 상품이 담겼습니다.");
			}
		else{
			alert("장바구니에 상품 담기를 취소했습니다.");
			return false;
		}
}

function count(type)  {

	 var qty=parseInt(document.getElementById('qty').value);
	  var price=${product.p_PRICE};
	  
	  // 더하기/빼기
	  if(type === "plus") {
		  if(qty==10){ //최대 주문수량 10개 제한
			  qty=qty;
		  }else
		  qty=parseInt(document.getElementById('qty').value)+1;
		  document.getElementById('qty').value=qty;
		  
	  }else if(type === "minus")  {
		  if(qty==1){ //최소 주문수량 1개로 제한
			  qty=qty
			  }else
		  qty=parseInt(document.getElementById('qty').value)-1;
		  document.getElementById('qty').value=qty;
	  }
	  
	  // 결과 출력
	  document.getElementById('sumMoney').value = parseInt(price)*parseInt(qty);  
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

<br></br>

	<div class="col-xl-12">
	<div class="section-tittle mb-70">
	<div class="text-center">
	<h2><b>Product Info.</b></h2>
	</div>
<br></br>
</div>
</div>
	

	<form:form modelAttribute="CartVO" onsubmit="return checkdata()">	<!-- action 주소 = 현재주소/123주소     : productDetail/123  >>>>>카트나 구매쪽으로 넘길 예정-->
	<input type="hidden" name="p_code" value="${product.p_CODE}"/>	
	<table> 

	<tr>
<<<<<<< HEAD
	<td rowspan="7"> <img src="<c:url value="${product.p_IMAGE}"/>" width="550" height="600">
	<input type = "hidden" name = "p_img" value = "${product.p_IMAGE }"/>
	</td>

=======
	<td rowspan="7"> <img src="<c:url value="${product.p_IMAGE}"/>" width="550" height="600"></td>

 	
>>>>>>> 이상훈
	<td>상품명</td>
	<td><p><b>${product.p_NAME}</b></p>
	<input type="hidden" name="p_name" value="${product.p_NAME}"/>
	</td>
	
	<tr>
	<td>가격</td>
	<td><p><b><fmt:formatNumber pattern="###,###,###" value="${product.p_PRICE}" />원</b></p>
	<input type="hidden" name="p_price" value="${product.p_PRICE}"/>
	</td>
	</tr>
	<tr>
	
</tr>
 
 	<tr>
	<td>SIZE & COLOR </td>
	<td>
	<div class="jungmin">
	<select name="str" onchange="select(this.value)">
	<option value="none">=== 선택 ===</option>
	<c:forEach var="std" items="${productStd}" varStatus="status">
		<c:choose>
			<c:when test="${std.stock eq 0 }">
			<option value="${status.index}" disabled>${std.p_color}-${std.p_size} 품절 </option>
			</c:when>
			<c:otherwise>
			<option value="${status.index}">${std.p_color}-${std.p_size}</option>
			</c:otherwise>
		</c:choose>
	
	</c:forEach>
	</select>
		<input type="hidden" id="p_color" name="p_color"/>  
		<input type="hidden" id="p_size" name="p_size"/>
	</div>
	</td> 
	</tr>
	
	<tr>
	<td>수량</td>	
	<td>
	
<span class="product_count_item number-decrement"> <i class="ti-minus qty2" onclick = 'setQty2()'></i></span>
<input class="product_count_item input-number" type="number" id="qty" name="qty" onblur='setQty()' value = "1" min="1" max="10" >
<span class="product_count_item number-increment"> <i class="ti-plus qty2" onclick = 'setQty2()'></i></span>
<<<<<<< HEAD
</td>
</tr>
=======
<input type='button' style="width:40px; hight:20px" onclick='count("plus")' value='+'/>
<input type='button' style="width:40px; hight:20px" onclick='count("minus")' value='-'/>
>>>>>>> 이상훈


<tr>
	<td>총 상품 금액</td>
	<td><input type="text" id='sumMoney' name="sumMoney" value="${product.p_PRICE}" readonly></td> <!-- readonly : 수정불가, form 전달가능  -->
</tr>
	
 	

</table>
<table>
<tr>
    <td><input type="submit" class="genric-btn primary e-large" style="float:right; margin-top:10px; margin-bottom:10px; margin-left:900px;" value=구매하기 formaction="<c:url value="/order/detailToOrder"/>"></td>
	<td colspan="2"><input type="submit" class="genric-btn primary-border e-large" style="float:left; margin-top:10px; margin-bottom:10px; margin-right:50px;" value="장바구니 담기" formaction="<c:url value="/cart/addCart"/>"></td>  

</tr>	
	</table>
	
	</form:form>

	<br>
	<br>
	<br>
	
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
