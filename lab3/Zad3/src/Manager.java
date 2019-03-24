import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.*;

@ManagedBean(name = "Manager")
@SessionScoped
public class Manager {

    private Map<String,String[]> brands = new HashMap<String, String[]>(){{
        String [] arr = {"Astra","Corsa"};
        put("Opel",arr);
        arr = new String[]{"Focus", "Mondeo", "Fiesta"};
        put("Ford",arr);
    }};

    private List<String[]> cars = new ArrayList<String[]>(){{
        String [] arr;
        arr = new String[]{"Opel", "Corsa", "13000","benzyna"};
        add(arr);
        arr = new String[]{"Opel", "Corsa", "15000","ON"};
        add(arr);
        arr = new String[]{"Opel", "Corsa", "12000","benzyna"};
        add(arr);
        arr = new String[]{"Opel", "Corsa", "12500","benzyna"};
        add(arr);
        arr = new String[]{"Opel", "Astra", "20000","benzyna"};
        add(arr);
        arr = new String[]{"Opel", "Astra", "21000","benzyna"};
        add(arr);
        arr = new String[]{"Opel", "Astra", "18000","ON"};
        add(arr);
        arr = new String[]{"Opel", "Astra", "25000","ON"};
        add(arr);
        arr = new String[]{"Opel", "Astra", "23000","ON"};
        add(arr);
        arr = new String[]{"Ford", "Focus", "17000","ON"};
        add(arr);
        arr = new String[]{"Ford", "Focus", "17500","benzyna"};
        add(arr);
        arr = new String[]{"Ford", "Focus", "16000","benzyna"};
        add(arr);
        arr = new String[]{"Ford", "Fiesta", "19000","ON"};
        add(arr);
        arr = new String[]{"Ford", "Fiesta", "18000","benzyna"};
        add(arr);
        arr = new String[]{"Ford", "Fiesta", "17000","ON"};
        add(arr);
        arr = new String[]{"Ford", "Mondeo", "27500","benzyna"};
        add(arr);
        arr = new String[]{"Ford", "Mondeo", "30000","benzyna"};
        add(arr);
        arr = new String[]{"Ford", "Mondeo", "29000","ON"};
        add(arr);
        arr = new String[]{"Ford", "Mondeo", "28000","benzyna"};
        add(arr);

    }};

    private List<String[]> filtered = new ArrayList<String[]>();

    public List<String[]> getFiltered() {
        return filtered;
    }

    public Map<String, String[]> getBrands() {
        return brands;
    }

    public void setBrands(Map<String, String[]> brands) {
        this.brands = brands;
    }

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String[] models ;

    public String[] getModels() {
        return models;
    }

    public void setModels(String[] models) {
        this.models = models;
    }

    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String min;

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    private String max;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    private String engine;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void changeBrand(){
        this.models = brands.get(brand);
    }

    public String filter(){
        filtered = new ArrayList<String[]>();
        for( String[] v: this.cars){
            Integer nmin = Integer.parseInt(min);
            Integer nmax = Integer.parseInt(max);
            if(v[0].equals(brand) && v[1].equals(model) && v[3].equals(engine) ){
                Integer val = Integer.parseInt(v[2]);
                if(val < nmax && val > nmin) filtered.add(v);
            }
        }

        return new String();
    }


}

