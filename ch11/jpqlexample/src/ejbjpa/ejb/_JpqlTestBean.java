package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import ejbjpa.entities.*;
@Stateless
public class JpqlTestBean implements JpqlTest {
    @PersistenceContext
    private EntityManager em;
    public List<Employee> getEmployees() {
    List<Employee> employees = null;
        try {
          Query query = em.createQuery("SELECT e FROM Employee e");
          employees = (List<Employee>)query.getResultList(); 
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return employees;
    }
}