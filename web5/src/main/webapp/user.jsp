<%--
  Created by IntelliJ IDEA.
  User: Woltes
  Date: 27.01.2018
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<form:form method="get" action="user">
    <p>Hello USER: ${user.name}</p>
</form:form>
</body>
</html>
