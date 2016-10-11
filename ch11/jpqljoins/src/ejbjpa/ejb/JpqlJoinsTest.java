package ejbjpa.ejb;
import javax.ejb.Remote;

@Remote
public interface JpqlJoinsTest  {
   public Integer[] countOrders(Integer empno);

}
