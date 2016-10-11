package ejbjpa.ejb;
import javax.ejb.Remote;
import java.util.List;
import ejbjpa.entities.*;

@Remote
public interface Cart  {
   public void initialize(Integer cust_id);
   public void addItem(String item_id, Integer quantity, Double price);
   public void removeItem(String item_id);
   public List<ShoppingCart> getItems();
   public Integer emptyCart();
   public void clearCartInstance();
}
