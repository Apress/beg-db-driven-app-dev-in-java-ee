package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

import ejbjpa.entities.*;
@Stateless
public class OrderTestBean implements OrderTest {
    @PersistenceContext(unitName="contaneremtest1-pu")
    private EntityManager em1;
    @PersistenceContext(unitName="contaneremtest2-pu")
    private EntityManager em2;
    //
    @Resource
    private SessionContext ctx;
    //
    public Integer setOrder(Integer cust_id, Integer empno) {
        Integer order_pono;
        try {
          Customer cust = (Customer) em1.find(Customer.class, cust_id);
          Employee emp = (Employee) em1.find(Employee.class, empno);
          Order order1 = new Order();
          order1.setCustomer(cust);
          order1.setEmployee(emp);
          em1.persist(order1);
          em1.flush();
          em1.refresh(order1);
          order_pono = order1.getPono();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_pono;
    }
    public String changeOrderEmpTest(Integer pono, Integer empno, Integer custid) {
        String order_details;
        try {
          //finds the order
          Order order1 = (Order) em1.find(Order.class, pono);
          //shows the original order
          order_details = "order "+ order1.getPono()+ " emp: " + order1.getEmployee().getLastname()+" cust: " + order1.getCustomer().getCust_name()+"<br/>";
          //updates order1 and synchronize it to the database
          Employee emp = (Employee) em1.find(Employee.class, empno);
          order1.setEmployee(emp);
          em1.flush();
          em1.refresh(order1);
          //shows the change in order1 obtained from the database
          order_details = order_details+"order "+ order1.getPono()+ " emp: " + order1.getEmployee().getLastname()+" cust: " + order1.getCustomer().getCust_name()+"<br/>";
          //obtains the same order with the other EntityManager
          Order order2 = (Order) em2.find(Order.class, pono);
          //change order2 and synchronize it to the database
          Customer cust = (Customer) em1.find(Customer.class, custid);
          order2.setCustomer(cust);
          em2.flush(); 
          em2.refresh(order2);
          //shows the change in order2 obtained from the database
          order_details = order_details+"order "+ order2.getPono()+ " emp: " + order2.getEmployee().getLastname()+" cust: " + order2.getCustomer().getCust_name()+"<br/>";
          //
          ctx.setRollbackOnly(); 
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_details;
    }
}
