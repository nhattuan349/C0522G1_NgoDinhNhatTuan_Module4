<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 14/10/2022
  Time: 3:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Show sandwich</h1>

<form action="/result" method="get">
    <input type="checkbox" name="commit" value="salty"> salty
    <input type="checkbox" name="commit" value="sweat"> sweat
    <input type="checkbox" name="commit" value="sour" > sour
    <input type="checkbox" name="commit" value="spicy"> spicy
    <input type="submit" value="save">
</form>
<p>
    <c:forEach items="${commit}" var="commit">
        <span>${commit},</span>
    </c:forEach>
</p>
</body>
</html>
