package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface ShoppingCartTest  {
   public String[] setShoppingCart(Integer cart_id, String book_id, Integer units, Double unit_price);
}
