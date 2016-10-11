package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import ejbjpa.entities.*;

@Stateless
public class CustSessionBean implements CustSession {
    @PersistenceUnit(unitName = "cust-pu")
    private EntityManagerFactory emf;
    public Integer getCustId(String company_name) 
    {
     Integer cust_id;
        try {
            EntityManager em = emf.createEntityManager();
            Customer customer = (Customer) em.createQuery("SELECT c FROM Customer c WHERE c.company_name LIKE :company_name")
                             .setParameter("company_name", company_name)
.getSingleResult();   
            cust_id = customer.getCust_id();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
      return cust_id;
    }
}