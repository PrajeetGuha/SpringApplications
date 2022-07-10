package dept.library.management.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dept.library.management.librarymanagement.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
}
