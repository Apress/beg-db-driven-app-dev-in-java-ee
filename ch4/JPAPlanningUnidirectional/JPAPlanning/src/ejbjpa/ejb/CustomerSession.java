package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface CustomerSession  {
   public String getCustomerAddress(Integer cust_id);
}
