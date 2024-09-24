package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return args -> {
            Category scifi = new Category("Sci-fi");
            Category comic = new Category("Comic");
            Category fantasy = new Category("Fantasy");
            categoryRepository.saveAll(Arrays.asList(scifi, comic, fantasy));
            
            Book[] books = {
                new Book("Moby Dick", "Herman Melville", 1851, "0-393-09670-X", 13.00, scifi),
                new Book("Poika raidallisessa pyjamassa", "John Boyne", 2006, "0-385-60940-X", 8.90, fantasy),
                new Book("Dune", "Frank Herbert", 1965, "978-0441013593", 12.50, scifi),
                new Book("Watchmen", "Alan Moore", 1986, "978-0930289232", 15.00, comic),
                new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0261102217", 10.00, fantasy)
            };

            bookRepository.saveAll(Arrays.asList(books));
        };
    }
}
