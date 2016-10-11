package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import java.util.List;

import ejbjpa.entities.*;
@Stateless
public class OrderTestBean implements OrderTest {
    @PersistenceUnit(unitName="appemtest1-pu")
    private EntityManagerFactory emf;
    @PersistenceUnit(unitName="appemtest2-pu")
    private EntityManagerFactory emf2;
    @Resource
    UserTransaction utx;
    public Integer setOrder(Integer cust_id, Integer empno) {
        Integer order_pono;
        try {
          EntityManager em = emf.createEntityManager();
          Customer cust = (Customer) em.find(Customer.class, cust_id);
          Employee emp = (Employee) em.find(Employee.class, empno);
          Order order1 = new Order();
          order1.setCustomer(cust);
          order1.setEmployee(emp);
          em.getTransaction().begin();
          em.persist(order1);
          List orderList = em.createQuery("SELECT o FROM Order o")
                              .getResultList();   
          em.refresh(order1);
          em.flush();
          em.refresh(order1);
          order_pono = order1.getPono();
          em.getTransaction().commit();
          em.close();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_pono;
    }
    public String changeOrderEmpTest(Integer pono, Integer empno) {
        String order_details;
        try {
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          Employee emp = (Employee) em.find(Employee.class, empno);
          Order order1 = (Order) em.find(Order.class, pono);
          order1.setEmployee(emp);
          em.merge(order1);
          order_details = "order "+ order1.getPono()+ " placed via: " + order1.getEmployee().getLastname()+"<br/>";
          EntityManager em2 = emf2.createEntityManager();
          Order order2 = (Order) em2.find(Order.class, pono);
          order_details = order_details+"order "+ order2.getPono()+ " placed via: " + order2.getEmployee().getLastname()+"<br/>";
          em.getTransaction().commit();
          em2.refresh(order2);
          order_details = order_details+"order "+ order2.getPono()+ " placed via: " + order2.getEmployee().getLastname();
          em.close();
          em2.close();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return order_details;
    }
}