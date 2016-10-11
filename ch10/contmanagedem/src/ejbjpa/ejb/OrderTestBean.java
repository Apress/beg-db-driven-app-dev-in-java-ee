package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejbjpa.entities.*;
@Stateless
public class OrderTestBean implements OrderTest {
    @PersistenceContext(unitName="emejbtest-pu")
    private EntityManager em;
    @PersistenceContext(unitName="contaneremtest-pu")
    private EntityManager em2;

    public Integer setOrder(Integer cust_id, Integer empno) {
        Integer order_pono;
        try {
          Customer cust = (Customer) em.find(Customer.class, cust_id);
          Employee emp = (Employee) em.find(Employee.class, empno);
          Order order1 = new Order();
          order1.setCustomer(cust);
          order1.setEmployee(emp);
          em.persist(order1);
          em.flush();
          em.refresh(order1);
          order_pono = order1.getPono();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_pono;
    }
    public String changeOrderEmpTest(Integer pono, Integer empno) {
        String order_details;
        try {
          Employee emp = (Employee) em.find(Employee.class, empno);
          Order order1 = (Order) em.find(Order.class, pono);
          order1.setEmployee(emp);
          em.merge(order1);
          order_details = "order "+ order1.getPono()+ " placed via: " + order1.getEmployee().getLastname()+"<br/>";
          Order order2 = (Order) em2.find(Order.class, pono);
          order_details = order_details+"order "+ order2.getPono()+ " placed via: " + order2.getEmployee().getLastname()+"<br/>";
          order_details = order_details+"order "+ order1.getPono()+ " placed via: " + order1.getEmployee().getLastname();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_details;
    }
}