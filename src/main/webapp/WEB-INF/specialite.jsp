<%--
  Created by IntelliJ IDEA.
  User: niass028652
  Date: 25/06/2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script type="application/javascript">
        function supp(idsp) {
            if(confirm("Etes-vous sûr ?")){
                location.href = "/hospitalwebapp/specialite?action=delete&id="+idsp
            }
        }
    </script>
</head>
<body>
   <a href="${pageContext.request.contextPath}/specialite?action=add">NOUVEAU</a>
   <table class="table">
       <tr>
           <th>ID</th>
           <th>NOM SPECIALITE</th>
           <th>SERVICE</th>
           <th></th>
           <th></th>
       </tr>
       <c:forEach items="${requestScope.specialites}" var="sp">
           <tr>
               <td>${sp.id}</td>
               <td>${sp.libelle}</td>
               <td>${sp.service.libelle}</td>
               <td>
                   <a href="${pageContext.request.contextPath}/specialite?id=${sp.id}&action=update">EDITER</a>
               </td>
               <td>
                   <a onclick="supp(${sp.id})" href="#">SUPPRIMER</a>
               </td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
