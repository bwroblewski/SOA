
import javax.jms.*;

public class Listener implements MessageListener{
    public void onMessage(Message m) {
        try{
            TextMessage msg=(TextMessage)m;

            System.out.println("Otrzymałem:"+msg.getText());
        }catch(JMSException e){System.out.println(e);}
    }
}
