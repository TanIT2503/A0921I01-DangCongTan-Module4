<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 03/05/2022
  Time: 6:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/email/list">Back to list</a>
<form:form method="post" action="/email/update" modelAttribute="configEmail">
    <table>
        <tr>
            <td><form:hidden path="id"></form:hidden></td>
        </tr>
        <tr>
            <td>Languages</td>
            <td><form:select path="languages" items="${languages}" ></form:select></td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td><form:select path="pageSize" items="${pageSize}"></form:select></td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamsFilter"></form:checkbox> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
