<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
>>>>>>> 92755a5a4faddeaf8c45c3e25885439a4f2c62bb
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<jsp:include page="testfolder/CategoryMenu.jsp" flush="false" />
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <table>
		<tr>
<<<<<<< HEAD
			<td>ìƒí’ˆ ì½”ë“œ</td>
			<td>ìƒí’ˆ ì´ë¦„</td>
			<td>ìƒí’ˆ ì¢…ë¥˜</td>
			<td>ìƒí’ˆ ì´ë¯¸ì§€</td>
			<td>ìƒí’ˆ ê°€ê²©</td>
=======
			<td>»óÇ° ÄÚµå</td>
			<td>»óÇ° ÀÌ¸§</td>
			<td>»óÇ° Á¾·ù</td>
			<td>»óÇ° ÀÌ¹ÌÁö</td>
			<td>»óÇ° °¡°İ</td>
>>>>>>> 92755a5a4faddeaf8c45c3e25885439a4f2c62bb
		</tr>
	
	 	<c:forEach var="list" items="${kind}">
        <tr>
        	<td>${list.p_CODE}</td>
            <td>${list.p_NAME}</td>
			<td>${list.p_KIND}</td>
			<td><a href="<c:url value='/productDetail/${list.p_CODE}'/>"><img src="${list.p_IMAGE}"></a></td>
			<td>${list.p_PRICE}</td>
        </tr>
        </c:forEach>  
	
	</table>
</body>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 92755a5a4faddeaf8c45c3e25885439a4f2c62bb
