<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function setQty() {
	  const qty=document.getElementById('qty').value;
	  const price=${product.p_PRICE};
	document.getElementById('result').value = price*qty;
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

	alert(num);
		
	document.getElementById('p_color').value =p_size[num];
	document.getElementById('p_size').value =p_color[num];

}
	
</script>
</head>
<body>
	<h2>상품 클릭시 넘어올 상세페이지. 카트or구매 쪽으로 데이터 넘길 예정</h2>
	<form:form action="123" modelAttribute = "CartVO">	<!-- action 주소 = 현재주소/123주소     : productDetail/123  >>>>>카트나 구매쪽으로 넘길 예정-->
	<input type="hidden" name="p_code" value="${product.p_CODE}"/>	
	<table border="1">
	<tr>
	<td rowspan="8">${product.p_IMAGE}
	<input type="hidden" name="p_image" value="${product.p_IMAGE}"/>
	</td>
	</tr>
	
	<tr>
	<td colspan="2"><p>${product.p_NAME}</p></td>
	<input type="hidden" name="p_name" value="${product.p_NAME}"/>

	</tr>
	
	<tr>
	<td colspan="2">${product.p_PRICE}</td>
	<input type="hidden" name="p_price" value="${product.p_PRICE}"/>
	</tr>
	
	<tr>
	<td>사이즈</td>
	<td>
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
	<td>수량</td>
	<td>
	<input type="text" id="qty" name="qty" onblur='setQty()'><td>
	</td>
	</tr>
	
	<tr>
	<td colspan="2"><input type="text" id='result' name="sumMoney" value="" readonly onblur='choice()'></td> <!-- readonly : 수정불가, form 전달가능  -->
	</tr>
	
	<tr>

    <td colspan="2"><input type="submit" value=구매하기></td>
	</tr>
	
	<tr>
	<td>카트 (링크추가)</td>
	<td>wish (링크추가)</td>
	</tr>

	</table>
	</form:form>
	
</body>
</html>