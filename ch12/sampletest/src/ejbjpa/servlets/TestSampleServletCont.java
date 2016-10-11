package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import java.util.List;
import java.util.Iterator;
import javax.ejb.EJBException;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
public class TestSampleServletCont extends HttpServlet {
    @EJB(name="ejb/CartBean", beanInterface=Cart.class)
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cartatt");
        try{
          if (cart == null) {
                    cart = (Cart) (new InitialContext()).lookup("java:comp/env/ejb/CartBean");
                    session.setAttribute("cartatt", cart);  
                    cart.initialize(2);     
                    out.println("Cart initialized" +"<br/>");
           }
           out.println("Remove the first item from the cart "+ "<br/>");
           cart.removeItem("1430209631");
           cart.removeItem("1590595300");
           cart.addItem("1590595300", 2, 32.99);

           List<ShoppingCart> items = cart.getItems();
           ShoppingCart shoppingCart;
           Iterator i = items.iterator();
           while (i.hasNext()) {
               shoppingCart = (ShoppingCart) i.next();
               out.println("Cart id: "+ shoppingCart.getCart_id() +"<br/>");
               out.println("Book id: "+ shoppingCart.getBook_id() +"<br/>");
               out.println("Quantity: "+ shoppingCart.getUnits() +"<br/>");
               out.println("Unit price: "+ shoppingCart.getUnit_price() +"<br/>");
               out.println("----------"+ "<br/>");
           }
           Integer num = cart.emptyCart();
           out.println(num + " item(s) removed " + "<br/>");
        }
        catch (Exception e){
           e.printStackTrace();
        }
        finally {
           session.removeAttribute("cartatt");
        }
    }
}
