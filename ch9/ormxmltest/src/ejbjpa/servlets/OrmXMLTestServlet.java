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
public class OrmXMLTestServlet extends HttpServlet {
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
        order1.setPono(10);
        order1.setCustomer(cust);
        order1.setEmployee(emp);
        Order order2 = new Order();
        order2.setPono(11);
        order2.setCustomer(cust);
        order2.setEmployee(emp);
        //Performing transaction
        try{
           userTransaction.begin();
           out.println("Transaction began!"+"<br/>");
           em.persist(order1);
           em.persist(order2);
           em.flush();
           em.refresh(emp);
           out.println("order " + emp.getOrders().get(0).getPono()+ " placed via: " + emp.getOrders().get(0).getEmployee().getLastname() + "<br/>");
           out.println("order " + emp.getOrders().get(1).getPono()+ " placed via: " + emp.getOrders().get(1).getEmployee().getLastname() + "<br/>");
           userTransaction.rollback();
           out.println("Transaction has been rolled back!");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
