import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;



@LocalBean
public class SeatManager {

    private static SeatManager ourInstance = new SeatManager();

    public static SeatManager getInstance() {
        return ourInstance;
    }

    private List<Seat> seatList;

    private int cols = 15;

    private int rows = 7;

    private SeatManager() {
        seatList = new ArrayList<Seat>();
            boolean taken;
            int price;
            for(int row = 1; row < rows; row++) {
               for (int col = 1; col < cols; col++) {
                   if (Math.random() < 0.35) taken = true;
                   else taken = false;
                   price = 100 - (int) Math.floor((double) (row / 3)) * 15;
                   seatList.add(new Seat(row, col, price, taken));
               }
           }
    }

    @Lock
    public List<Seat> getSeatList() {
        return seatList;
    }

    @Lock
    public String buySeat(Seat seat){
        for(Seat v: seatList){
            if(seat.getRow()==v.getRow() && seat.getCol() == v.getCol()){
                v.reserve();
                return "OK";
            }
        }
        return "Miejsce juz zajete";
    }
}
