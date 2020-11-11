<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/7/2020
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<html>
<head>
    <title>Recipe Detail</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-sm bg-light navbar-light" style="height: 80px">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <i class="fad fa-rocket-launch"></i>
            </li>
            <li class="nav-item active">
                <a class="navbar-brand" href="/FoodBlog">Admin Site</a>
            </li>
            <li class="nav-item dropdown active">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Danh mục bánh
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach items="${categoryList}" var="category">
                        <a class="dropdown-item"
                           href="/FoodBlog?action=viewByCategory&CategoryId=${category.getCategoryId()}"><c:out
                                value="${category.getCategoryName()}"></c:out></a>
                    </c:forEach>
                </div>
            </li>
            <li class="nav-item active">
                <a href="/FoodBlog?action=create" class="nav-link">Thêm bài đăng</a>
            </li>
            <li class="nav-item active">
                <a href="/Category" class="nav-link">Chỉnh sửa danh mục bánh</a>
            </li>
        </ul>
        <%--        <form class="form-inline my-2 my-lg-0" action="/FoodBlog" method="get">--%>
        <%--            <input type="hidden" name="action">--%>
        <%--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">--%>
        <%--            <button type="submit" class="btn btn-outline-secondary">TÌM KIẾM</button>--%>
        <%--        </form>--%>
    </nav>
    <h1 class="display-3"><c:out value="${recipe.getTitle()}"></c:out></h1>
    <ul class="list-inline">
        <li class="list-inline-item">Độ khó:
            <c:if test="${recipe.getDifficulty()==1}">
                <c:out value="Dễ"></c:out>
            </c:if>
            <c:if test="${recipe.getDifficulty()==2}">
                <c:out value="Trung bình"></c:out>
            </c:if>
            <c:if test="${recipe.getDifficulty()==3}">
                <c:out value="Khó"></c:out>
            </c:if>
        </li>
        <li class="list-inline-item">Khẩu phần: <c:out value="${recipe.getYield()}"></c:out> người</li>
        <li class="list-inline-item">Thời gian nấu / nướng: <c:out value="${recipe.getCookTime()}"/> giờ</li>
    </ul>
    <ul class="list-inline">
        <li class="list-inline-item"> Ngày tạo:
            <c:out value="${recipe.getCreatedAt()}"></c:out>

        </li>
    </ul><br><br>
    <figure class="figure">
        <img src="${recipe.getCoverImg()}" class="figure-img img-fluid rounded"
             alt="A generic square placeholder image with rounded corners in a figure.">
    </figure>
    <div class="summerNote">${recipe.getDescription()}</div><br>
    <h5>Nguyên liệu</h5><br>
    <p class="summerNote">${recipe.getIngredient()}</p><br>

    <h5>Công thức</h5>
    <c:forEach items="${cookStepList}" var="cookStep">
        <p class="summerNote">${cookStep.getTextContent()}</p><br>
    </c:forEach>


</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    document.getElementsByClassName("summerNote").onload = function() {myFunction()};
    function myFunction() {
        var text = document.getElementsByClassName("summerNote");
        document.getElementsByClassName("summerNote").innerHTML = text;
    }


</script>
</body>
</html>
