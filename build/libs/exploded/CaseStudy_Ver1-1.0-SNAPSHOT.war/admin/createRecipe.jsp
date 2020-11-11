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

<html>
<head>
    <title>createRecipe</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <style>
        form label {font-weight:bold}
    </style>
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
    <h1>Nhập công thức</h1>
    <form method="post" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="coverImg">Chọn ảnh đại diện:</label>
            <input type="file" id="coverImg" name="coverImg" accept="image/x-png,image/gif,image/jpeg">
        </div>
        <div class="form-group">
            <label for="title">Nhập tiêu đề</label>
            <input type="text" name="title" class="md-textarea form-control" id="title" placeholder="Nhập tiêu đề">
        </div>
        <div class="form-group">
            <label for="description">Mô tả</label>
            <textarea name="description" class="form-control summernote" id="description" placeholder="Mô tả" rows="5" >
            </textarea>
        </div>
        <div class="form-group">
            <label for="ingredient">Nguyên liệu</label>
            <textarea name="ingredient" class="form-control summernote" id="ingredient"
                      placeholder="Ví dụ: 125 gram sữa tươi không đường" rows="7"></textarea>
        </div>
        <div class="form-group row">
            <label for="cookTime" class="col-4 col-form-label">Thời gian nấu/nướng </label>
            <div class="col-2">
                <input class="form-control" type="number" id="cookTime" name="cookTime">
            </div>
            <label for="yield" class="col-4 col-form-label">Khẩu phần</label>
            <div class="col-2">
                <input class="form-control" type="number" id="yield" name="yield">
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
        <%--Phần cook Step--%>
        <h3>Công thức</h3>
        <div id="field">
            <div id="field0">
                <div class="form-group row">
                    <label class="col-md-4 control-label" for="cookStep" style="float: right"></label>
                    <div class="col-md-8">
                        <textarea id="cookStep" name="cookStep" placeholder="" class="form-control input-md summernote"></textarea>
                    </div>
                </div>
                <!-- File Button -->
                <div class="form-group row">
                    <label class="col-md-4 control-label" for="media" style="float: right"></label>
                    <div class="col-md-8">
                        <input type="file" id="media" name="media" class="input-file"
                               accept="image/x-png,image/gif,image/jpeg" multiple>
                        <div id="action_jsondisplay"></div>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-4"></div>
                <div class="col-md-8">
                    <button id="add-more" name="add-more" class="btn btn-primary">Thêm bước</button>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary btn-lg" style="float: right">Submit</button>
    </form>


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
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
<script>
    $(document).ready(function () {
        $('.summernote').summernote(option={toolbar: [
                ['style', ['bold', 'italic', 'underline', 'clear']],
                ['font', ['strikethrough', 'superscript', 'subscript']],
                ['fontsize', ['fontsize']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']]
            ]});
        //@naresh action dynamic childs
        var next = 0;
        $("#add-more").click(function (e) {
            e.preventDefault();
            var addto = "#field" + next;
            var addRemove = "#field" + (next);
            next = next + 1;
            var newIn = ' <div id="field' + next + '" name="field' + next + '">' +
                '<!-- Text input--><br><br><br><div class="form-group row">\n' +
                '                    <label class="col-md-4 control-label" for="cookStep" style="float: right"></label>\n' +
                '                    <div class="col-md-8">\n' +
                '                        <textarea id="cookStep" name="cookStep" placeholder="" class="form-control input-md summernote"></textarea>\n' +
                '                    </div>\n' +
                '                </div>' +
                '<!-- File Button -->  <div class="form-group row">\n' +
                '                    <label class="col-md-4 control-label" for="media" style="float: right"></label>\n' +
                '                    <div class="col-md-8">\n' +
                '                        <input type="file" id="media" name="media" class="input-file" accept="image/x-png,image/gif,image/jpeg" multiple>\n' +
                '                        <div id="action_jsondisplay"></div>\n' +
                '                    </div>\n' +
                '                </div>';

            var newInput = $(newIn);
            var removeBtn = '<button style="float: right" id="remove' + (next - 1) + '" class="btn btn-danger remove-me" >Remove</button></div></div><div id="field">';
            var removeButton = $(removeBtn);
            $(addto).after(newInput);
            $(addRemove).after(removeButton);
            $('.summernote').summernote(option={toolbar: [
                    ['style', ['bold', 'italic', 'underline', 'clear']],
                    ['font', ['strikethrough', 'superscript', 'subscript']],
                    ['fontsize', ['fontsize']],
                    ['color', ['color']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['height', ['height']]
                ]});
            $("#field" + next).attr('data-source', $(addto).attr('data-source'));
            $("#count").val(next);

            $('.remove-me').click(function (e) {
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length - 1);
                var fieldID = "#field" + fieldNum;
                $(this).remove();
                $(fieldID).remove();
            });
        });
        $('.summernote').on('summernote.paste', function(e, ne) {
            var bufferText = ((e.originalEvent || e).clipboardData || window.clipboardData).getData('Text');
            e.preventDefault();
            document.execCommand('insertText', false, bufferText);
        });
    });

</script>
</body>
</html>
