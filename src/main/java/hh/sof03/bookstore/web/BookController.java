package hh.sof03.bookstore.web;

import hh.sof03.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to the Bookstore");
        return "index";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "booklist";
    }
}

