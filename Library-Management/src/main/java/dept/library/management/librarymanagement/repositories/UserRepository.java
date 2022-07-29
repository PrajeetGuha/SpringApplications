package dept.library.management.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import dept.library.management.librarymanagement.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    @Nullable
    User findByEmail(String email);
}
