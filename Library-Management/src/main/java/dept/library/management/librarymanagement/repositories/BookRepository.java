package dept.library.management.librarymanagement.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import dept.library.management.librarymanagement.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
    
    Book findByIsbn(String isbn);
    Boolean existsByIsbn(String isbn);
}
