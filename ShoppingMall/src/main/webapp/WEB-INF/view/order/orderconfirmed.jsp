<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료 페이지</title>
</head>
<body>

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
			<span class="this">Order</span>
			>
			<span class="end" title="현재페이지"><b>Order confirmed</b></span>
		</div>
		
		<form>
		<p>주문이 완료되었습니다.</p>
		
	<div class="orderend_info">
		
			<h4>주문번호</h4>
			
        </div>


		
			<h4>배송지정보</h4>
			<div class="info_dsc">
				<ul>
					<li>이름</li>
					<li>
                    	연락처
					</li>
						<li>주소</li>
				</ul>
			</div>
		</div>
	
	  <input type="submit" value="홈으로 가기" id="home" class="genric-btn primary radius" formaction="<c:url value='/main'/>">
</div>
</form>

</body>
</html>