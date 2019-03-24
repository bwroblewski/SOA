import com.sun.istack.internal.NotNull;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean( name = "Losowanie")
@SessionScoped
public class Losowanie {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    private String userage;

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    private String pesel;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String wyslij(){
        if(Math.random() < 0.2)
            return "OK";
        else
            return "NOT_OK";
    }
}
