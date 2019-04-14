import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "Manager")
@SessionScoped
public class Manager {

    @EJB
    private BuyingManager buyingManager = new BuyingManager();


    private SeatManager seatManager  = SeatManager.getInstance();

    @EJB
    private SeatFilter seatFilter = new SeatFilter();

    private String errMsg = null;

    public Integer getFunds() {
        return buyingManager.getFunds();
    }

    public void setFunds(Integer funds) {
        this.buyingManager.setFunds(funds);
    }

    public List<Seat> getSeats(){
        return seatFilter.filter(seatManager.getSeatList());
    }

    public String bookSeat(Seat seat){
        String out = buyingManager.buyTicket(seat);
        if(out.equals("OK")){
            errMsg = null;
            return new String();
        }
        else {
            errMsg = out;
            return new String();
        }
    }

    public String getErrMsg() {
        return errMsg;
    }
}
