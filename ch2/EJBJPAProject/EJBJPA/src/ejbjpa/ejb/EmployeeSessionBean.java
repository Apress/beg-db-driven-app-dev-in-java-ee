package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import ejbjpa.entities.*;

@Stateless
public class EmployeeSessionBean implements EmployeeSession {
    @PersistenceUnit(unitName = "ejbjpa-pu")
    private EntityManagerFactory emf;
    public String getEmplastname(Integer empno) {
        String fullname;
        try {
            EntityManager em = emf.createEntityManager();
            Employee emp = em.find(Employee.class, empno);
            fullname = emp.getFirstname()+" "+emp.getLastname();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return fullname;
    }
}