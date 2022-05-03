<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 03/05/2022
  Time: 9:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khai báo y tế</h1>
<a href="/declaration/create">Tạo tờ khai</a>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Họ tên</td>
        <td>Năm sinh</td>
        <td>Giới tính</td>
        <td>Quốc tịch</td>
        <td>Số hộ chiếu/CMND</td>
        <td>Thông tin đi lại</td>
        <td>Số hiệu phương tiện</td>
        <td>Số ghế</td>
        <td>Tỉnh/Thành phố đã đi</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${medicalDeclaration}" var="declaration">
        <tr>
            <td>${declaration.id}</td>
            <td>${declaration.name}</td>
            <td>${declaration.birthday}</td>
            <td>${declaration.gender}</td>
            <td>${declaration.nationality}</td>
            <td>${declaration.identification}</td>
            <td>${declaration.vehicle}</td>
            <td>${declaration.numberVehicle}</td>
            <td>${declaration.numberSeats}</td>
            <td>${declaration.city}</td>
            <td><a href="/declaration/view/${declaration.id}">Xem</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
