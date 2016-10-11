package ejbjpa.ejb;
import javax.ejb.Remote;
@Remote
public interface BookSession  {
   public Integer gettingQuantity(String book_id);
}
