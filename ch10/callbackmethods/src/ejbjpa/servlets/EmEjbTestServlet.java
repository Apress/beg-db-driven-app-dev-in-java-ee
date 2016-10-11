package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
import java.util.Date;

public class EmEjbTestServlet extends HttpServlet {
    @EJB private OrderTest orderTest;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        try{
           long days =5;
           Date date = new Date();
           long msDay = 1000 * 60 * 60 * 24;
           date.setTime(date.getTime() + msDay * days);

           String[] details = new String[2];
           details = orderTest.setOrder(2,1, date, null);
           out.println("Created order pono: "+ details[0] +"<br/>");
           out.println("Order shipping date: "+ details[1] +"<br/>");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
