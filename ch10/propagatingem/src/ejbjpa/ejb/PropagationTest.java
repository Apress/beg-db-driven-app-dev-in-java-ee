package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface PropagationTest  {
   public void checkShoppingCart(Integer cart_id, String book_id);
}
