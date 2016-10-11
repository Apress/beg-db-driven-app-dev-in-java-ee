package ejbjpa.client;
import javax.ejb.EJB;
import ejbjpa.ejb.CustomerSession;
public class CustomerSessionClient {
      @EJB
      private static CustomerSession customerSession;
      public static void main (String[] args)
        {
            System.out.println("Details of the customer whose billing address id=1 is: "+customerSession.getCustomerDetails(1));
        }
}