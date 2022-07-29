package dept.library.management.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dept.library.management.librarymanagement.entities.IssuedBook;

public interface IssuedBookRepository extends JpaRepository<IssuedBook,Long> {
    
}
