package test.com.jason.service; 

import com.jason.model.Book;
import com.jason.service.BookService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BookService Tester. 
* 
* @author Liu 
* @since <pre>08/20/2018</pre> 
* @version 1.0 
*/ 
public class BookServiceTest { 
BookService service;
@Before
public void before() throws Exception {
    service = new BookService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAllBooks() 
* 
*/ 
@Test
public void testGetAllBooks() throws Exception {
    for (Book book:service.getAllBooks()) {
        System.out.println(book);
    }
    //System.out.println(service.getAllBooks());
} 

/** 
* 
* Method: getBookId(int id) 
* 
*/ 
@Test
public void testGetBookId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: add(Book entity) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: edit(Book entity) 
* 
*/ 
@Test
public void testEdit() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 


} 
