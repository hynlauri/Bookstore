package hh.sof03.bookstore.web;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    // Method to get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    // Method to get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }
}


