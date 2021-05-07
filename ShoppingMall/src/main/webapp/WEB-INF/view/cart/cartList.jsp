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
function fnGetdata(){
    var obj = $("[name=btn]");
    var chkArray = new Array(); // 배열 선언

    $('input:checkbox[name=btn]:checked').each(function() { // 체크된 체크박스의 value 값을 가지고 온다.
        chkArray.push(this.value);
    alert(this.value);
    });
    $('#hiddenValue').val(chkArray);
    
    alert($('#hiddenValue').val()); // 아래 체크박스가 모두 체크되어 있다면 1,2,3,4 가 출력 된다.
    
}

const totalmoney=0;
<c:forEach var="list" items="${cartlist}">
	totalmoney= totalmoney+${list.p_price * list.qty};
</c:forEach>

document.getElementById('totalmoney').value=totalmoney;
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
	
	<center>

			<span class="this" title="현재페이지"><b>Cart</b> ></span> 
			<span>Order</span> >
			<span class="end">Order confirmed</span>

	</center>

<br></br>

      <form name="form1" id="form1" method="post" action="">
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
                      <h5><fmt:formatNumber pattern="###,###,###" value="${list.p_price}" /></h5>
                    </td>
                    <td>
                      <input type="number" style="width: 50px" name="amount"
						value="${list.qty}" min="1"> <input type="hidden"
						name="p_code" value="${list.p_code}">
                    </td>
                    <td>
                      <h5><fmt:formatNumber pattern="###,###,###" value="${list.p_price*list.qty}" /></h5>
                    </td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
				  <input type="hidden" name="count" value="${map.count}">
				  <center>
				  <input type="submit" value="삭제" id="delete" class="genric-btn primary radius" formaction="<c:url value="/cart/delete"/>" style="margin-left:20px;">
				  <input type="submit" value="구매하기" id="updateCart" class="genric-btn primary radius" formaction="<c:url value="/order/"/>">
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

	<!— contact js —>
	<script src="<c:url value = "/resources/js/contact.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.form.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.validate.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/mail-script.js"/>"></script>
	<script src="<c:url value = "/resources/js/jquery.ajaxchimp.min.js"/>"></script>

	<!— Jquery Plugins, main Jquery —>
	<script src="<c:url value = "/resources/js/plugins.js"/>"></script>
	<script src="<c:url value = "/resources/js/main.js"/>"></script>
</body>
</html>