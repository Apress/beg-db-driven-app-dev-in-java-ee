package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import ejbjpa.entities.*;

@Stateless
public class OrderTestBean implements OrderTest {
    @PersistenceContext
    private EntityManager em;
    public String[] setOrder(Integer cust_id, Integer empno, Date shipping_date, String delivery_estimate) {
        String[] order_details = new String[2];
        try {
          Customer cust = (Customer) em.find(Customer.class, cust_id);
          Employee emp = (Employee) em.find(Employee.class, empno);
          Order order1 = new Order();
          order1.setCustomer(cust);
          order1.setEmployee(emp);
          order1.setShipping_date(shipping_date);
          order1.setDelivery_estimate(delivery_estimate);
          em.persist(order1);
          Date date = order1.getShipping_date();
          date = order1.getShipping_date();
          order_details[1] = date.toString();
          em.flush();
          em.refresh(order1);
          order_details[0] = order1.getPono().toString();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_details;
    }
}