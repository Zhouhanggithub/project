<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/8
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<script src="BMS/js/main.js"></script>
<script>
    //分页设置
    var dataItemNum  = ${pageConfig.initDataNum}; //每页显示多少数据
    var pageNum = ${pageConfig.initPageNum};  //每次显示多少页
    var dataCount = ${bookListSize};  //数据总数
    var pageCount = Math.ceil(dataCount/dataItemNum); //总页数
    var currentPage = 1;

    function dataItemNumChange(currentDataItemNum){
        if(currentDataItemNum  >  100){
            alert("error-每页显示数据过多");
            return;
        }
        currentPage = $("#pageCurrent").html();
        currentPageNum = $("#pageNum").html();
        pageCount = Math.ceil(dataCount/currentDataItemNum);
        $("#pageCount").html(pageCount);
        for(var i = 0 ;i < pageCount;i++){
            var _obj = $(document.createElement('option')).html(i+1).val(i+1);
            $("#pageNumSelect").append(_obj);
        }
        $("#demo").paginate({
            count: pageCount,
            start: currentPage,
            display: currentPageNum,
            border: false,
            text_color: '#79B5E3',
            background_color: 'none',
            text_hover_color: '#2573AF',
            background_hover_color: 'none',
            images: false,
            mouse: 'press'
        });

    }
    function pageNumChange(currentPageNum){
        if(currentPageNum > pageCount){
            alert("error-每次显示的页数大于总页数");
            return;
        }
        currentPage = $("#pageCurrent").html();
        $("#demo").paginate({
            count: pageCount,
            start: currentPage,
            display: currentPageNum,
            border: false,
            text_color: '#79B5E3',
            background_color: 'none',
            text_hover_color: '#2573AF',
            background_hover_color: 'none',
            images: false,
            mouse: 'press'

        });
    }
    function showBookList(){
        var currentPage = $("#pageCurrent").text();
        var currentDataItemNum = $("#dataItemNum").val();
        var afterNum =  currentDataItemNum*currentPage ;
        var beforeNum =  afterNum-currentDataItemNum;
        $.post("${pageContext.request.contextPath}/userOperationServlet",
            {
                M:"allBook",
                before : beforeNum+1,
                dataItemCont : currentDataItemNum
            },
            function (data) {
                $("#showBook").html(data);
            });
    }
    //初始化页面参数
    $(function() {
        $("#pageNum").val(pageNum);
        $("#dataItemNum").val(dataItemNum);
        $("#pageCount").html(pageCount);
        $("#pageCurrent").html(currentPage);
        for(var i = 0 ;i < pageCount;i++){
            var _obj = $(document.createElement('option')).html(i+1).val(i+1);
            $("#pageNumSelect").append(_obj);
        }
        $("#demo").paginate({
            count: pageCount,
            start: currentPage,
            display: pageNum,
            border: false,
            text_color: '#79B5E3',
            background_color: 'none',
            text_hover_color: '#2573AF',
            background_hover_color: 'none',
            images: false,
            mouse: 'press'
        });
        showBookList();
        $('#pageCurrent').bind('DOMNodeInserted', function(e) {
            showBookList();}
        );
    });

</script>
<form action="#">
    <div class="row">
        <div class="col-md-12">
            <div class="row" style="margin-left: auto;margin-top: 60px;margin-bottom: 60px">
                <div class="col-md-6 col-md-66">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="BookName">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Author">
                    </div>
                </div>
                <div class="col-md-6 col-md-66">
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary btn-md" value="搜一下">
                    </div>
                </div>
            </div>
        </div>

    </div>
</form>
<div class="fh5co-more-contact">
        <h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">所有图书</h2>
        <div class="row">
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">序号</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">书名</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">分类</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">作者</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">出版社</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">出版时间</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">单价</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">数量</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6" style="width: 11%;">
                <div class="fh5co-feature animate-box" data-animate-effect="fadeInLeft">
                    <div class="fh5co-icon">
                        <h4 style="position: absolute;margin-left: 35px;top: 5.1px;width: 80px;text-align: left;">查看</h4>
                    </div>
                </div>
            </div>
        </div>
        <div id="showBook">

        </div>
        <div style="clear: both;"></div>
        <div class="animate-box">
            <div id="demo" class="jPaginate">
                <div class="jPag-control-back">
                    <a class="jPag-first">First</a>
                    <span class="jPag-sprevious">«</span>
                </div>
                <div>
                    <ul class="jPag-pages"></ul>
                </div>
                <div class="jPag-control-front"><span class="jPag-snext">»</span>
                    <a class="jPag-last">Last</a>
                </div>
            </div>
            <span>
                    当前第<span id="pageCurrent"></span>页/共<span id="pageCount"></span>页,跳转
                    <select name="" id="pageNumSelect" ></select>
                    页,共<span id="dataCount">${bookListSize}</span>条记录
            </span>
            <div>
                <span class="fenye">
                    每次显示<input id="pageNum" type="text" value="" onchange="pageNumChange(this.value)"/>页,
                    每页显示<input id="dataItemNum"  type="text" value="" onchange="dataItemNumChange(this.value)"/>条,
                </span>
                <button type="button" class="prev" >上一页</button>
                <button type="button" class="next" >下一页</button>
            </div>
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