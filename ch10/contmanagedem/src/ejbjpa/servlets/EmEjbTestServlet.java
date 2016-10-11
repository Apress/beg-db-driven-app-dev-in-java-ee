package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
public class EmEjbTestServlet extends HttpServlet {
    @EJB private OrderTest orderTest;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        try{
           Integer pono = orderTest.setOrder(2,1);
           out.println("Created order "+ pono +"<br/>");
           out.println(orderTest.changeOrderEmpTest(pono,2));
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
