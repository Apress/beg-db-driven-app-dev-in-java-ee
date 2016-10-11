package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import ejbjpa.entities.*;
@Stateless
public class OrderBean implements OrderSample {
    @PersistenceContext
    private EntityManager em;
    public void placeOrder(Integer cust_id,
                           Integer empno) {
        try {
            Customer cust = (Customer) em.find(Customer.class, cust_id);
            Employee emp = (Employee) em.find(Employee.class, empno);
            Order order = new Order();
            order.setCustomer(cust);
            order.setEmployee(emp);
            em.persist(order);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    public List<Order> getOrdersList() {
     List<Order> orders = null;
        try {
          orders = (List<Order>)em.createQuery("SELECT o FROM Order o")
                       .getResultList(); 
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
      return orders;
    }
}
