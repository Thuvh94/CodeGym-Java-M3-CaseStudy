<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/5/2020
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}

    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }

    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;}
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light" >
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
<%--        <c:forEach items="${categoryList}" var="category">--%>
<%--          <a class="dropdown-item"--%>
<%--             href="/FoodBlog?action=viewByCategory&CategoryId=${category.getCategoryId()}"><c:out--%>
<%--                  value="${category.getCategoryName()}"></c:out></a>--%>
<%--        </c:forEach>--%>
      </div>
    </li>
    <li class="nav-item active">
      <a href="/FoodBlog?action=create" class="nav-link">Thêm bài đăng</a>
    </li>
    <li class="nav-item active">
      <a href="/Category" class="nav-link">Chỉnh sửa danh mục bánh</a>
    </li>
  </ul>
  <form class="form-inline my-2 my-lg-0" action="/FoodBlog" method="get">
    <input type="hidden" name="action">
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
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left">
      <h1>Welcome</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <hr>
      <h3>Test</h3>
      <p>Lorem ipsum...</p>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
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
