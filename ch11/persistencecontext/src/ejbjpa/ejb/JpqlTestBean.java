package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Iterator;
import ejbjpa.entities.*;
@Stateless
public class JpqlTestBean implements JpqlTest {
    @PersistenceContext
    private EntityManager em;
    public List<Employee> getEmployees() {
        List<Employee> employees = null;
        try {
          employees = (List<Employee>)em.createQuery("SELECT e FROM Employee e")
                              .getResultList(); 
          Employee employee;
          Iterator i = employees.iterator();
          while (i.hasNext()) {
             employee = (Employee) i.next();
             if (!(em.contains(employee))) {
              throw new EJBException("PC does not contain this employee object");
             }
          }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return employees;
    }
   public boolean checkIfManaged(){
        List<Employee> employees = null;
        try {
          employees = (List<Employee>)em.createQuery("SELECT e FROM Employee e")
                              .getResultList(); 
          Employee employee;
          Iterator i = employees.iterator();
          while (i.hasNext()) {
             employee = (Employee) i.next();
             if (!em.contains(employee)) {
               return false;
              }          }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return true;
  }
}