package ejbjpa.client;
import javax.ejb.EJB;
import ejbjpa.ejb.OrderSession;
public class OrderSessionClient {
      @EJB
      private static OrderSession orderSession;
      public static void main (String[] args)
        {
            Integer pono = Integer.parseInt(args[0]); //= 7; 
            Integer cust_id = Integer.parseInt(args[1]);  // = 1; 
            Integer units = Integer.parseInt(args[2]);   // = 1; 
            String book_id = args[3];   // = "1430209631";
            orderSession.placeOrder(pono, cust_id, units, book_id);
        }
}