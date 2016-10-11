package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
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
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return employees;
    }
}