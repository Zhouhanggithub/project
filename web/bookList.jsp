<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: MoMo
  Date: 2018/1/7
  Time: 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="BMS/js/main.js"></script>
<script>
    $("#bookAbout").load("bookAbout.jsp");
    $(".cat").click(function () {
        var bookName = $(this).parent().find(".bookName h4").html()
        var bookAuthor = $(this).parent().find(".bookAuthor h4").html()
        $("#bookBorrow ").html("<span>借阅</span>")
        $(".title").html(bookName);
        $("#bookAuthor").html(bookAuthor);
    });
</script>
<c:forEach items="${bookList}" var="book" varStatus="c">
    <div class="row fh5co-feature  animated fadeInUp"  style="animation-duration: 0.5s;">
        <div style="display:none" id="bookId">${book.bookId}</div>
        <div class="col-md-6" style="width: 11%;">
                <h4 style="position: absolute;top: 5.1px;width: 80px;text-align:center">${c.count}</h4>
        </div>
        <div class="col-md-6 bookName" style="width: 11%;">
            <div  >
                <h4 style="position: absolute;top: 5.1px;width: 200px;text-align:left">${book.bookName}</h4>
            </div>
        </div>
        <div class="col-md-6" style="width: 11%;">
            <div  >
                <h4 style="position: absolute;top: 5.1px;width: 80px;text-align:center">${book.bookCategory.bookCategoryName}</h4>
            </div>
        </div>
        <div class="col-md-6 bookAuthor" style="width: 11%;">
            <div   >
                <h4 style="position: absolute;top: 5.1px;width: 80px;text-align:center">${book.bookAuthor}</h4>
            </div>
        </div>
        <div class="col-md-6" style="width: 11%;">
            <div >
                <h4 style="position: absolute;top: 5.1px;width: 200px;text-align:left">${book.press}</h4>
            </div>
        </div>
        <div class="col-md-6" style="width: 11%;">
            <div  >
                <h4 style="position: absolute;top: 5.1px;width: 80px;text-align:center">${book.publishDate}</h4>
            </div>
        </div>
        <div class="col-md-6" style="width: 11%;">
            <div   data-animate-effect="fadeInLeft">
                <h4 style="position: absolute;top: 5.1px;width: 80px;text-align:center">${book.bookPrice}</h4>
            </div>
        </div>
        <div class="col-md-6" style="width: 11%;" >
            <div  data-animate-effect="fadeInLeft" >
                <h4 style="position: absolute;top: 5.1px;width: 80px;text-align:center">${book.bookNum}</h4>
            </div>
        </div>
        <div class="col-md-6 cat" style="width: 11%;" >
            <div  data-animate-effect="fadeInLeft" >
                <input type="button" id="select" class="btn btn-primary btn-md"  data-toggle="modal" data-target="#bookAbout" value="详情→" style="height: 40px;font-size: 18px">
            </div>
        </div>
    </div>
</c:forEach>
<div class="modal fade" id="bookAbout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>


