package ejbjpa.client;
import javax.ejb.EJB;
import ejbjpa.ejb.BookSession;
public class BookSessionClient {
      @EJB
      private static BookSession bookSession;
      public static void main (String[] args)
        {
            String book_id = args[0];   // = "1430209631";
            System.out.println(bookSession.gettingQuantity(book_id));
        }
}