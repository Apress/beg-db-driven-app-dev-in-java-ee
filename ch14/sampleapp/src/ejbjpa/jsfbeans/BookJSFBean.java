package ejbjpa.jsfbeans;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import ejbjpa.ejb.*;
import ejbjpa.entities.*;

import java.sql.*;
import javax.sql.DataSource;

public class BookJSFBean {
    private Connection connDb;
    public void openConnection() throws Exception {
      if(connDb != null)
        return;
      DataSource dataSource = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/mysqlpool");
      connDb = dataSource.getConnection();
    }
    public ResultSet getAllBooks() throws Exception {
      ResultSet rslt = null;
      this.openConnection();
      Statement stmt = connDb.createStatement();
      rslt = stmt.executeQuery("SELECT * FROM books");
      return  rslt;
    }
}
