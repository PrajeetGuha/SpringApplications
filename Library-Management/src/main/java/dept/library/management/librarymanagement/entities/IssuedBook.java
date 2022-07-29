package dept.library.management.librarymanagement.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "IssuedBooks")
public class IssuedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "issuedbooks_seq")
    @SequenceGenerator(name = "issuedbooks_seq", initialValue = 1)
    @Column(name = "library_id")
    private Long library_id;

    @Column(name = "book_id")
    private Long book_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "borrowing_date")
    private Date borrowing_date;

    @Column(name = "return_date")
    private Date return_date;

    public Long getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(Long library_id) {
        this.library_id = library_id;
    }

    public Date getBorrowing_date() {
        return borrowing_date;
    }

    public void setBorrowing_date(Date borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

}
