package com.jason.service;

import com.jason.dao.IBookDao;
import com.jason.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ssm
 * @description:
 * @author: Liu
 * @create: 2018-08-20
 */
@Service
public class BookService implements IBookService{

    @Autowired
    IBookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Book getBookId(int id) {
        return bookDao.getBookId(id);
    }

    public int add(Book entity) {
        return bookDao.add(entity);
    }

    public int edit(Book entity) {
        return bookDao.edit(entity);
    }

    public int delete(int id) {
        return bookDao.delete(id);
    }
}
