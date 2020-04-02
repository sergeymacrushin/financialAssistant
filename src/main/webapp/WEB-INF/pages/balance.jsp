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
    <title>Balance</title>
</head>
<body>

<h2>balance ${user.fname}</h2>
<table>
    <tr>
        <th>id</th>
        <th>fname</th>
        <th>balance</th>

    </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.fname}</td>
            <td>${balance}</td>
        </tr>
</table>

<h2></h2>
<c:url value="/" var="back"/>
<a href="${back}">Back</a>
</body>
</html>
