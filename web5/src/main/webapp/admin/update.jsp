<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновление пользователя "<c:out value="${user.name}"/>"</title>
</head>
<body>
<form:form method="POST" action="/admin/update">
<pre>
<label for="id">ID</label>        <input type="text" name="id" id="id" readonly="readonly" value="<c:out value="${user.id}"/>">
<label for="name">NAME</label>      <input type="text" name="name" id="name" value="<c:out value="${user.name}"/>" required="required">
<label for="login">LOGIN</label>     <input type="text" name="login" id="login" value="<c:out value="${user.login}"/>" required="required">
<label for="password">PASSWORD</label>  <input type="text" name="password" id="password" value="<c:out value="${user.password}"/>" required="required">
<label for="role">ROLE</label>      <input type="text" name="role" id="role" readonly="readonly" value="<c:out value="${user.roles}"/>" required="required">

<button type="submit" name="update">update</button>
</pre>
</form:form>
<form:form method="GET" action="/admin/index.jsp">
    <input type="submit" name="toAdd" value="toAdd">
</form:form>
<form:form method="GET" action="/admin/deleteRole">
    <c:forEach items="${user.roles}" var="roles">
        <a href="/admin/deleteRole?role=<c:out value="${roles}"/>&id=<c:out value="${user.id}"/>">delete role ${roles}</a><br>
    </c:forEach>
</form:form>
<form:form method="GET" action="/admin/addRole">
    <c:forEach items="${allRoles}" var="allRoles">
        <a href="/admin/addRole?role=<c:out value="${allRoles}"/>&id=<c:out value="${user.id}"/>">add role ${allRoles}</a><br>
    </c:forEach>
</form:form>
</body>
</html>