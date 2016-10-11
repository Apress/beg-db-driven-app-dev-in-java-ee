package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface OrderTest  {
   public Integer setOrder(Integer cust_id, Integer empno);
   public String changeOrderEmpTest(Integer pono, Integer empno);
}
