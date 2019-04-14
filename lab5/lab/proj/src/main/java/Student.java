import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table( name = "student" )
public class Student implements Serializable {

        @Id
        @Column(name = "id", unique = true)
        private int id;

        @Column(name = "imie", nullable = false)
        private String imie;

        @Column(name = "nazwisko", nullable = false)
        private String nazwisko;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_at", nullable = false)
        private Date dodatnieData;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImie() {
            return imie;
        }

        public void setImie(String name) {
            this.imie = name;
        }

        public Date getDodatnieData() {
            return dodatnieData;
        }

        public void setDodatnieData(Date dodatnieData) {
            this.dodatnieData = dodatnieData;
        }

        @Override
        public String toString() {
            return id + "\t" + imie + "\t" + nazwisko + "\t" +  dodatnieData;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }
}