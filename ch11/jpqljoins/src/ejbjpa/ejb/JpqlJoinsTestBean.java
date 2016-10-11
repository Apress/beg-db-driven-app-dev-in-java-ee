package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import ejbjpa.entities.*;
@Stateless
public class JpqlJoinsTestBean implements JpqlJoinsTest {
    @PersistenceUnit(unitName="jpqljoins0-pu")
    private EntityManagerFactory emf0;
    @PersistenceUnit(unitName="jpqljoins1-pu")
    private EntityManagerFactory emf1;
    @PersistenceUnit(unitName="jpqljoins2-pu")
    private EntityManagerFactory emf2;
    public Integer[] countOrders(Integer empno){
        List<Order> orders0 = null;
        List<Order> orders1 = null;
        List<Order> orders2 = null;
        EntityManager em0 = emf0.createEntityManager();
        EntityManager em1 = emf1.createEntityManager();
        EntityManager em2 = emf2.createEntityManager();
        Integer[] numOfOrders= new Integer[3];
        try {
          //perform queries
          Employee employee0 = (Employee)em0.createQuery("SELECT e FROM Employee e WHERE e.empno=:empno")
                              .setHint("toplink.refresh", "true")
                              .setParameter("empno", empno)
                              .getSingleResult(); 
          Employee employee1 = (Employee)em1.createQuery("SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.orders WHERE e.empno=:empno")
                              .setHint("toplink.refresh", "true")
                              .setParameter("empno", empno)
                              .getSingleResult(); 

          Employee employee2 = (Employee)em2.createQuery("SELECT e FROM Employee e WHERE e.empno=:empno")
                               .setHint("toplink.refresh", "true")
                               .setParameter("empno", empno)
                               .getSingleResult(); 
          //count the number of orders for the employee retrieved with the first query
          orders0 = (List<Order>)employee0.getOrders();
          numOfOrders[0] = orders0.size();
          //increase the number of orders for the employee by 1 and commit the change
          Order order = new Order();
          order.setEmployee(employee0);
          em0.getTransaction().begin();
          em0.persist(order);
          em0.flush();
          em0.getTransaction().commit();
          //count the number of orders for the employee retrieved with the second and third queries
          orders1 = (List<Order>)employee1.getOrders();
          numOfOrders[1] = orders1.size();
          orders2 = (List<Order>)employee2.getOrders();
          numOfOrders[2] = orders2.size();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        em0.close();
        em1.close();
        em2.close();
        return numOfOrders;
  }
}