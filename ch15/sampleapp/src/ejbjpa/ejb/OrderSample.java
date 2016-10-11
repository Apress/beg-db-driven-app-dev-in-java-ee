package ejbjpa.ejb;
import javax.ejb.Remote;
import java.util.List;
import ejbjpa.entities.*;

@Remote
public interface OrderSample  {
       public void placeOrder(Integer cust_id, Integer empno);
public List<Order> getOrdersList() ;

}
