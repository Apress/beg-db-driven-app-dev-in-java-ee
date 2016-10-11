package ejbjpa.ejb;
import javax.ejb.Remote;
import java.util.List;
import ejbjpa.entities.*;

@Remote
public interface NativeQueryTest  {
   public List<Employee> getEmployees();
}
