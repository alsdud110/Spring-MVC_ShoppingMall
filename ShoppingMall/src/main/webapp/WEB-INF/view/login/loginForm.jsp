<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
        <label><spring:message code="id" />:<br>
        <form:input path="m_id" />
        <form:errors path="m_id"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="m_pw" />
        <form:errors path="m_pw"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberId" />:
        <form:checkbox path="rememberId"/> 
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
    </form:form>
</body>
</html>
