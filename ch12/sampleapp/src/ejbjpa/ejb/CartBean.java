package ejbjpa.ejb;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import ejbjpa.entities.*;
@Stateful
public class CartBean implements Cart {
@PersistenceContext(type=PersistenceContextType.EXTENDED) 
EntityManager em;
Integer custId;
List<ShoppingCart> items;
public void initialize(Integer cust_id) {
 if (cust_id == null) {
  throw new EJBException("Null cust_id provided.");
 } else {
    custId = cust_id;
  }
 }
 public void addItem(String item_id, Integer quantity, Double price) {
   ShoppingCart cart = (ShoppingCart) em.find(ShoppingCart.class, new ShoppingCartKey(custId, item_id));   
   if(cart == null){
     cart = new ShoppingCart();
     cart.setCart_id(custId);
     cart.setBook_id(item_id);
     cart.setUnits(quantity);
     cart.setUnit_price(price);
     em.persist(cart);
   } else {
     throw new EJBException("This item is already in cart.");
   }
 }
 public void removeItem(String item_id) {
   ShoppingCart cart = (ShoppingCart) em.find(ShoppingCart.class, new ShoppingCartKey(custId, item_id));   
   if(cart == null){
     throw new EJBException("This item is not in cart.");
    } else {
     em.remove(cart);
    }
 }
public List<ShoppingCart> getItems() {
   items = (List<ShoppingCart>)em.createQuery("SELECT s FROM ShoppingCart s WHERE s.cart_id =:cust_id")
                       .setParameter("cust_id", custId)
                       .getResultList(); 
   return items;
}
@Remove
public Integer emptyCart() {
  Integer num =0;
  num = em.createQuery("DELETE FROM ShoppingCart s WHERE s.cart_id =:cust_id")
                       .setParameter("cust_id", custId)
                       .executeUpdate();
  return num;
}
@Remove
public void clearCartInstance() {
  }
}
