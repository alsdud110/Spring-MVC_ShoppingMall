<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>adminHome</title>
<jsp:include page="../header.jsp"></jsp:include>
</head>
<body>

    <c:if test="${msg == 'success'}">
    <h2>${sessionScope.adminName}
    (${sessionScope.adminId})님 환영합니다.</h2>
    </c:if>

    ${result}
</body>
</html>
