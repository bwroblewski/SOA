import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name  = "Manager")
@SessionScoped
public class Manager {

    private List<String[]> books = new ArrayList<String[]>(){{
        add(new String[]{"Book1","Author1","Romans" ,"30","PLN","300"});
        add(new String[]{"Book2","Author1","Wojenna" ,"10","EUR","300"});
        add(new String[]{"Book3","Author1","Kryminal" ,"50","PLN","300"});
        add(new String[]{"Book4","Author2","Wojenna" ,"20","USD","300"});
        add(new String[]{"Book5","Author2","Romans" ,"10","PLN","300"});
        add(new String[]{"Book6","Author2","Kryminal" ,"20","PLN","300"});
        add(new String[]{"Book7","Author3","Romans" ,"10","GBP","300"});
        add(new String[]{"Book8","Author3","Wojenna" ,"15","EUR","300"});
        add(new String[]{"Book9","Author4","Romans" ,"10","USD","300"});
        add(new String[]{"Book10","Author4","Kryminal" ,"25","PLN","300"});
        add(new String[]{"Book12","Author4","Kryminal" ,"8","GBP","300"});
    }};

    private List<String[]> filtered = books;

    public List<String[]> getFiltered() {
        return filtered;
    }

    private List<String[]> ordered = new ArrayList<String[]>();

    public List<String[]> getOrdered() {
        return ordered;
    }

    public void setOrdered(List<String[]> ordered) {
        this.ordered = ordered;
    }

    private String []  categories = {"Wojenna", "Romans", "Kryminal"};

    public String [] getCategories() {
        return categories;
    }

    private String[] checked = categories.clone();

    public String[] getChecked() {
        return checked;
    }

    public void setChecked(String[] checked) {
        this.checked = checked;
    }

    private boolean calc;

    public boolean isCalc() {
        return calc;
    }

    public void setCalc(boolean calc) {
        this.calc = calc;
    }

    private Map<String,Float> currencies = new HashMap<String, Float>(){{
        put("Dowolna", Float.parseFloat("1"));
        put("PLN", Float.parseFloat("1"));
        put("EUR",Float.parseFloat(NBPConnector.exchangeRate("EUR")));
        put("USD",Float.parseFloat(NBPConnector.exchangeRate("USD")));
        put("GBP",Float.parseFloat(NBPConnector.exchangeRate("GBP")));
    }};

    public Map<String, Float> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Float> currencies) {
        this.currencies = currencies;
    }

    private String currency = "Dowolna";

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private Integer min;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    private Integer max;

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    private boolean isDisplayed(String category){
        for(String v : checked){
            if(v.equals(category)) return true;
        }
        return false;
    }

    public String filter(){
        filtered = new ArrayList<String[]>();
        for (String[] v: books){
            if(currency.equals("Dowolna") || v[4].equals(currency))
                if(isDisplayed(v[2]))
                    if(min == null || Float.parseFloat(v[3])*currencies.get(v[4])>=min )
                        if (max == null || Float.parseFloat(v[3])*currencies.get(v[4])<=max) {
                            String[] entry = v.clone();
                            if(calc) {
                                entry[4] = "PLN";
                                entry[3] = (Float.parseFloat(v[3]) * currencies.get(v[4])) + "";
                            }
                            filtered.add(entry);
                        }
        }
        return new String();
    }

    public void add(String[] book){
        ordered.add(book);
    }

    public String order(){
        return "order";
    }

    public String summary(){
        Float sum  = new Float(0);
        for(String [] v:ordered) sum+= (Float.parseFloat(v[3]) * currencies.get(v[4]));
        return "Podsumowanie: \nIlosc sztuk: " + ordered.size() +"\n Cena razem: " + sum + " PLN";
    }
}


