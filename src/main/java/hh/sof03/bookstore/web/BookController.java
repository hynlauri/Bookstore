package hh.sof03.bookstore.web;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/booklist"; 
    }

    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/updatebook")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/booklist"; 
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/booklist";
    }
}

