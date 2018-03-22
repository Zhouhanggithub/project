<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/8
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>图书管理 &mdash;新华电脑,办中国最好的职业教育</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
    <meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content="" />
    <meta property="og:image" content="" />
    <meta property="og:url" content="" />
    <meta property="og:site_name" content="" />
    <meta property="og:description" content="" />
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="BMS/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="BMS/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="BMS/css/bootstrap.css">
    <!-- Flexslider  -->
    <link rel="stylesheet" href="BMS/css/flexslider.css">
    <!-- Theme style  -->
    <link rel="stylesheet" href="BMS/css/style.css">
    <script type="text/javascript" src="BMS/js/ajaxrequest.js"></script>
    <!-- jQuery -->
    <script src="BMS/js/jquery.min.js"></script>
    <!-- jQuery Easing -->
    <script src="BMS/js/jquery.easing.1.3.js"></script>
    <!-- Bootstrap -->
    <script src="BMS/js/bootstrap.min.js"></script>
    <!-- Waypoints -->
    <script src="BMS/js/jquery.waypoints.min.js"></script>
    <!-- Flexslider -->
    <script src="BMS/js/jquery.flexslider-min.js"></script>

    <!-- MAIN JS -->
    <script src="BMS/js/main.js"></script>
    <!-- Modernizr JS -->
    <script src="BMS/js/modernizr-2.6.2.min.js"></script>
    <!--分页CSS/JS-->
    <script src="BMS/js/jquery.js"></script>
    <link rel="stylesheet" href="BMS/css/style.css" media="screen">
    <link rel='stylesheet prefetch' href='BMS/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='BMS/css/style_login.css'>
    <script>
        $(function(){
            //无论用户是否登录先添加点击特效
            $("#fh5co-main-menu ul li").click(function(){
                $(".fh5co-active").removeClass();
                $(this).addClass("fh5co-active");
            });
            //无论用户是否登录先加载右边主页面
            $("#fh5co-main").load("main.jsp");
            //无论用户是否登录welcome-选项点击后右边页面跳转主页面
            $("#welcome").click(function(){
                $("#fh5co-main").load("main.jsp");
            })
            //无论用户是否登录图书中心-选项点击后右边页面跳转相关页面
            $("#bookCentre").click(function(){
                $.post("userOperationServlet",{
                    M:"classify"
                },function (data) {
                    $("#fh5co-main").html(data);
                })
            });
            //我要借阅-选项点击后右边页面跳转处理用户操作的servlet
            $("#borrow").click(function(){
                $.post("userOperationServlet",{
                    M:"showBook"
                },function (data) {
                    $("#fh5co-main").html(data);
                })
            });

            //判断session是否有数据
            //如果有数据,表示用户session失效,左边侧栏应该更改对应信息和事件
            //只从请求域中获取user信息
            if(${!empty user}){
                //有session时以下选项才能执行对应操作
                //我的书库-选项点击后右边页面跳转显示已经借的书
                $("#myStackRoom").click(function(){
                    $.post("userOperationServlet",{
                        M:"stackRoom"
                    },function (data) {
                        $("#fh5co-main").html(data);
                    })
                });
                //个人信息设置-选项点击后右边页面跳转更改个人相关信息
                $("#personalInfoSet").click(function(){
                    alert("该模块暂未上线");
                });

                //如果用户已登录,增加注销登录选项(通过ajax,让对应的session失效)
                $("#logout").html("<strong></strong>注&nbsp;&nbsp;销&nbsp;&nbsp;登&nbsp;&nbsp;录").click(function () {
                    $.post("${pageContext.request.contextPath}/userServlet",{M:"logout"},function (){
                        //执行成功后刷新页面
                        location.reload();
                    });
                });
                //将右边登录按钮设置为欢迎词,同时删除掉对应操作事件
                $("#fh5co-logo").html("欢迎你回来</br><h3>${user.realName}</h3>");
                $("#fh5co-logo").removeAttr("data-toggle","data-target","class");

            }else{
                //无session时以下选项需要弹出登录框提示用户登录
                //我的书库-选项
                $("#myStackRoom").click(function(){
                    alert("请先登录");
                });
                //个人信息设置
                $("#personalInfoSet").click(function(){
                    alert("请先登录");
                });
            }
        })
    </script>
</head>
<body>
<div id="fh5co-page">
    <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
    <aside id="fh5co-aside" role="complementary" class="border js-fullheight">
        <h1 id="fh5co-logo" class="login" data-toggle="modal" data-target="#loginTips">未登录</h1>
        <nav id="fh5co-main-menu" role="navigation">
            <ul >
                <li id="welcome" class="fh5co-active"  >
                    <a href="#" style="font-size: 15px">Welcome</a>
                </li>
                <li id="bookCentre">
                    <a href="#" style="font-size: 15px">图书中心</a>
                </li>
                <li id="borrow">
                    <a href="#" style="font-size: 15px">我要借阅</a>
                </li>
                <li id="myStackRoom">
                    <a href="#" style="font-size: 15px">我的书库</a>
                </li>
                <li id="personalInfoSet">
                    <a href="#" style="font-size: 15px">个人信息设置</a>
                </li>
            </ul>
        </nav>
        <div class="fh5co-footer" style="position: absolute;top: 700px;font-size: 18px">
            <p>学生:16软件3班-陈继业</p>
            <p style="font-size: 30px">指导老师:<br>狂拽炫酷-<font style="font-size: 80px">郭奕</font></p>
        </div>
        <div class="fh5co-footer">
            <p style="font-size: 18px"><small>&copy; 2018 四川新华电脑学院。</small></p>
            <h1 id="logout" style="font-size: 25px;color: #D43F3A;"></h1>
        </div>
    </aside>
    <div id="fh5co-main">


    </div>
    <div class="modal fade" id="loginTips" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>
</div>
</body>

</html>