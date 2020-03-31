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
    <c:if test="${empty revenue.sum}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty revenue.sum}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty revenue.sum}">
    <c:url value="/addRevenue" var="var"/>
</c:if>
<c:if test="${!empty revenue.sum}">
    <c:url value="/editRevenue" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <c:if test="${!empty revenue.sum}">
        <input type="hidden" name="id" value="${revenue.id}">
        <input type="hidden" name="id_user" value="${revenue.id_user}">
    </c:if>
    <label for="sum">Sum</label>
    <input type="text" name="sum" id="sum">
    <label for="type">type</label>
    <input type="text" name="type" id="type">
    <input type="hidden" name="id_user" value="${id_u}">
    <c:if test="${empty revenue.sum}">
        <input type="submit" value="Add new revenue">
    </c:if>
    <c:if test="${!empty revenue.sum}">
        <input type="submit" value="Edit revenue">
    </c:if>
</form>
</body>
</html>
