<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/18
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="BMS/js/main.js"></script>
<script>
    $(function() {
        $.post("${pageContext.request.contextPath}/userOperationServlet",{
            M:"showStackRoom"
        }, function (data) {
            $("#showBook").html(data);
        });
    });


</script>
<div class="fh5co-more-contact">
    <h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">所有图书</h2>
    <div class="row">
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">序号</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">书名</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">分类</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">作者</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">出版社</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">出版时间</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">单价</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" style="width: 12%;">
            <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                <div class="fh5co-icon">
                    <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">操作</h4>
                </div>
            </div>
        </div>
    </div>
    <div id="showBook">

    </div>
    <div style="clear: both;"></div>
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