import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name =  "Manager")
@SessionScoped
public class Manager {

    static int losuj = (int)(Math.random()*5 +1);

    private Integer[] numbers = {0,0,0,0,0};

    public Integer getNumtraf() {
        return numtraf;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

    private Integer numtraf = 0;


    public String wyslij(int number ){
            if (number == losuj){
                numtraf++;
                losuj = (int)(Math.random()*5 +1);
                return "trafiony";
            }
            else{
                numbers[number-1]++;
                return number + "";
            }
    }

}
