package dept.library.management.librarymanagement.objects;

import java.sql.Date;
import java.util.List;

import dept.library.management.librarymanagement.entities.IssuedBook;
import dept.library.management.librarymanagement.entities.User;

public class BookUser {
    
    private User user;
    private List<IssuedBook> books_issued;
    private Date return_date;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<IssuedBook> getBooks_issued() {
        return books_issued;
    }
    public void setBooks_issued(List<IssuedBook> books_issued) {
        this.books_issued = books_issued;
    }
    public Date getReturn_date() {
        return return_date;
    }
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
    
}
