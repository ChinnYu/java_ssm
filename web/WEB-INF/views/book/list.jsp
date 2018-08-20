<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/8/20
  Time: 下午 03:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>圖書管理</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h2>圖書管理</h2>
    <form action="dels" method="post">
        <table width="100%" id="tab" border="1">
            <tr>
                <td><input type="checkbox" id="chbAll"/></td>
                <td>編號</td>
                <td>書名</td>
                <td>類型</td>
                <td>價格</td>
                <td>狀態</td>
                <td>操作</td>
            </tr><!--books來自controller,需名字一樣-->
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><input type="checkbox" name="id" value="${book.book_Id}"/></td>
                    <td>${book.book_Id}</td>
                    <td>${book.book_title}</td>
                    <td>${book.book_typename}</td>
                    <td>${book.book_price}</td>
                    <td>${book.book_state}</td>
                    <td><a href="del/${book.book_Id}" class="del">刪除</a> | <a href="#">編輯</a></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="刪除選擇項" class="del"/>
    </form>

    <p>
        ${msg}
    </p>
    <script src="<c:url value="/js/jquery.min.js"></c:url>"></script>
    <script>
        $(".del").click(function () {
            return confirm("您確定要刪除嗎?");
        });

        //全選和反選
        $("#chbAll").change(function () {
            $("input[name=id]").prop("checked",$(this).prop("checked"))
        });

        var msg = '${msg}';
        if(msg){
            alert(msg);
        }
    </script>
</body>
</html>
