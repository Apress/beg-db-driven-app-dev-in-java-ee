package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import ejbjpa.entities.*;

@Stateless
public class CustomerSessionBean implements CustomerSession {
    @PersistenceUnit(unitName = "ejbjpa-relation-pu")
    private EntityManagerFactory emf;
    public String getCustomerAddress(Integer cust_id) {
        String cust_address;
        try {
            EntityManager em = emf.createEntityManager();
            Customer cust = em.find(Customer.class, cust_id);
            cust_address = cust.getAddress().getStreet()+", "+
                           cust.getAddress().getCity()+", "+
                           cust.getAddress().getState()+", "+
                           cust.getAddress().getZipcode();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return cust_address;
    }
}