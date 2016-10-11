package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface EmployeeSession  {
   public String getEmplastname(Integer empno);
}
