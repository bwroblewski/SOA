package ejb.client;

import ejb.implementaton.MyAdd;
import ejb.implementaton.MyCounter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Manager")
@SessionScoped
public class Manager {

    @EJB
    MyCounter counter;

    int current;

    @EJB
    MyAdd add;

    private int sum = 0;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public long getCounter(){
     return counter.getCounter();
    }

    public String add(){
        counter.increment();
        sum = add.add(a,b);
        return new String();
    }

    public void submit(){}


}
