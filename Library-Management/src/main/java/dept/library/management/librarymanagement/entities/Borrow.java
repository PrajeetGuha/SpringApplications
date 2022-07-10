package dept.library.management.librarymanagement.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Borrow {
    
    @Id
    @Column(name = "library_id")
    private String library_id;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "borrower_id")
    private Long borrower_id;

    @Column(name = "borrowing_date")
    private Date borrowing_date;

    public String getLibrary_id() {
        return library_id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public Long getBorrower_id() {
        return borrower_id;
    }

    public Date getBorrowing_date() {
        return borrowing_date;
    }

    
}
