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
public class JpaTestServlet extends HttpServlet {
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
        int status;
        //creating ShoppingCart entity instances
        ShoppingCart cart1 = new ShoppingCart();
        cart1.setCart_id(2);
        cart1.setBook_id("1590595300");
        cart1.setUnits(1);
        cart1.setUnit_price(49.99);
        ShoppingCart cart2 = new ShoppingCart();
        cart2.setCart_id(2);
        cart2.setBook_id("1430209631");
        cart2.setUnits(1);
        cart2.setUnit_price(44.99);
        //Creating the order entity instance that will convert the above ShoppingCarts into the order's details
        Customer cust1 = (Customer) em.find(Customer.class, 2);
        Employee emp1 = (Employee) em.find(Employee.class, 1);
        Order order1 = new Order();
        order1.setPono(10);
        order1.setCustomer(cust1);
        order1.setEmployee(emp1);
        //Performing transaction
        try{
           userTransaction.begin();
           out.println("Transaction began!"+"<br/>");
           em.persist(cart1);
           em.persist(cart2);
           em.flush();
           em.refresh(cart1);
           out.println("cart1 has been refreshed from database!"+ "<br/>");
           out.println("Price of the book in cart1 is: $" + cart1.getUnit_price() + "<br/>");
           em.refresh(cart2);
           out.println("cart2 has been refreshed from database!"+ "<br/>");
           out.println("Price of the book in cart2 is: $" + cart2.getUnit_price() + "<br/>");
           em.persist(order1);
           em.flush();
           out.println("Order shipping date is: " + order1.getShipping_date() + "<br/>");
           em.refresh(order1);
           out.println("Order instance has been refreshed from database!" + "<br/>");
           out.println("Order shipping date is: " + order1.getShipping_date() + "<br/>");
           try{
             em.refresh(cart1);
             out.println("Price of the book in cart1 is: $" + cart1.getUnit_price() + "<br/>");
             em.refresh(cart2);
             out.println("Price of the book in cart2 is: $" + cart2.getUnit_price() + "<br/>");
           }
           catch ( Exception ex){
             out.println("Failed to refresh ShoppingCart instances from database!" + "<br/>");
             status = userTransaction.getStatus();
                          if (status==Status.STATUS_MARKED_ROLLBACK){
             out.println("Transaction has been marked for roll back due to exception!");
            }
           }
           status = userTransaction.getStatus();
                       if (status==Status.STATUS_ACTIVE){
                       userTransaction.rollback();
           out.println("Transaction has been rolled back!");
          }
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
