package ejbjpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "SHOPPINGCARTS")
@IdClass(value = ejbjpa.entities.ShoppingCartKey.class)
public class ShoppingCart implements Serializable {
    @Id
    @Column(name = "CART_ID")
    private Integer cart_id;
    @Id
    @Column(name = "BOOK_ID", insertable=false, updatable=false)
    private String book_id;
    @Column(name = "UNITS", nullable = false)
    private Integer units;
    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unit_price;
    @ManyToOne
    @JoinColumn(
      name="BOOK_ID",
      referencedColumnName="ISBN")
    private Book book;
    public ShoppingCart() {
    }   
    public Book getBook() {
        return this.book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Integer getCart_id() {
        return this.cart_id;
    }
    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
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
