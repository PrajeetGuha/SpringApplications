package dept.library.management.librarymanagement.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dept.library.management.librarymanagement.entities.Book;
import dept.library.management.librarymanagement.entities.IssuedBook;
import dept.library.management.librarymanagement.objects.BookUser;
import dept.library.management.librarymanagement.objects.StatusCode;
import dept.library.management.librarymanagement.repositories.BookRepository;
import dept.library.management.librarymanagement.services.IssuedBookService;

@RestController
@RequestMapping("/issuedbook")
public class IssuedBookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    IssuedBookService issuedBookService;
    
    @PostMapping("/available")
    Object available(@RequestBody Book book){
        List<IssuedBook> available_books = new ArrayList<>();
        try{
            if (bookRepository.existsByIsbn(book.getIsbn())){
                for(IssuedBook b : bookRepository.findByIsbn(book.getIsbn()).getBooks()){
                    if(b.getUser_id() == null){
                        available_books.add(b);
                    }
                }
                HashMap<String,Object> returnhash = new HashMap<>();
                returnhash.put("isbn",book.getIsbn());
                returnhash.put("Available count",available_books.size());
                returnhash.put("Available",available_books);
                return returnhash;
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e){
            return new StatusCode(400, "Some error occured");
        }
    }

    @PostMapping("/issue")
    StatusCode issue(@RequestBody BookUser bookUser){
        try{
            issuedBookService.issue_books(bookUser);
            return new StatusCode(200, "Books successfully issued");
        }
        catch(Exception e){
            return new StatusCode(400, "Books are not issued");
        }
    }

    @PostMapping("/return")
    Object return_books(@RequestBody BookUser bookUser){
        try{
            return issuedBookService.return_books(bookUser);
        }
        catch(Exception e){
            return new StatusCode(400, "Books are not issued");
        }
    }
}
