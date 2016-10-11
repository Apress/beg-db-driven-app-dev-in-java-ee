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
public class CascadingTestServlet extends HttpServlet {
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
        List<Order> orders = new ArrayList<Order>();
        Order order1 = new Order();
        order1.setPono(10);
        order1.setCustomer(cust);
        order1.setEmployee(emp);
        Order order2 = new Order();
        order2.setPono(11);
        order2.setCustomer(cust);
        order2.setEmployee(emp);
        orders.add(order1);
        orders.add(order2);
        cust.setOrders(orders);
        //Performing transaction
        try{
           userTransaction.begin();
           out.println("Transaction began!"+"<br/>");
         //  em.persist(cust);
           em.flush();
           em.refresh(cust);
           orders = cust.getOrders();
           for (int i = 0; i < orders.size(); i++) {
             out.println("order "+ orders.get(i).getPono()+ " placed by: " + orders.get(i).getCustomer().getCust_name() + "<br/>");
           }
           userTransaction.rollback();
           out.println("Transaction has been rolled back!");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
