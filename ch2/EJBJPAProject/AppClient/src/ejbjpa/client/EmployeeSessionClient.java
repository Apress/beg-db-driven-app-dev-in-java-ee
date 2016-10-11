package ejbjpa.client;
 
import javax.ejb.EJB;
import ejbjpa.ejb.EmployeeSession;
public class EmployeeSessionClient {
      @EJB
      private static EmployeeSession employeeSession;
      public static void main (String[] args)
        {
            System.out.println(employeeSession.getEmplastname(10));
        }
}