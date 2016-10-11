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
        Integer custid1=1;
        Integer custid2=2;
        Integer empno1=1;
        Integer empno2=2;
        try{
           Integer pono = orderTest.setOrder(custid1,empno1);
           out.println("Created order "+ pono +"<br/>");
           out.println(orderTest.changeOrderEmpTest(pono,empno2, custid2));
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
