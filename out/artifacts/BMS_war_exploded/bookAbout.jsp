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
    $("#bookBorrow ").click(function () {
        if(${empty user}){
            alert("请先登录");
        }else{
            var current = $(this);
            var bookName = $(".title").html();
            $.post("${pageContext.request.contextPath}/userOperationServlet",{
                M:"borrowBook",
                'bookName' : bookName
            },function (data){
                current.html("<span>借阅成功</span>");
                current.unbind("click");
            });
        }
    })
</script>
<div class="container">
    <div class="card"></div>
    <div class="card">
        <h1 class="title"></h1>
        <button type="button" class="btn btn-default" data-dismiss="modal" style="border:0px;position: absolute;left: 350px;top: 20px;font-size: 30px;">×</button>
        <div class="close" style="margin-le: 500px;"></div>
        <form>
            <div class="input-container">
                <h4>作者</h4>
                <p id="bookAuthor">某某某</p>
            </div>
            <div class="input-container">
                <h4>描述</h4>
                <p id="bookDisc">描述描述</p>
            </div>
            <div class="button-container" >
                <button id="bookBorrow" class="btn btn-default" data-dismiss="modal"><span>借阅</span></button>
            </div>
        </form>
    </div>
</div>

