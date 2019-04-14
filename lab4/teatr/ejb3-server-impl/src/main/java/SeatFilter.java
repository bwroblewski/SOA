import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class SeatFilter {
    public List<Seat> filter (List<Seat> list){
        List<Seat> ret =  new ArrayList<Seat>();
        for(Seat v: list) if(!v.isTaken()) ret.add(v);
        return ret;
    }
}
