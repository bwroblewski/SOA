import java.util.*;

public class EkspertPiwny {
    Map<String,List<String>> piwa = new HashMap<String, List<String>>(){{
        put("jasne",new ArrayList<String>(){{
            add("EB");
            add("Tyskie");
            add("Żywiec");
        }});
        put("ciemne",new ArrayList<String>(){{
            add("Kozlak");
        }});
    }} ;

    List<String> getBrands(String colour){
        return piwa.get(colour);
    }

}
