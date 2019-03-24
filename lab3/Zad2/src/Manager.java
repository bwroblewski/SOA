import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name  = "Manager")
@SessionScoped
public class Manager {

    private String newcurrency;

    public String getNewcurrency() {
        return newcurrency;
    }

    public void setNewcurrency(String newcurrency) {
        this.newcurrency = newcurrency;
    }

    private String wynik;

    public String getWynik() {
        return wynik;
    }


    private Map<String,String> currmap = new HashMap<String,String>() {{
        put("PLN","1");
        put("EUR",NBPConnector.exchangeRate("EUR"));
    }};

    public Map<String, String> getCurrmap() {
        return currmap;
    }

    private String select1;

    public String getSelect1() {
        return select1;
    }

    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    private String select2;

    public String getSelect2() {
        return select2;
    }

    public void setSelect2(String select2) {
        this.select2 = select2;
    }

    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String calculate(){
        Float v1 = Float.parseFloat(currmap.get(select1));
        Float v2 = Float.parseFloat(currmap.get(select2));
        wynik = (Float.parseFloat(amount)*v1/v2) + "";
        return "wynik";
    }

    public String addCurrency(){

        if(!currmap.containsKey(newcurrency)){
            String val = NBPConnector.exchangeRate(newcurrency);
            if (val!=null) {
                currmap.put(newcurrency,val);
            }
        }
        return "dodaj";
    }
}
