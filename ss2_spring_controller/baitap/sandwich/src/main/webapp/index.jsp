<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 24/04/2022
  Time: 1:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Sandwich Condiments</h2>
  <form action="/check">
    <table>
      <tr>
        <td><input type="checkbox" name="condiment" value="Xà lách">Xà lách</td>
        <td><input type="checkbox" name="condiment" value="Cà chua">Cà chua</td>
        <td><input type="checkbox" name="condiment" value="Thị bò">Thị bò</td>
        <td><input type="checkbox" name="condiment" value="Tương ớt">Tương ớt</td>
      </tr>
    </table>
    <input type="submit" value="Save">
  </form>
  </body>
</html>
