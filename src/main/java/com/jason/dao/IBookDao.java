package com.jason.dao;

import com.jason.model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**圖書資料訪問介面*/
public interface IBookDao {
    /**獲得所有圖書*/
    @Select("select book_Id, book_title, book_typename, book_price, book_state from www_book")
    public List<Book> getAllBooks();
    /**獲得單個圖書對象通過編號*/
    @Select("select book_Id, book_title, book_typename, book_price, book_state from www_book where book_Id=#{book_Id}")
    public Book getBookId(int id);
    /**添加*/
    @Insert("insert into www_book (book_Id, book_title, book_typename, book_price, book_state) values (NULL,#{book_title}, #{book_typename}, #{book_price}, #{book_state})")
    public int add(Book entity);
    /**編輯*/
    @Update("update www_book set book_title=#{book_title},book_typename=#{book_typename},book_price=#{book_price},book_state=#{book_state} where book_Id=#{book_Id}")
    public int edit(Book entity);
    /**刪除*/
    @Delete("delete from www_book where book_Id=#{id}")
    public int delete(int id);

}
