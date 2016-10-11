package ejbjpa.ejb;
//import javax.ejb.Remote;
//@Remote
public interface OrderSession  {
   public void placeOrder(Integer pono, 
                           Integer cust_id,
                           Integer units,
                           String book_id);
}