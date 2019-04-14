package ejb.implementaton;

import javax.ejb.Stateless;

@Stateless
public class MyAdd {

    public int add(int a, int b){
        return a + b;
    }
}
