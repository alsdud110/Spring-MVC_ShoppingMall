<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<td>��ǰ �ڵ�</td>
			<td>��ǰ �̸�</td>
			<td>��ǰ ����</td>
			<td>��ǰ �̹���</td>
			<td>��ǰ ����</td>
		</tr>

		<c:forEach var="list" items="${kind}">
			<tr>
				<td>${list.p_CODE}</td>
				<td>${list.p_NAME}</td>
				<td>${list.p_KIND}</td>
				<td><a href="<c:url value='/productDetail/${list.p_CODE}'/>"><img
						src="${list.p_IMAGE}"></a></td>
				<td>${list.p_PRICE}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>