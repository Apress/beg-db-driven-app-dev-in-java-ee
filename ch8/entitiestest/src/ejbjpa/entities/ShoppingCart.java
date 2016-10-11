package ejbjpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
@Entity
@Table(name = "SHOPPINGCARTS")
@IdClass(value = ejbjpa.entities.ShoppingCartKey.class)
public class ShoppingCart implements Serializable {
    @Id
    @Column(name = "CART_ID")
    private Integer cart_id;
    @Id
    @Column(name = "BOOK_ID")
    private String book_id;
    @Column(name = "UNITS", nullable = false)
    private Integer units;
    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unit_price;
    public ShoppingCart() {
    }   
    public Integer getCart_id() {
        return this.cart_id;
    }
    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }
    public String getBook_id() {
        return this.book_id;
    }
    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }
    public Integer getUnits () {
        return this.units;
    }
    public void setUnits(Integer units) {
        this.units = units;
    }
    public Double getUnit_price() {
        return this.unit_price;
    }
    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }
}
