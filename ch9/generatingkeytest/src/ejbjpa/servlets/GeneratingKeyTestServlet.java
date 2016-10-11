package ejbjpa.servlets;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.*;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import ejbjpa.entities.*;
public class GeneratingKeyTestServlet extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction userTransaction;
    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        EntityManager em= emf.createEntityManager();
        Customer cust = (Customer) em.find(Customer.class, 2);
        Employee emp = (Employee) em.find(Employee.class, 2);
        Order order1 = new Order();
     //   order1.setPono(16);
        order1.setCustomer(cust);
        order1.setEmployee(emp);
        Order order2 = new Order();
    //    order2.setPono(17);
        order2.setCustomer(cust);
        order2.setEmployee(emp);
        //Performing transaction
        try{
           userTransaction.begin();
           out.println("Transaction began!"+"<br/>");
           em.persist(order1);
           em.persist(order2);
           em.flush();
           em.refresh(order1);
           em.refresh(order1);
           out.println("order "+ order1.getPono()+ " placed by: " + order1.getCustomer().getCust_name() + "<br/>");
           out.println("order "+ order2.getPono()+ " placed by: " + order2.getCustomer().getCust_name() + "<br/>");
           userTransaction.rollback();
           out.println("Transaction has been rolled back!");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
