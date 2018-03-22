<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/8
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="BMS/js/main.js"></script>
<script type="text/javascript">
    //为按钮添加查看更多的选项
    $(".lead").click(function(){
        $.post("${pageContext.request.contextPath}/userOperationServlet",{
            M:"datail", //datail 详情的意思
            bookCategoryName:$(this).parent().find("#bookCategoryName").html()
        },function (data) {
            $("#fh5co-main").html(data);
        })
    });
</script>
<div class="fh5co-narrow-content">
    <h1 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">图书中心-分类</h1>
    <div class="row row-bottom-padded-md">
        <c:forEach items="${allCategory}" var="category">
            <div class="col-md-3 col-sm-6 col-padding animate-box" data-animate-effect="fadeInLeft">
                <div class="blog-entry">
                    <a href="#" class="blog-img"><img src="${category.bookImgPath}" class="img-responsive" alt="Free HTML5 Bootstrap Template by FreeHTML5.co"></a>
                    <div class="desc">
                        <h2><a href="#" id="bookCategoryName">${category.bookCategoryName}</a></h2>
                        <span><small>by MoMo </small> / <small> 最近更新 </small> / <small> <i class="icon-comment"></i> ${category.updateTime}</small></span>
                        <p>${category.bookDis_1}</p>
                        <a href="#" class="lead">进入查看<i class="icon-arrow-right3"></i></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<div id="get-in-touch">
    <div class="fh5co-narrow-content">
        <div class="row">
            <div class="col-md-4 animate-box" data-animate-effect="fadeInLeft">
                <h1 class="fh5co-heading-colored">Mo Dei Le</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
                <p class="fh5co-lead">没有更多内容了.....</br>看到下面那个绿色框框的按钮没有,按一哈,就返回上头</p>
                <p>
                    <a href="#" class="btn btn-primary">I TMD is AnNiu</a>
                </p>
            </div>

        </div>
    </div>
</div>