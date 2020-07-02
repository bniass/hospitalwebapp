<%--
  Created by IntelliJ IDEA.
  User: niass028652
  Date: 25/06/2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <tr>
        <th>ID</th>
        <th>LIBELLE</th>
    </tr>
    <c:forEach items="${requestScope.services}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.libelle}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
