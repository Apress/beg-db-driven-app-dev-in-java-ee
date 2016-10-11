package ejbjpa.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;
import java.util.List;
import java.util.Iterator;
import ejbjpa.entities.*;
import ejbjpa.ejb.*;
public class JpqlTestServlet extends HttpServlet {
    @EJB private JpqlTest jpqlTest;
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
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
