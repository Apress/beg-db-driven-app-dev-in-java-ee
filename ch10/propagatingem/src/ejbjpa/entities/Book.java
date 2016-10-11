package ejbjpa.entities;
import java.util.List;
import javax.persistence.CascadeType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {
    @Id
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "AUTHOR", nullable = false)
    private String author;
    @Column(name = "PRICE", nullable = false)
    private Double price;
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy="book", cascade = CascadeType.ALL)
    private List<ShoppingCart> shoppingCarts;
    public List<ShoppingCart> getShoppingCarts(){
       return shoppingCarts;
    }
    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public Book() {
    }   
    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
