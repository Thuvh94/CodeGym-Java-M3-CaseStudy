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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
      integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<html>
<head>
    <title>Recipe Detail</title>
</head>
<body>
<div class="container">
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
<%--<c:out value="${recipe}"></c:out>--%>
<%--&lt;%&ndash;đã chạy&ndash;%&gt;--%>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>
<script>
    // function onload(){
    //
    // }
    // window.onload

    // document.getElementsByClassName("summerNote").innerHTML = String;

    document.getElementsByClassName("summerNote").onload = function() {myFunction()};

    function myFunction() {
        var text = document.getElementsByClassName("summerNote");
        document.getElementsByClassName("summerNote").innerHTML = text;
    }


</script>
</body>
</html>
