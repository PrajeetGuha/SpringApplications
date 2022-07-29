package dept.library.management.librarymanagement.services;

import java.sql.Date;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dept.library.management.librarymanagement.entities.IssuedBook;
import dept.library.management.librarymanagement.entities.User;
import dept.library.management.librarymanagement.objects.BookUser;
import dept.library.management.librarymanagement.repositories.BookRepository;
import dept.library.management.librarymanagement.repositories.IssuedBookRepository;
import dept.library.management.librarymanagement.repositories.UserRepository;

@Service
public class IssuedBookService {
    
    @Autowired
    IssuedBookRepository issuedBookRepository;

    @Autowired
    UserRepository userRepository;

    public void issue_books(BookUser bookUser){
        for(IssuedBook b : bookUser.getBooks_issued()){
            if (issuedBookRepository.existsById(b.getLibrary_id())){
                IssuedBook data = issuedBookRepository.getById(b.getLibrary_id());
                if (data.getUser_id() == null && userRepository.existsById(bookUser.getUser().getUser_id())){
                    data.setUser_id(bookUser.getUser().getUser_id());
                    data.setBorrowing_date(new Date(System.currentTimeMillis()));
                    data.setReturn_date(bookUser.getReturn_date());
                    issuedBookRepository.save(data);
                }
            }
        }
    }

    public HashMap<String,Long> return_books(BookUser bookUser){
        Long overdue = 0L;
        Long book_returned = 0L;
        if (userRepository.existsById(bookUser.getUser().getUser_id())){
            for(IssuedBook b : bookUser.getBooks_issued()){
                if(issuedBookRepository.existsById(b.getLibrary_id())){
                    IssuedBook book = issuedBookRepository.getById(b.getLibrary_id());
                    if (book.getUser_id() == bookUser.getUser().getUser_id()){
                        Date presentDate = new Date(System.currentTimeMillis());
                        if (book.getReturn_date().compareTo(presentDate) < 0){
                            overdue += ((presentDate.getTime() - book.getReturn_date().getTime()) / (1000*60*60*24)) % 365;
                        }
                        book.setBorrowing_date(null);
                        book.setReturn_date(null);
                        book.setUser_id(null);
                        issuedBookRepository.save(book);
                        book_returned += 1;
                    }
                }
            }
        }
        HashMap<String,Long> returnhash = new HashMap<>();
        returnhash.put("Total overdue days",overdue);
        returnhash.put("Books returned",book_returned);
        return returnhash;
    }
}
