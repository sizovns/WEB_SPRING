<%--
  Created by IntelliJ IDEA.
  User: Woltes
  Date: 27.01.2018
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<form:form method="POST" action="index">
    <pre>
<label for="login">LOGIN</label>     <input type="text" name="login" id="login" required="required"><Br>
<label for="password">PASSWORD</label>  <input type="password" name="password" id="password" required="required">
<input type="submit" name="login" value="login"> ${error}
</pre>
</form:form>
</body>
</html>
