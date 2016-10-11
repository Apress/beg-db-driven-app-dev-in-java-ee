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
    public String getCustomerDetails(Integer cust_address_id) {
        String cust_details;
        try {
            EntityManager em = emf.createEntityManager();
            Address addr = em.find(Address.class, cust_address_id);
            cust_details = addr.getCustomer().getCompany_name()+", "+
                           addr.getCustomer().getPhone()+", "+
                           "address id is "+" "+
                           addr.getCustomer().getAddress().getCust_address_id();                           
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return cust_details;
    }
}