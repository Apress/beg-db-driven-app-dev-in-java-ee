package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface CustomerSession  {
   public String getCustomerDetails(Integer cust_address_id);
}
