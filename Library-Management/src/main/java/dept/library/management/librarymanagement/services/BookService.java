package dept.library.management.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dept.library.management.librarymanagement.entities.Book;
import dept.library.management.librarymanagement.entities.IssuedBook;
import dept.library.management.librarymanagement.repositories.BookRepository;
import dept.library.management.librarymanagement.repositories.IssuedBookRepository;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    @Autowired
    IssuedBookRepository issuedBookRepository;

    public void addBooks(Book book){
        Book data = bookRepository.findByIsbn(book.getIsbn());
        Integer count = book.getNumber_of_books();
        if (data != null){
            book.setNumber_of_books(data.getNumber_of_books() + count);
            book.setId(data.getId());
            book.setBooks(data.getBooks());
        }
        for(int i = 0; i < count; i++){
            book.getBooks().add(new IssuedBook());
        }
        bookRepository.save(book);
    }

    public void removeBook(Book book){
        for(IssuedBook b : book.getBooks()){
            if (issuedBookRepository.existsById(b.getLibrary_id())){
                Long book_id = issuedBookRepository.getById(b.getLibrary_id()).getBook_id();
                Book data = bookRepository.getById(book_id);
                issuedBookRepository.deleteById(b.getLibrary_id());
                data.setNumber_of_books(data.getNumber_of_books()-1);
                bookRepository.save(data);
                if (data.getNumber_of_books() == 0){
                    bookRepository.delete(data);
                }
            }
        }
    }
}
