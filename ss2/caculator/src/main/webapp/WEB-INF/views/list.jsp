<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 14/10/2022
  Time: 5:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Calculator$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="get" action="/result">
    <fieldset>
        <legend> Calculator</legend>
        <table>
            <tr>
                <td>First operand:</td>
                <td><input name="firstOperand" type="text"></td>
            </tr>

            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Second operand</td>
                <td><input name="secondOperand" type="text"/></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<p>
    ${result}
</p>
</body>
</html>
