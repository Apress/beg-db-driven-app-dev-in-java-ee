package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
public class JpqlJoinsTestServlet extends HttpServlet {
    @EJB private JpqlJoinsTest jpqlJoinsTest;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        Integer[] numOfOrders= new Integer[3];
        numOfOrders=jpqlJoinsTest.countOrders(1);
        try{
           out.println("Number of orders associated with employee 1: "+numOfOrders[0] +"<br/>");
           out.println("Number of orders returned by the JOIN query after increasing: "+numOfOrders[1] +"<br/>");
           out.println("Number of orders you actually got after increasing: "+numOfOrders[2] +"<br/>");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
