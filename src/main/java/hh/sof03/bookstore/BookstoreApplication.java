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
        bookRepository.save(new Book("Moby dick", "Herman Melville", 1851, "0-393-09670-X", 13.00));
        bookRepository.save(new Book("Poika raidallisessa pyjamassa", "John Boyne", 2006, "0-385-60940-X", 8.90));
    };
}

}
