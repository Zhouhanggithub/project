<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/2
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>图书分类</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap-grid.min.css">
    <meta name="viewport" content="width=device-width,
                                     initial-scale=1.0,
                                     maximum-scale=1.0,
                                     user-scalable=no">
    <script src="bootstrap/js/jquery-3.0.0.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
欢迎你,${user.userName} 回来！<br>
<div style="text-align: center;" >
    <input type="text" name="search" style="width: 400px;height: 40px;font-size: 25px"><input type="button" value="搜他妈的一下" style="font-size: 25px">
</div>
<div style="text-align: center;">
    <table class="table table-hover">
        <caption>分类</caption>
        <tr>
            <th>序号</th>
            <th>书名</th>
            <th>数量</th>
            <th>跳转</th>
        </tr>

            <c:forEach items="${categoryList}" var="category" varStatus="c">
                <tr>
                    <td>${c.count}</td>
                    <td>${category.bookCategoryName}</td>
                    <td>${category.bookNum}</td>
                    <td><a href="${pageContext.request.contextPath}/categoryServlet?bookCategory=${category.bookCategoryName}">进入</a></td>
                </tr>
            </c:forEach>

    </table>
</div>
</body>
</html>
