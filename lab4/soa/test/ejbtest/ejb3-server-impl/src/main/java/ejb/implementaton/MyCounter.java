package ejb.implementaton;

import javax.ejb.Stateful;

@Stateful
public class MyCounter {
    public long counter = 0;


    public void increment(){
        counter++;
    }

    public long getCounter() {
        return counter;
    }
}
