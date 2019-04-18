import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rental")
public class Rental implements Item{

    @Id
    @GeneratedValue
    @Column(name = "id",unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "reader", nullable = false)
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book", nullable = false)
    private Book book;

    @Column(name = "rental_date", nullable = false)
    private Date rentalDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader readerId) {
        this.reader = readerId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book bookId) {
        this.book = bookId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }


    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void update(Item obj) {
        Rental n = (Rental)obj;
        this.book =n.book;
        this.reader =n.reader;
        this.rentalDate=n.rentalDate;
        this.returnDate=n.returnDate;
    }

}
