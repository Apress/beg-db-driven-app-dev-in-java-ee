package ejbjpa.jsfbeans;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import ejbjpa.ejb.*;
import ejbjpa.entities.*;

@EJB(name="ejb/CartBean", beanInterface=Cart.class)
public class OrderJSFBean {
    private Cart cart;
    @EJB
    private OrderSample order;
    private List<ShoppingCart> cartItems;
    private Integer custId;
    public OrderJSFBean() {
        custId = Integer.parseInt(
                    FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
    try{
      if (cart == null) {
           cart = (Cart) (new InitialContext()).lookup("java:comp/env/ejb/CartBean");
      } 
      cart.initialize(custId);    
     } catch (Exception e) {
            e.printStackTrace();
     } 
    }

    public Integer getCustId() {
        return custId;
    }
    public List<ShoppingCart> getCartItems() {
        cartItems = null;
        try {
            cartItems = cart.getItems();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return cartItems;
    }
    public void addToCart() {
        try {
         FacesContext cxt = FacesContext.getCurrentInstance();
         Map params = cxt.getExternalContext().getRequestParameterMap();
         String isbn = (String)params.get("isbn");
         String price_str = (String)params.get("price");
         Double price =new Double(price_str);
         cart.addItem(isbn, 1, price);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void removeFromCart() {
        try {
         FacesContext cxt = FacesContext.getCurrentInstance();
         Map params = cxt.getExternalContext().getRequestParameterMap();
         String itemId = (String)params.get("itemId");
         cart.removeItem(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public String ProceedToCheckout() {
        try {
          order.placeOrder(custId, 1);
        } catch (Exception e) {
            e.printStackTrace();
        } 
       return "continue";
    }

}
