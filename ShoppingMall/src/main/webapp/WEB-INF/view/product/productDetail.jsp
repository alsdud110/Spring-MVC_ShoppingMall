<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</script>

</head>
<body>
	<h2>상품 클릭시 넘어올 상세페이지. 카트or구매 쪽으로 데이터 넘길 예정</h2>
	<form:form action="123">	<!-- action 주소 = 현재주소/123주소     : productDetail/123  >>>>>카트나 구매쪽으로 넘길 예정-->
	<table border="1">
	<tr>
	<td rowspan="9">${product.p_IMAGE}</td>
	</tr>
	
	<tr>
	<td colspan="2"><p>${product.p_NAME}</p></td>
	

	</tr>
	
	<tr>
	<td colspan="2">${product.p_PRICE}</td>
	</tr>
	
	<tr>
	<td>사이즈</td>
	<td>
	<select name="size" title="클릭하여 선택해주세요.">
	<c:forEach var="std" items="${productStd}">
	<option value="${std.p_size}">${std.p_size}</option>
	</c:forEach>
	</select>
	</td>
	</tr>
	
	<tr>
	<td>수량</td>
	<td>
	<input type="text" id="qty" name="qty" onblur='setQty()'>

	</td>
	</tr>
	
	<tr>
	<td>컬러</td>
	<td>
	<select name="color" title="클릭하여 선택해주세요.">
	<c:forEach var="std" items="${productStd}">
	<option value="${std.p_color}">${std.p_color}</option>
	</c:forEach>
	</select>
	</td>
	</tr>
	
	<tr>
	<td colspan="2"><input type="text" id='result' name="price" value="" readonly></td> <!-- readonly : 수정불가, form 전달가능  -->
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