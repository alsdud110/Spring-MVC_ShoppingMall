<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ü ��ǰ ����Ʈ</title>
</head>
<body>
    <table>
		<tr>
			<td>��ǰ �̹���1</td><td>��ǰ �̹���2</td><td>��ǰ �̹���3</td>
		</tr>	
		<tr>
			<td>��ǰ ���̸�</td><td>��ǰ �̹���2</td><td>��ǰ �̹���3</td>
		</tr>	
		<tr>
			<td>��ǰ ����</td><td>��ǰ �̹���2</td><td>��ǰ �̹���3</td>
		</tr>
		<c:forEach var="list" items="${list}">
        <tr>
      		<td>${list.p_CODE}</td>
        	<td>${list.p_IMAGE}</td>
        	
            <td>${list.p_NAME}</td>
			<td>${list.p_KIND}</td>
			
			<td>${list.p_PRICE}</td>
        </tr>
        </c:forEach>
	
	</table>
</body>
</html>

<!-- <td><a href="<c:url value="/members/${mem.id}"/>">
<<<<<<< HEAD
                ${mem.email}</a></td> -->
=======
                ${mem.email}</a></td> -->
>>>>>>> 92755a5a4faddeaf8c45c3e25885439a4f2c62bb
