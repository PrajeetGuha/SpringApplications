package dept.library.management.librarymanagement.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Book {
    
    @Id
    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "book_name")
    private String bookName;
    
    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "year")
    private Integer year;
    
    @Column(name = "number_of_books")
    private Integer number_of_books;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

}
