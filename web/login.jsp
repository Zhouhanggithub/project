<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/9
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="BMS/js/index.js"></script>
<script>
    //为登录和注册增加表单提交
    $("button-container").click(function () {
        document.getElementById("userForm").submit();
    });
</script>
<div class="container">
    <div class="card"></div>
    <div class="card">
        <h1 class="title">登录</h1>
        <div class="close" style="margin-le: 500px;"></div>
        <form action="${pageContext.request.contextPath}/userServlet?M=login" method="post" id="userForm">
            <div class="input-container">
                <input type="text"  id="username" name="username" required=" " />
                <label for="username">用户名</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="password" id="password" name="password" required="required" />
                <label for="password">密码</label>
                <div class="bar"></div>
            </div>
            <div class="button-container">
                <button><span>Go</span></button>
            </div>
            <div class="footer">
                <a href="#">忘记密码?</a>
            </div>
        </form>
    </div>
    <div class="card alt">
        <div class="toggle"></div>
        <h1 class="title">注册
            <div class="close"></div>
        </h1>
        <form action="${pageContext.request.contextPath}/userServlet?M=register" method="post">
            <div class="input-container">
                <input type="text" id="reUsername" name="reUsername"required="required" />
                <label for="reUsername">用户名</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="password" id="rePassword" name="rePassword" required="required" />
                <label for="rePassword">密码</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="password" id="rePasswordQ" name="rePasswordQ"  required="required" />
                <label for="rePasswordQ">确认密码</label>
                <div class="bar"></div>
            </div>
            <div class="button-container">
                <button><span>Next</span></button>
            </div>
        </form>
    </div>
</div>

