package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return args -> {
            // Lisätään kategorioita
            Category scifi = new Category("Sci-fi");
            Category comic = new Category("Comic");
            Category fantasy = new Category("Fantasy");
            categoryRepository.save(scifi);
            categoryRepository.save(comic);
            categoryRepository.save(fantasy);
            
            // Lisätään kirjoja, jotka kuuluvat kategorioihin
            bookRepository.save(new Book("Moby Dick", "Herman Melville", 1851, "0-393-09670-X", 13.00, scifi));
            bookRepository.save(new Book("Poika raidallisessa pyjamassa", "John Boyne", 2006, "0-385-60940-X", 8.90, fantasy));
        };
    }
}
