package ejbjpa.ejb;
import java.util.Date;

import javax.ejb.Remote;
@Remote
public interface OrderTest  {
   public String[] setOrder(Integer cust_id, Integer empno, Date shipping_date, String delivery_estimate);
}
