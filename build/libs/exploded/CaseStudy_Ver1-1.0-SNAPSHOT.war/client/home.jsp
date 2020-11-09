<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/8/2020
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
      integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<html>
<head>
    <title>Home</title>
    <style>
        .sticky {
            position: sticky;
            top:0;
            z-index: 999;
        }
    </style>
</head>
<body>
<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="Image/banner1.png" alt="First slide" >
        </div>
<%--        <div class="carousel-item">--%>
<%--            <img class="d-block w-100" src="..." alt="Second slide">--%>
<%--        </div>--%>
<%--        <div class="carousel-item">--%>
<%--            <img class="d-block w-100" src="..." alt="Third slide">--%>
<%--        </div>--%>
    </div>
</div>

    <nav class="navbar navbar-light bg-light" style="float: right">
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <c:forEach items="${recipeList}" var="recipe">
        <h1><c:out value="${recipe.getTitle()}"></c:out></h1>
        <p><em><c:out value="${recipe.getDescription()}"></c:out></em></p>
        <a href="/RecipeBlog?action=view&id=${recipe.getRecipeId()}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Xem chi tiết</a>
    </c:forEach>

<%--    <div class="row">--%>
<%--        <div class="app-wrapper">--%>
<%--            <div class="col-sm-10 col-md-10">--%>
<%--                <div class="col-sm-8 col-md-8">--%>
<%--                    <app-content>--%>
                    <c:forEach items="${recipeList}" var="recipe">
                        <h1><c:out value="${recipe.getTitle()}"></c:out></h1>
                        <p><em><c:out value="${recipe.getDescription()}"></c:out></em></p>
                        <a href="/RecipeBlog?action=view&id=${recipe.getRecipeId()}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Xem chi tiết</a>
                    </c:forEach>
<%--                    </app-content>--%>
<%--                </div>--%>

    Xin chào đến với Blog nấu nướng của mình!

<%--                <div class="sticky">--%>
<%--                    <div class="col-sm-4 col-md-4">--%>
<%--                        <app-side-navbar>--%>
<%--                            Xin chào đến với Blog nấu nướng của mình!--%>
<%--                        </app-side-navbar>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>
</body>
</html>
