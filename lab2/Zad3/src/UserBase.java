import java.util.Vector;

public class UserBase {
    Vector<Vector<String>> data = new Vector<Vector<String>>(){{
        add( new Vector<String>(){{
            add("Bartosz");
            add("Wroblewski");
            add("bartosz");
            add("password");
        }});
        add( new Vector<String>(){{
            add("Jan");
            add("Kowalski");
            add("jan");
            add("password");
        }});
        add( new Vector<String>(){{
            add("Janina");
            add("Kowalska");
            add("janina");
            add("password");
        }});
    }};

    Vector<String> getUser(String username){
        for (Vector<String> user: data){
            if (username.equals(user.get(2))) return user;
        }
        return null;
    }


}
