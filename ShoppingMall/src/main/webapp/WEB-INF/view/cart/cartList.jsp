<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품장바구니 목록</title>
	<jsp:include page="../header.jsp"></jsp:include>
<script>
    $(document).ready(function(){
        // 리스트 페이지로 이동
        $("#btnList").click(function(){
            location.href="${path}/product/productList.do";
        });
    });
</script>
</head>
<body> <!-- ${cartlist} -->
<table>
<tr>
<td colspan="2">상품</td>
<td>사이즈</td>
<td>컬러</td>
<td>가격</td>
<td>수량</td>
<td>total</td>
</tr>
 
<c:forEach var="list" items="${cartlist}">
<tr>
<td>${list.p_image}</td>
<td>${list.p_name }</td>
<td>${list.p_size }</td>
<td>${list.p_color }</td>
<td>${list.p_price}</td>
<td>${list.qty }</td>
<td>${list.qty }*${list.p_price}</td>
</tr>
</c:forEach> 

</table>











<hr>
<h5>위 : 신규   / 아래 : 기존</h5>
<hr>

    <h2>장바구니 확인</h2>
    <c:choose>
        <c:when test="${map.count == 0}"> 장바구니가 비어있습니다.</c:when>
        <c:otherwise>장바구니 목록 출력
                <form name="form1" id="form1" method="post" action="${path}/cart/update.do">
            <table border="1">
                <tr>
                    <th>상품명</th>
                    <th>단가</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th>취소</th>
                </tr>
                <c:forEach var="row" items="${map.list}" varStatus="i">
                <tr>
                    <td>
                        ${row.productName}
                    </td>
                    <td style="width: 80px" align="right">
                        <fmt:formatNumber pattern="###,###,###" value="${row.productPrice}"/>
                    </td>
                    <td>
                        <input type="number" style="width: 40px" name="amount" value="${row.amount}" min="1">
                        <input type="hidden" name="productId" value="${row.productId}">
                    </td>
                    <td style="width: 100px" align="right">
                        <fmt:formatNumber pattern="###,###,###" value="${row.money}"/>
                    </td>
                    <td>
                        <a href="${path}/shop/cart/delete.do?cartId=${row.cartId}">삭제</a>
                    </td>
                </tr>
                </c:forEach>
                <tr>
                    <td colspan="5" align="right">
                        장바구니 금액 합계 : <fmt:formatNumber pattern="###,###,###" value="${map.sumMoney}"/><br>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="count" value="${map.count}">
            <button type="submit" id="btnUpdate">수정</button>
        </form>
		</c:otherwise>
        </c:choose>
    <button type="button" id="btnList">상품목록</button>
</body>
</html>
