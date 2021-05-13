<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품장바구니 목록</title>
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
$(document).ready(function(){
	   var sumMoney=0;
	   $("input[type='checkbox']").on('change', function(){
	      var tr = $(this).parent().parent();
	      var td = tr.children();
	        if($(this).is(":checked")){
	        	//10,900 -> 10900 변환 후 숫자 형변환
	           sumMoney+=parseInt(td.eq(4).text().replace("," , ""));
	        }else{
	           sumMoney-=parseInt(td.eq(4).text().replace("," , ""));
	        }
	        $('input[name=sumMoney]').val(sumMoney);
	        
	        //다시 띄워주는건 10900 -> 10,900 으로! 값 자체는 10900 변하지 않음
	        var money = sumMoney.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	        document.getElementById('aaa').innerHTML = money;

	    });
	});
</script>

</head>
<body>
	<!-- ${cartlist} -->

	<div class="container text-center" style="margin-top: 40px;">
		<div class="row">
			<div class="col-xl-12">
				<div class="section-tittle mb-70">
					<h2>Shopping Cart</h2>
				</div>
			</div>
		</div>
	</div>
	
	<div class = "text-center">
			<span class = "this" title = "현재페이지"><b>Cart</b></span> 
			>
			<span>Order</span>
			>
			<span class="end">Order confirmed</span>
	</div>

<br></br>		

      <form name="form1" id="form1" method="post" action = "orderList">
        <div class="container">
          <div class="cart_inner">
          	<div class = "table-responsive">
              		<table class="table">
              		  <thead>
                 		 <tr>
                  		  	<th scope = "col">선택</th>
							<th scope = "col">상품</th>
							<th scope = "col">단가</th>
							<th scope = "col">수량</th>
							<th scope = "col">금액</th>
                 		</tr>
               		 </thead>
                <tbody>
                <c:forEach var="list" items="${cartlist}" varStatus="i">
                  <tr>
                  	<td><input type="checkbox" name="checkid" value=${list.c_code }></td>
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
                    	<input type="hidden" id="price" name="price" value="${list.p_price}">
                      <h5><fmt:formatNumber pattern="###,###,###" value="${list.p_price}" />원</h5>
                    </td>
                    <td>
                      <input type="number" style="width: 50px" name="qty"
						value="${list.qty}" min="1"> <input type="hidden"
						name="p_code" value="${list.p_code}">
                    </td>
                    <td>
                      <h5><fmt:formatNumber pattern="###,###,###" value="${list.p_price*list.qty}" />원</h5>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
			
				<center>
              <input type="hidden" name="sumMoney" value="0">
              <span>선택한 총 금액 : ￦  </span><span id="aaa"></span>원
           <br></br>
				  <input type="submit" value="삭제" id="delete" class="genric-btn primary radius" formaction="<c:url value="/cart/delete"/>">
				  <input type="submit" value="구매하기" id="updateCart" class="genric-btn primary radius" formaction = "<c:url value = "/order/orderList"/>">
		</center>
	     </form>
	   
      <!--================End Cart Area =================-->

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
