package com.jason.controller;

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
}
