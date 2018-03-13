<%--
  Created by IntelliJ IDEA.
  User: sbt-sizov-ns
  Date: 10.01.2018
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление пользователями</title>
</head>
<body>
<form:form method="GET" action="/admin/showAll">
    <table class="tg">
        <caption>Таблица пользователей</caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>login</th>
            <th>password</th>
            <th>role</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.roles}</td>
                <th><a href="/admin/update?id=<c:out value="${user.id}"/>">update</a> </th>
                <th><a href="/admin/delete?id=<c:out value="${user.id}"/>">delete</a> </th>
        </tr>
    </c:forEach>
    </table>
</form:form>
<form:form method="GET" action="/admin/index.jsp">
    <input type="submit" value="toAdd">
</form:form>
</body>
</html>
