package hh.sof03.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        // Convert Iterable to List
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }
}
