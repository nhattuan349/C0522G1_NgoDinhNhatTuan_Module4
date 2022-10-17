<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/10/2022
  Time: 4:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/settings"> Back to List</a></h3>
<h2> Update</h2>
<h3 style="color: green">${message}</h3>
<table>
    <tr>
        <td>Language:</td>
        <td>${save.languages}</td>
    </tr>
    <tr>
        <td>Page size:</td>
        <td>${save.pageSize}</td>
    </tr>
    <tr>
        <td>Spams filter</td>
        <td>${save.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${save.signature}</td>
    </tr>
</table>
</body>
</html>
