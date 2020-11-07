<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/5/2020
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
  URL for Test: http://localhost:8080/admin/createRecipe.jsp
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
      integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<html>
<head>
    <title>createRecipe</title>
</head>
<body>
<div class="container">
    <h1>Nhập công thức</h1>
    <form method="post">
        <div class="form-group">
            <label for="coverImg">Chọn ảnh đại diện:</label>
            <input type="file" id="coverImg" name="coverImg">
        </div>
        <div class="form-group">
            <label for="title">Nhập tiêu đề</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="description">Mô tả</label>
            <input type="text" name="description" class="form-control" id="description" placeholder="Mô tả">
        </div>
        <div class="form-group">
            <label for="ingredient">Nguyên liệu</label>
            <input type="text" name="ingredient" class="form-control" id="ingredient"
                   placeholder="Ví dụ: 125 gram sữa tươi không đường">
        </div>
        <div class="form-group row">
            <label for="prepareTime" class="col-4 col-form-label">Thời gian chuẩn bị </label>
            <div class="col-2">
                <input class="form-control" type="number" id="prepareTime">
            </div>
            <label for="cookTime" class="col-4 col-form-label">Thời gian nấu/nướng </label>
            <div class="col-2">
                <input class="form-control" type="number" id="cookTime">
            </div>
        </div>
        <div class="form-group row">
            <label for="waitTime" class="col-4 col-form-label">Thời gian chờ </label>
            <div class="col-2">
                <input class="form-control" type="number" id="waitTime">
            </div>
            <label for="yield" class="col-4 col-form-label">Khẩu phần</label>
            <div class="col-2">
                <input class="form-control" type="number" id="yield">
            </div>
        </div>
        <div class="form-group row">
            <label for="difficulty" class="col-4 col-form-label">Độ khó</label>
            <select class="col-6 custom-select" id="difficulty" name="difficulty">
                <option selected value="1">Dễ</option>
                <option value="2">Trung bình</option>
                <option value="3">Khó</option>
            </select>
        </div>
        <div class="form-group row">
            <label for="category" class="col-4 col-form-label">Danh mục bánh</label>
            <select class="col-6 custom-select" name="category" id="category">
                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.getCategoryId()}"><c:out value="${category.getCategoryName()}"/></option>
                </c:forEach>
            </select>
        </div>
        <%--        --%>
        <div class="form-group row">
            <label for="equipment" class="col-4 col-form-label">Thiết bị</label>
            <div class="col-6">
                <input class="form-control" type="text" id="equipment" placeholder="Ví dụ: Lò nướng">
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
    </form>
</div>


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
