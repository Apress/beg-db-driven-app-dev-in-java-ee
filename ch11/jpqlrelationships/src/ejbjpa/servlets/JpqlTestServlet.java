package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import java.util.List;
import java.util.Iterator;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;

public class JpqlTestServlet extends HttpServlet {
    @EJB private JpqlTest jpqlTest;
    @Resource
    UserTransaction utx;

    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        try{
           List<Employee> employees = jpqlTest.getEmployees();
           Iterator i = employees.iterator();
           Employee employee;
           while (i.hasNext()) {
               employee = (Employee) i.next();
               out.println("Employee id: "+ employee.getEmpno() +"<br/>");
               out.println("First name: "+ employee.getFirstname() +"<br/>");
               out.println("Last name: "+ employee.getLastname() +"<br/>");
               out.println("----------"+ "<br/>");
           }
           utx.begin();
           out.println("All employee entities were managed during the checkIfManaged call: "+ jpqlTest.checkIfManaged() +"<br/>");
           utx.rollback();

        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
