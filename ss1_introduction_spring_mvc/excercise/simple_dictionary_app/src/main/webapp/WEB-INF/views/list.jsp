<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13/10/2022
  Time: 4:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/resultDictionary" method="post">
    <input type="text" name="vocabulary">
    <input type="submit" value="translate">
</form>
<p>Kết quả ${result}</p>
</body>
</html>
