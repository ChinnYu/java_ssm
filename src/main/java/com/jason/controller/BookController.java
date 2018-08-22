package com.jason.controller;

import com.jason.model.Book;
import com.jason.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * @program: ssm
 * @description: 圖書控制器
 * @author: Liu
 * @create: 2018-08-20
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    IBookService bookService;

    @RequestMapping("/list")
    public String list(Model model){
        //獲得所有的圖書帶到頁面中
        model.addAttribute("books",bookService.getAllBooks());
        return "book/list";
    }

    @RequestMapping("/del/{id}")
    public String del(Model model, @PathVariable int id, RedirectAttributes flash){
        //執行刪除，如果影響行行數大於0,則成功
        if(bookService.delete(id)>0){
            flash.addFlashAttribute("msg","刪除成功");
        }else{
            flash.addFlashAttribute("msg","刪除失敗");
        }
        //重定向
        return "redirect:/book/list";
    }
    @RequestMapping("/dels")
    public String dels(Model model, @RequestParam(value = "id",required = false) int[] ids, RedirectAttributes flash){
        if(ids!=null){
            //執行刪除，如果影響行行數大於0,則成功
            int rows = bookService.delete(ids);
            if(rows > 0){
                flash.addFlashAttribute("msg","刪除成功"+rows+"行");
            }else{
                flash.addFlashAttribute("msg","刪除失敗");
            }
        }
        else{
            flash.addFlashAttribute("msg","刪除失敗");
        }
        //重定向
        return "redirect:/book/list";
    }
    //添加
    @RequestMapping("/add")
    public String add(Model model){
        return "book/add";
    }

    @RequestMapping("/addSave")
    public String add(Model model, Book book, RedirectAttributes flash){
        if(bookService.add(book) > 0){
            System.out.println(book.getBook_typename());
            flash.addFlashAttribute("msg","添加成功");
            return "redirect:/book/list";
        }else{
            flash.addFlashAttribute("msg","添加失敗");
            flash.addFlashAttribute("book",book);
            return "redirect:/book/add";
        }
    }

    //編輯
    @RequestMapping("/edit")
    public String edit(Model model,int id){
        //將要編輯的圖書物件帶入視圖
        model.addAttribute("book",bookService.getBookId(id));
        return "book/edit";
    }
    //編輯保存
    @RequestMapping("/editSave")
    public String edit(Model model, Book book, RedirectAttributes flash){
        if(bookService.edit(book) > 0){
            System.out.println(book.getBook_typename());
            flash.addFlashAttribute("msg","更新成功");
            return "redirect:/book/list";
        }else{
            flash.addFlashAttribute("msg","更新失敗");
            flash.addFlashAttribute("book",book);
            return "redirect:/book/edit";
        }
    }

}
