<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/8/22
  Time: 上午 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加圖書</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h2>添加圖書</h2>
    <form action="addSave" method="post">
        <fieldset>
            <legend>圖書詳細</legend>
            <p>
                <label for="title">書名</label>
                <input type="text" name="book_title" id="title" value="${book.book_title}"/>
            </p>
            <p>
                <label for="typename">類型：</label>
                <select name="book_typename" id="typename">
                    <option value="經濟">經濟</option>
                    <option value="文學">文學</option>
                    <option value="天文">天文</option>
                </select>
            </p>
            <p>
                <label for="price">價格：</label>
                <input type="text" name="book_price" id="price" value="${book.book_price}"/>
            </p>
            <p>
                <label for="state2">狀態：</label>
                <input type="radio" name="book_state" id="state1" value="已借出"/>已借出
                <input type="radio" name="book_state" id="state2" value="未借出"/>未借出
            </p>
            <p>
                <input type="submit" value="提交"/>
            </p>
        </fieldset>
    </form>
</body>
</html>
