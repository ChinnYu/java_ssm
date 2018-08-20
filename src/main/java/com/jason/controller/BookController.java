package com.jason.controller;

import com.jason.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: ssm
 * @description: 圖書控制器
 * @author: Liu
 * @create: 2018-08-20
 */
@Controller
@RequestMapping("/Book")
public class BookController {

    @Resource
    IBookService bookService;

    @RequestMapping("/list")
    public String list(Model model){
        //獲得所有的圖書帶到頁面中
        model.addAttribute("books",bookService.getAllBooks());
        return "book/list";
    }
}
