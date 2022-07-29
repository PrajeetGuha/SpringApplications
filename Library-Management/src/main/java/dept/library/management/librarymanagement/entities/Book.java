package dept.library.management.librarymanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_seq")
    @SequenceGenerator(name = "books_seq", initialValue = 1)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_name")
    private String bookName;
    
    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;
    
    @Column(name = "number_of_books")
    private Integer number_of_books;

    @JoinColumn(name = "book_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IssuedBook> issued_books;

    public Book() {
        this.issued_books = new ArrayList<IssuedBook>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber_of_books() {
        return number_of_books;
    }

    public void setNumber_of_books(Integer number_of_books) {
        this.number_of_books = number_of_books;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<IssuedBook> getBooks() {
        return issued_books;
    }

    public void setBooks(List<IssuedBook> issued_books) {
        this.issued_books = issued_books;
    }

    
}
