package ma.ilisi2.library.models.bo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "borrow_date")
    private LocalDateTime borrowDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    public Borrow() {
    }

    public Borrow(Integer id, Book book, User user, LocalDateTime borrowDate, String status, LocalDateTime returnDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.status = status;
        this.returnDate = returnDate;
    }

    public Borrow(Book book, User user, LocalDateTime borrowDate, String status, LocalDateTime returnDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.status = status;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}

