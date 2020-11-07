<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/7/2020
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer List</h1>
<c:forEach var="recipe" items="${recipeList}">
    <c:out value="${recipe.getTitle()}"/>
</c:forEach>

</body>
</html>
