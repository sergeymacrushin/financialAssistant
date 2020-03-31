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
    <title>Costs</title>
</head>
<body>

<h2>Costs</h2>
<table>
    <tr>
        <th>id</th>
        <th>id_user</th>
        <th>sum</th>
        <th>type</th>
    </tr>
    <c:forEach var="cost" items="${costsList}">
        <tr>
            <td>${cost.id}</td>
            <td>${cost.id_user}</td>
            <td>${cost.sum}</td>
            <td>${cost.type}</td>
            <td>
                <a href="/editCost/${cost.id}">edit</a>
                <a href="/deleteCost/${cost.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>

<c:url value="/addCost/${id_u}" var="add"/>
<a href="${add}">Add new cost</a>
<c:url value="/" var="back"/>
<a href="${back}">back</a>
</body>
</html>
