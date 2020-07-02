<%--
  Created by IntelliJ IDEA.
  User: niass028652
  Date: 02/07/2020
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/specialite">
    <div class="form-group">
        <label for="libelle">Nom spécialité</label>
        <input value="${requestScope.specialite.libelle}" type="text" class="form-control"
               name="libelle" id="libelle" placeholder="Nom spécialité">
    </div>
    <div class="form-group">
        <label for="service">Service</label>
        <select class="form-control" name="service" required id="service">
            <option value="">----------select---------</option>
            <c:forEach items="${requestScope.services}" var="service">
                <c:choose>
                    <c:when test="${requestScope.specialite.service.id == service.id}">
                        <option selected value="${service.id}">${service.libelle}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${service.id}">${service.libelle}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">ENREGISTRER</button>
    <c:choose>
        <c:when test="${requestScope.specialite == null}">
            <input type="hidden" name="action" value="add">
        </c:when>
        <c:otherwise>
            <input type="hidden" name="action" value="update">
        </c:otherwise>
    </c:choose>
    <input type="hidden" name="id" value="${requestScope.specialite.id}">

</form>
</body>
</html>
