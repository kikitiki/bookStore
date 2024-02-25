package com.bookStore.controller;


import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;
    @GetMapping("")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/avaliable_books")
    public ModelAndView getAllBook(){
        List<Book> list = bookService.getAllBooks();
//        ModelAndView modelAndView =new ModelAndView();
//        modelAndView.setViewName("Book list");
//        modelAndView.addObject("book",list);
        return  new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
            bookService.save(book);
            return "redirect:/avaliable_books";
    }
    @PostMapping("/saveAll")
    public String editBook(@ModelAttribute Book book){
        bookService.saveAllBook((List<Book>) book);
        return "redirect:/avaliable_books";
    }

//    @GetMapping("/my_books")
//    public String getMyBooks(Model model){
//        List<MyBookList> list =myBookListService.getAllMyBooks();
//        model.addAttribute("myBooks",list);
//        return "myBooks";
//    }

    @GetMapping("/my_books")
    public ModelAndView getMyBooks(){
        List<Book> list = bookService.getAllBooks();
        return  new ModelAndView("bookList","book",list);
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("myBooks", list);
        return "editBook";
    }




    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        bookService.deleteById(id);
        return "redirect:/avaliable_books";
    }
}
