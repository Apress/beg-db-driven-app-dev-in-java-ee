package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
public class EmEjbTestServlet extends HttpServlet {
    @EJB private ShoppingCartTest cartTest;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        try{
           String[] details = new String[8];
           details = cartTest.setShoppingCart(2,"1430209631", 1, 44.99);
           out.println("Cart id : "+ details[0] +"<br/>");
           out.println("Book id : "+ details[1] +"<br/>");
           out.println("Units : "+ details[2] +"<br/>");
           out.println("Unit_price: "+ details[3] +"<br/>");
           out.println("-------------------"+"<br/>");
           out.println("Cart id : "+ details[4] +"<br/>");
           out.println("Book id : "+ details[5] +"<br/>");
           out.println("Units : "+ details[6] +"<br/>");
           out.println("Unit_price: "+ details[7] +"<br/>");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
