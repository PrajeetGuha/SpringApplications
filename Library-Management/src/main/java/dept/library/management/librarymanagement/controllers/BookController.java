package dept.library.management.librarymanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dept.library.management.librarymanagement.entities.Book;
import dept.library.management.librarymanagement.repositories.BookRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    
    @PostMapping("/add")
    public void addBooks(@RequestBody Book book) {
        bookRepository.addBooks(book.getIsbn(),book.getBookName(),book.getAuthor(),book.getPublisher(),book.getYear(),book.getNumber_of_books());
    }
}
