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
    @PersistenceUnit(unitName = "jpaplanning-view-pu")
    private EntityManagerFactory emf;
    public String getCustomerDetails(Integer cust_id) {
        String cust_details;
        try {
            EntityManager em = emf.createEntityManager();
            Customer cust = em.find(Customer.class, cust_id);
            cust_details = cust.getCompany_name()+", "+
                           cust.getPhone()+", "+
                           "address is: "+" "+
                           cust.getStreet()+", "+
                           cust.getCity()+", "+
                           cust.getState()+", "+
                           cust.getZipcode();                           
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return cust_details;
    }
}