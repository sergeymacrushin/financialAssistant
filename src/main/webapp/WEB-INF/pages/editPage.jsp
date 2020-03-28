<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 27.03.2020
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.fname}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.fname}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.fname}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.fname}">
    <c:url value="/edit" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <c:if test="${!empty user.fname}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="fname">Fname</label>
    <input type="text" name="fname" id="fname">
    <c:if test="${empty user.fname}">
        <input type="submit" value="Add new user">
    </c:if>
    <c:if test="${!empty user.fname}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>
