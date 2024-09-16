package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
CommandLineRunner runner(BookRepository bookRepository) {
    return args -> {
        bookRepository.save(new Book("title", "author", 0, "123456789", 0));
        bookRepository.save(new Book("Title", "author", 0, "isbn", 0));
    };
}

}
