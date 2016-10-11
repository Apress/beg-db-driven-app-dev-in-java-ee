package ejbjpa.client;
import javax.ejb.EJB;
import ejbjpa.ejb.CustomerSession;
public class CustomerSessionClient {
      @EJB
      private static CustomerSession customerSession;
      public static void main (String[] args)
        {
            System.out.println("Billing address of the customer whose id=1 is: "+customerSession.getCustomerAddress(1));
        }
}