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
    <title>編輯圖書</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h2>編輯圖書</h2>
    <form action="editSave" method="post">
        <fieldset>
            <legend>圖書詳細</legend>
            <p>
                <label for="title">書名</label>
                <input type="text" name="book_title" id="title" value="${book.book_title}"/>
            </p>
            <p>
                <label for="typename">類型：</label>
                <select name="book_typename" id="typename">
                    <option value="電腦" ${(book.book_typename).equals("電腦")?"selected='selected'":""}>電腦</option>
                    <option value="軟體工程" ${book.book_typename eq "軟體工程"?"selected='selected'":""}>軟體工程</option>
                    <option value="神話" ${book.book_typename=="神話"?"selected='selected'":""}>神話</option>
                    <option value="軟體發展" ${book.book_typename=="軟體發展"?"selected='selected'":""}>軟體發展</option>
                </select>
            </p>
            <p>
                <label for="price">價格：</label>
                <input type="text" name="book_price" id="price" value="${book.book_price}"/>
            </p>
            <p>
                <label for="state2">狀態：</label>
                <input type="radio" name="book_state" id="state1" value="已借出" ${book.book_state=="已借出"?"checked='checked'":""}/>已借出
                <input type="radio" name="book_state" id="state2" value="未借出" ${book.book_state=="未借出"?"checked='checked'":""}/>未借出
            </p>
            <p>
                <input type="hidden" name="book_Id" value="${book.book_Id}"/>
                <input type="submit" value="保存"/>
            </p>
        </fieldset>
    </form>
</body>
</html>
