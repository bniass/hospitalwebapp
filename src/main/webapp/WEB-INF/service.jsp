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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

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
