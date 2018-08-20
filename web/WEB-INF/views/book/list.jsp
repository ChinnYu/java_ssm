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
    <table width="100%" id="tab" border="1">
        <tr>
            <td>編號</td>
            <td>書名</td>
            <td>類型</td>
            <td>價格</td>
            <td>狀態</td>
            <td>操作</td>
        </tr><!--books來自controller,需名字一樣-->
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.book_Id}</td>
                <td>${book.book_title}</td>
                <td>${book.book_typename}</td>
                <td>${book.book_price}</td>
                <td>${book.book_state}</td>
                <td><a href="#">刪除</a> | <a href="#">編輯</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
