import javax.ejb.Stateful;

@Stateful
public class BuyingManager {

    private int funds = 0;

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public String buyTicket(Seat seat){
        if(seat.getPrice()<=funds) {
            String msg = SeatManager.getInstance().buySeat(seat);
            if(msg.equals("OK"))funds-=seat.getPrice();
            return msg;
        }
        else return "Brak funduszy";
    }


}
