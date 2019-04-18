import javax.persistence.*;

@Entity
@Table(name = "reader")
public class Reader implements Item{

    @Id
    @GeneratedValue
    @Column(name = "id",unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void update(Item obj) {
        Reader n = (Reader)obj;
        this.name=n.name;
        this.surname = n.surname;
    }

}
