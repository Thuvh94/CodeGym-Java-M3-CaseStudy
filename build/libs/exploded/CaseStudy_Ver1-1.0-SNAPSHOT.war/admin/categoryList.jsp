<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/10/2020
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<html>
<head>
    <title>Category List</title>
</head>
<body>
<div class="container">
    <%----------------------------------------------%>
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

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tên mục</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categoryList}">
            <tr>
                <th scope="row"><c:out value="${category.getCategoryId()}"/></th>
                <td><a href="/FoodBlog?action=viewByCategory}"><c:out value="${category.getCategoryName()}"/></a>
                </td>
                <td>
                    <a href="/Category?action=update&id=${category.getCategoryId()}" class="btn btn-primary btn-sm active"
                       role="button" aria-pressed="true">Chỉnh sửa</a>
                </td>
                <td>
                    <button class="btn btn-danger btn-sm active" role="button" aria-pressed="true"
                            onclick="confirmDelete()">Xóa
                    </button>
                    <script>
                        function confirmDelete() {
                            let isDelete = confirm("Bạn có chắc chắn muốn xóa danh mục này?");
                            if (isDelete) {
                                window.location.href = "/Category?action=delete&id=${category.getCategoryId()}";
                            }
                        }
                    </script>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--    <a href="/FoodBlog?action=update&id=${recipe.getRecipeId()}">Update</a>--%>
<%--    <a href="/FoodBlog?action=delete&id=${recipe.getRecipeId()}">Delete</a><br><br>--%>

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

