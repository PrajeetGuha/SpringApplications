package dept.library.management.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dept.library.management.librarymanagement.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    
    @Query(value = "CALL ADD_BOOKS(:isbn,:bookName,:author,:publisher,:year,:number_of_books);",nativeQuery = true)
    void addBooks(Long isbn, String bookName, String author, String publisher, Integer year, Integer number_of_books);
}
