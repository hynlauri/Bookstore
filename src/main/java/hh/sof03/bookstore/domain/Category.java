package hh.sof03.bookstore.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity 
public class Category {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)  // Avain generoidaan automaattisesti
    private Long categoryid;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")  // Yhteys Book-luokkaan
    private List<Book> books;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }
}
