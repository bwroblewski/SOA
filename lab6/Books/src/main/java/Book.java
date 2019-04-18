import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book implements Item{

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name="author")
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author_id) {
        this.author = author_id;
    }

    public void update(Item obj){
        Book n = (Book)obj;
        this.title=n.title;
        this.author = n.author;
    }
}
