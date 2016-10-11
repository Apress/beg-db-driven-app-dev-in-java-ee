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

public class CompositeKeyTestServlet extends HttpServlet {
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
        //creating ShoppingCart entity instances
        ShoppingCart cart1 = new ShoppingCart();
        cart1.setCart_id(2);
        Book book1 = (Book) em.find(Book.class, "1590595300");
        cart1.setBook(book1);
        cart1.setUnits(3);
        cart1.setUnit_price(49.99);
        out.println("Price of the book in book1 is: $" + book1.getPrice() + "<br/>");

        ShoppingCart cart2 = new ShoppingCart();
        cart2.setCart_id(2);
        Book book2 = (Book) em.find(Book.class, "1430209631");
        cart2.setBook(book2);
        cart2.setUnits(2);
        cart2.setUnit_price(44.99);
        out.println("Price of the book in book2 is: $" + book2.getPrice() + "<br/>"); 

        //Performing transaction
        try{
           userTransaction.begin();
           out.println("Transaction began!"+"<br/>");
           em.persist(cart1);
           em.persist(cart2);
           em.flush();
           out.println("cart instances have been persisted to database!"+ "<br/>");
           ShoppingCart cart3 = (ShoppingCart) em.find(ShoppingCart.class, new ShoppingCartKey(2, "1590595300"));
           out.println("Price of the book in cart3 is: $" + cart3.getBook().getPrice() + "<br/>");
           ShoppingCart cart4 = (ShoppingCart) em.find(ShoppingCart.class, new ShoppingCartKey(2, "1430209631"));
           out.println("Price of the book in cart4 is: $" + cart4.getBook().getPrice() + "<br/>"); 
           userTransaction.rollback();
           out.println("Transaction has been rolled back!");
        }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}
