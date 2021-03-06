package com.jason.service;

import com.jason.model.Book;

import java.util.List;

public interface IBookService {
    /**獲得所有圖書*/
    public List<Book> getAllBooks();
    /**獲得單個圖書對象通過編號*/
    public Book getBookId(int id);
    /**添加*/
    public int add(Book entity);
    /**編輯*/
    public int edit(Book entity);
    /**刪除*/
    public int delete(int id);
}
