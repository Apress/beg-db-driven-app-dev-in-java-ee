package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ejbjpa.entities.*;
@Stateless
public class PropagationTestBean implements PropagationTest {
    @PersistenceContext
    private EntityManager em;
    public void checkShoppingCart(Integer cart_id, String book_id) {
        try {
          ShoppingCart testcart = new ShoppingCart();
          testcart = (ShoppingCart) em.find(ShoppingCart.class, new ShoppingCartKey(cart_id, book_id));
          testcart.setUnits(testcart.getUnits()+1);
          em.merge(testcart);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}