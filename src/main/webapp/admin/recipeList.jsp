<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/7/2020
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
      integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" method="get" action="/FoodBlog">
            <h1 class="col-8">Recipe List</h1>
            <input type="hidden" name="action">
            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <a href="/FoodBlog?action=create" class="btn btn-success btn-lg active"
       role="button" aria-pressed="true">Thêm bài đăng</a>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tên công thức</th>
            <th scope="col">Ngày tạo</th>
            <th scope="col">Người tạo</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${recipeList}">
            <tr>
                <th scope="row"><c:out value="${recipe.getRecipeId()}"/></th>
                <td><a href="/FoodBlog?action=view&id=${recipe.getRecipeId()}"><c:out value="${recipe.getTitle()}"/></a>
                </td>
                <td><c:out value="${recipe.getCreatedAt()}"/></td>
                <td><c:out value="${'Writer'}"/></td>
                <td>
                    <a href="/FoodBlog?action=update&id=${recipe.getRecipeId()}" class="btn btn-primary btn-sm active"
                       role="button" aria-pressed="true">Chỉnh sửa</a>
                </td>
                <td>
                    <button class="btn btn-danger btn-sm active" role="button" aria-pressed="true"
                            onclick="confirmDelete()">Xóa
                    </button>
                    <script>
                        function confirmDelete() {
                            let isDelete = confirm("Bạn có chắc chắn muốn xóa bài đăng này?\n Đây là thao tác không thể khôi phục");
                            if (isDelete) {
                                window.location.href = "/FoodBlog?action=delete&id=${recipe.getRecipeId()}";
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
