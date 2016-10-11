package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface CustSession  {
   public Integer getCustId(String company_name);
}