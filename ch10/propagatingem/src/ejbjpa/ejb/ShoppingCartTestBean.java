package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import ejbjpa.entities.*;
@Stateless
public class ShoppingCartTestBean implements ShoppingCartTest {
    @PersistenceContext
    private EntityManager em;
    @EJB private PropagationTest test;
    public String[] setShoppingCart(Integer cart_id, String book_id, Integer units, Double unit_price) {
        String[] cart_details = new String[8];
        try {
          Book book = (Book) em.find(Book.class, book_id);
          ShoppingCart cart = new ShoppingCart();
          cart.setCart_id(cart_id);
          cart.setBook(book);
          cart.setUnits(units);
          cart.setUnit_price(unit_price);
          em.persist(cart);
          cart_details[0] = cart.getCart_id().toString();
          cart_details[1] = cart.getBook().getIsbn();
          cart_details[2] = cart.getUnits().toString();
          cart_details[3] = cart.getUnit_price().toString();
          test.checkShoppingCart(cart_id, book_id);
          cart_details[4] = cart.getCart_id().toString();
          cart_details[5] = cart.getBook().getIsbn();
          cart_details[6] = cart.getUnits().toString();
          cart_details[7] = cart.getUnit_price().toString();
          em.remove(cart);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return cart_details;
    }
}