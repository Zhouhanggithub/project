<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/8
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="BMS/js/main.js"></script>
<link rel='stylesheet prefetch' href='BMS/css/style_login.css'>
<script>
    //该页面被使用前加载好用户登录页面
    $("#loginTips").load("login.jsp");
    //为跳转图书中心的按钮增加单击事件
    $("#bookContre").click(function () {
            $(".fh5co-active").removeClass();
            $("#bookCentre").addClass("fh5co-active");
            $.post("userOperationServlet",{
                M:"classify"
            },function (data) {
                $("#fh5co-main").html(data);
            })
    })
</script>
<aside id="fh5co-hero" class="js-fullheight">
    <div class="flexslider js-fullheight">
        <ul class="slides">
            <li style="background-image: url(BMS/images/xhdm-x.jpg);">
                <div class="overlay"></div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center js-fullheight slider-text">
                            <div class="slider-text-inner">
                                <h1> <c:choose>
                                    <c:when test="${empty user}">
                                        Welcome
                                    </c:when>
                                    <c:when test="${!empty user}">
                                        ${user.realName}
                                    </c:when>
                                </c:choose> <strong></strong>欢迎使用新华图书管理系统</h1>
                                <c:choose>
                                    <c:when test="${empty user}">
                                        <h2>点击下方按钮开始使用 </h2>
                                            <p>
                                                <a class="btn btn-primary btn-demo popup-vimeo" id="bookContre"> <i class="icon-monitor"></i>不登录,继续使用</a>
                                                <a class="btn btn-primary btn-learn login" id="login"  data-toggle="modal" data-target="#loginTips">我要登陆 <i class="icon-arrow-right3"></i></a>
                                            </p>
                                    </c:when>
                                    <c:when test="${!empty user}">
                                        <h2>点击下方按钮开始使用 </h2>
                                            <p>
                                                <a class="btn btn-primary btn-demo popup-vimeo" id="bookContre"> <i class="icon-monitor"></i>进入图书中心</a>
                                            </p>
                                    </c:when>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                </div>
            </li>
            <li style="background-image: url(BMS/images/xhdm-z.jpg);">
                <div class="overlay"></div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center js-fullheight slider-text">
                            <div class="slider-text-inner">
                                <h1>本网站使用Bootstrap+Spring+SpringMVC+MyBatis框架开发</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</aside>
