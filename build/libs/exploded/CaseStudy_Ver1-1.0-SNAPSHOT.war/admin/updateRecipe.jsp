<%--
  Created by IntelliJ IDEA.
  User: thu
  Date: 11/7/2020
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <title>Edit recipe</title>
    <style>
        form label {font-weight:bold}
    </style>
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
            <input type="text" name="title" class="form-control" id="title" value="${editRecipe.getTitle()}">
        </div>
        <div class="form-group">
            <label for="description">Mô tả</label>
            <input type="text" name="description" class="form-control summernote" id="description"
                   value="${editRecipe.getDescription()}">
        </div>
        <div class="form-group">
            <label for="ingredient">Nguyên liệu</label>
            <input type="text" name="ingredient" class="form-control summernote" id="ingredient"
                   value="${editRecipe.getIngredient()}">
        </div>
        <div class="form-group row">
            <label for="cookTime" class="col-4 col-form-label">Thời gian nấu/nướng </label>
            <div class="col-2">
                <input class="form-control" type="number" id="cookTime" name="cookTime"
                       value="${editRecipe.getCookTime()}">
            </div>
            <label for="yield" class="col-4 col-form-label">Khẩu phần</label>
            <div class="col-2">
                <input class="form-control" type="number" id="yield" name="yield" value="${editRecipe.getYield()}">
            </div>
        </div>
        <div class="form-group row">
            <label for="difficulty" class="col-4 col-form-label">Độ khó</label>
            <select class="col-6 custom-select" id="difficulty" name="difficulty">
                <option value="1">Dễ</option>
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
        <h5>Công thức</h5>
        <c:forEach items="${cookStepList}" var="cookStep">
            <div class="form-group">
                <textarea class="form-control summernote" name="cookStep" ><c:out value="${cookStep.getTextContent()}"></c:out></textarea>
                <a href="" class="btn btn-danger btn-sm active col-1"
                   role="button" aria-pressed="true" style="float: right">Xóa</a><br>
                    <%--                <p name="cookStep">${cookStep.getTextContent()}</p>--%>
                    <%--                <a href="" class="btn btn-danger btn-sm active col-1"--%>
                    <%--                   role="button" aria-pressed="true">Xóa</a>--%>
            </div>
        </c:forEach>
        <%--        Button thêm ô để ghi công thức--%>
        <div id="reqs">
            <h3 align="center"></h3>
        </div>
        <script>
            var reqs_id = 0;

            function removeElement(ev) { // ev là cái gì?
                var button = ev.target;
                var field = button.previousSibling;
                var div = button.parentElement;
                div.removeChild(button);
                div.removeChild(field);
            }

            function add() {
                reqs_id++; // increment reqs_id to get a unique ID for the new element
                //create textbox
                var input = document.createElement('textarea');// Tạo ra nút
                input.setAttribute("class", "form-control summernote");
                input.setAttribute("name","cookStep");
               var reqs = document.getElementById("reqs");
                //create remove button
                var remove = document.createElement('a');
                remove.setAttribute("class","btn btn-danger btn-sm active col-1");
                remove.setAttribute("role","button");
                remove.setAttribute("style","float: right");
                remove.onclick = function(e) {
                    removeElement(e)
                };
                remove.setAttribute("type", "button");
                remove.innerHTML = "Remove";
                //append elements
                reqs.appendChild(input);
                $('.summernote').summernote(option = {
                    toolbar: [
                        ['style', ['bold', 'italic', 'underline', 'clear']],
                        ['font', ['strikethrough', 'superscript', 'subscript']],
                        ['fontsize', ['fontsize']],
                        ['color', ['color']],
                        ['para', ['ul', 'ol', 'paragraph']],
                        ['height', ['height']]
                    ]
                });
                reqs.appendChild(remove);
            }

        </script>
        <button type="button" class="btn btn-success" value="Add" onclick="javascript:add();"> Thêm công thức </button><br><br>
<%----%>
        <div style="align-items: center">
            <button type="submit" class="btn btn-primary btn-lg" >Submit</button>
        </div>

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
<script>
    $(document).ready(function () {
        $('.summernote').summernote(option = {
            toolbar: [
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['font', ['strikethrough', 'superscript', 'subscript']],
                ['fontsize', ['fontsize']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']]
            ]
        });
    });

</script>
</body>
</html>
