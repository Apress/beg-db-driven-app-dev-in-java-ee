package ejbjpa.ejb;
import java.io.Serializable;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

@Stateless
public class BookSessionBean implements BookSession {
    @Resource(name="jdbc/MySQL")
    private DataSource dataSource;
    public Integer gettingQuantity(String book_id) 
    {
    Integer qnty;
        try {
          Connection conn = dataSource.getConnection();
          PreparedStatement stmt = conn.prepareStatement("SELECT copiesInStock(?) as quantity FROM DUAL");
          stmt.setString(1, book_id);
          ResultSet rslt = stmt.executeQuery(); 
          rslt.next();
          qnty = rslt.getInt("quantity");
          rslt.close();
          stmt.close();
          conn.close();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
        return qnty;
    }
}