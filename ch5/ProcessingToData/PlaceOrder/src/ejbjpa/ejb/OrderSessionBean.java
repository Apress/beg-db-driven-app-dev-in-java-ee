package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import ejbjpa.entities.*;

@Stateless
public class OrderSessionBean implements OrderSession {
    @PersistenceUnit(unitName = "order-pu")
    private EntityManagerFactory emf;
    public void placeOrder(Integer pono, 
                           Integer cust_id,
                           Integer units,
                           String book_id) 
    {
        try {
            EntityManager em = emf.createEntityManager();
           // Book book = (Book) em.find(Book.class, book_id);
            Order order = new Order();
            order.setPono(pono);
            order.setCust_id(cust_id);
            order.setBook_id(book_id);
            order.setUnits(units);
           // book.setQuantity(book.getQuantity()-units);           
           //order.setBook(book);
            em.persist(order);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}