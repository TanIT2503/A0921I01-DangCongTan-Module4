<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 24/04/2022
  Time: 1:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwich Condiments are checked: </h3>
<c:forEach items="${condiments}" var="eat">
    <p>${eat}</p>
</c:forEach>
</body>
</html>
