
<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/8/2020
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>The LITTLE WHISK</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styleForLayout.css">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light" >
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <i class="fad fa-rocket-launch"></i>
        </li>
        <li class="nav-item active">
            <a class="navbar-brand" href="/RecipeBlog">The LITTLE WHISK</a>
        </li>
<%--        <li class="nav-item dropdown active">--%>
<%--            <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button"--%>
<%--               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                Danh mục bánh--%>
<%--            </a>--%>
<%--            <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                &lt;%&ndash;        <c:forEach items="${categoryList}" var="category">&ndash;%&gt;--%>
<%--                &lt;%&ndash;          <a class="dropdown-item"&ndash;%&gt;--%>
<%--                &lt;%&ndash;             href="/FoodBlog?action=viewByCategory&CategoryId=${category.getCategoryId()}"><c:out&ndash;%&gt;--%>
<%--                &lt;%&ndash;                  value="${category.getCategoryName()}"></c:out></a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>
<%--            </div>--%>
<%--        </li>--%>
        <li class="nav-item active">
            <a href="/RecipeBlog?action=viewAllRecipes" class="nav-link">Công thức</a>
        </li>
        <li class="nav-item active">
            <a href="/RecipeBlog?action=viewAllCategories" class="nav-link">Danh mục bánh</a>
        </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="/RecipeBlog" method="get">
        <input type="hidden" name="action" value="searchByName">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
        <button type="submit" class="btn btn-outline-secondary">TÌM KIẾM</button>
    </form>
</nav>


<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="Image/LittleWhiskBanner.png" alt="First slide">
        </div>
        <%--    <div class="carousel-item">--%>
        <%--      <img class="d-block w-100" src="..." alt="Second slide">--%>
        <%--    </div>--%>
        <%--    <div class="carousel-item">--%>
        <%--      <img class="d-block w-100" src="..." alt="Third slide">--%>
        <%--    </div>--%>
    </div>
</div>

<div class="container-fluid text-center">
    <div class="row content">
<%--        Left side bar --%>
        <div class="col-sm-2 sidenav">
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
        </div>

<%--    Main body--%>
        <div class="col-sm-8 text-left">
            <c:forEach items="${recipeList}" var="recipe">
               <h3>${recipe.getTitle()}</h3>
               <img src="${recipe.getCoverImg()}" alt="Cover Img">
               <p>${recipe.getDescription()}</p>
               <a href="/RecipeBlog?action=viewDetail&id=${recipe.getRecipeId()}" class="btn btn-outline-dark" role="button">Xem tiếp</a>
                <hr>
           </c:forEach>
        </div>

<%--    Right side bar--%>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <img src="Image/Logo.png" alt="Ảnh Logo" style="margin: 0">
                <h3>About me</h3>
                <p style="text-align: left">Chào mừng bạn đến với <span style="font-weight: bold">The little whisk!</span><br><br>
                    Tại <span style="font-weight: bold">The little whisk!</span>, mình sẽ chia sẻ các công thức làm bánh thật ngon cùng với nhiều mẹo và
                    cách khắc phục sự cố để giúp bạn thành công ngay trong lần thử đầu tiên ^^<br><br>
                    Mỗi công thức bánh tại The little whisk đều là kết quả của những lần thử - sai để cuối cùng cho ra một công thức ưng ý nhất! <br>
                    Hãy cùng làm bánh với mình nhé!</p>
            </div>

        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
