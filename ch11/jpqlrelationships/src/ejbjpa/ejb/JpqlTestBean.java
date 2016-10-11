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
        List<Order> orders = null;
        try {
          employees = (List<Employee>)em.createQuery("SELECT e FROM Employee e")
                              .getResultList(); 
          Employee employee;
          Order order;
          Iterator i = employees.iterator();
          Iterator j;
          while (i.hasNext()) {
             employee = (Employee) i.next();
             if (!em.contains(employee)) {
               return false;
             }
             orders = (List<Order>)employee.getOrders();
             j= orders.iterator();
             while (j.hasNext()) {
                  order = (Order) j.next();
                  em.remove(order);
                  if (!em.contains(order)) {
                    return false;
                  }
             }
          }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return true;
  }
}