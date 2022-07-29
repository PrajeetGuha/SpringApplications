package dept.library.management.librarymanagement.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dept.library.management.librarymanagement.entities.Book;
import dept.library.management.librarymanagement.objects.StatusCode;
import dept.library.management.librarymanagement.repositories.BookRepository;
import dept.library.management.librarymanagement.repositories.IssuedBookRepository;
import dept.library.management.librarymanagement.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    IssuedBookRepository issuedBookRepository;

    @PutMapping("/update")
    StatusCode update(@RequestBody Book book){
        try{
            bookService.addBooks(book);
            return new StatusCode(200, "Books added successfully");
        }
        catch (Exception e){
            return new StatusCode(400, "Books cannot be added");
        }
    }

    @PostMapping("/fetch")
    Object fetch(@RequestBody Book book){
        try{
            return bookRepository.findByIsbn(book.getIsbn());
        }
        catch(Exception e){
            return new StatusCode(400, "Data fetching unsuccessful"); 
        }
    }

    @GetMapping("fetchall")
    Object fetchall(){
        try{
            return bookRepository.findAll();
        }
        catch(Exception e){
            return new StatusCode(400, "Some internal error occured"); 
        }
    }

    @GetMapping("/count")
    Object countBooks(){
        try{
            HashMap<String,Long> count = new HashMap<>();
            count.put("Total_number_of_unique_books",bookRepository.count());
            count.put("Total_number_of_books_issued",issuedBookRepository.count());
            return count;
        }
        catch(Exception e){
            return new StatusCode(400, "Some internal error occured");
        }
    }

    @DeleteMapping("/remove")
    StatusCode delete(@RequestBody Book book){
        try{
            bookService.removeBook(book);
            return new StatusCode(200, "Books are deleted successfully");
        }
        catch(Exception e){
            return new StatusCode(400, "Books deletion unsuccessful");
        }
    }
}
