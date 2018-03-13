<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Админка</title>
</head>
<body>
<p>Привет админушка!</p>
<p>Что ты хочешь сделать?</p>
<form:form method="POST" action="/admin/index">
<pre>
<label for="name">NAME</label>      <input type="text" name="name" id="name" required="required">
<label for="login">LOGIN</label>     <input type="text" name="login" id="login" required="required">
<label for="password">PASSWORD</label>  <input type="text" name="password" id="password" required="required">
<label >ROLE</label>      <select name = "roles">
	<option disabled>Выберете роль.</option>
	<option value = "admin">admin</option>
    <option value = "user">user</option>
	</select>
<input type="submit" name="add" value="add">
</pre>
</form:form>
<form:form method="GET" action="/admin/showAll">
    <input type="submit" value="showAll" >
</form:form>
</body>
</html>