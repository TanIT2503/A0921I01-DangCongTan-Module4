<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 03/05/2022
  Time: 6:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${configEmailList}" var="email">
        <tr>
            <td>${email.id}</td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td>
                <a href="/email/update/${email.id}">Setting</a>
            </td>
        </tr>
    </c:forEach>
</table>
</html>
