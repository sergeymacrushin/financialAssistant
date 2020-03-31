<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 27.03.2020
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Revenues</title>
</head>
<body>

<h2>Revenues</h2>
<table>
    <tr>
        <th>id</th>
        <th>id_user</th>
        <th>sum</th>
        <th>type</th>
    </tr>
    <c:forEach var="revenue" items="${revenuesList}">
        <tr>
            <td>${revenue.id}</td>
            <td>${revenue.id_user}</td>
            <td>${revenue.sum}</td>
            <td>${revenue.type}</td>
            <td>
                <a href="/editRevenue/${revenue.id}">edit</a>
                <a href="/deleteRevenue/${revenue.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>

<c:url value="/addRevenue/${id_u}" var="add"/>
<a href="${add}">Add new revenue</a>
<c:url value="/" var="back"/>
<a href="${back}">back</a>
</body>
</html>
