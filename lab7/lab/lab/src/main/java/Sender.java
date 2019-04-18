
import javax.naming.*;
import javax.jms.*;

public class Sender {
    public static void main(String[] args) {
        try { //Tworzenie połączenie z infrastruktura JMS
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();
            //2) tworzymy sesje
            QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            //3) dostep do kolejki
            Queue t = (Queue) ctx.lookup("SOA_TestQueue");
            QueueSender sender = ses.createSender(t);
            //5) Przygotowanie obiektu do wysyłki
            TextMessage msg = ses.createTextMessage();
            msg.setText("Ala ma kotka");
            //7) wysyłka komunikatu
            sender.send(msg);
            System.out.println("Komunikat wysłany.");
            //8) zamknięcie połączenia
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}