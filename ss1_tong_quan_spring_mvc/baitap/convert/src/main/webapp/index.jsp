<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 22/04/2022
  Time: 7:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Convert Money</h1>
    <form class="convert" action="/convert" method="get">
      <span>Rate</span>
      <input type="text" name="rate" value="23000">
      <span>USD</span>
      <input type="text" name="usd">
      <button type="submit">Convert</button>
    </form>
  </body>
</html>
