package ejbjpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @Column(name = "PONO")
    private Integer pono;
    @Column(name = "CUST_ID", nullable = false)
    private Integer cust_id;
    @Column(name = "UNITS", nullable = false)
    private Integer units;
    @ManyToOne
    @JoinColumn(
      name="BOOK_ID",
      referencedColumnName="ISBN")
    private Book book;

    public Order() {
    }   
    public Integer getPono() {
        return this.pono;
    }
    public void setPono(Integer pono) {
        this.pono = pono;
    }
    public Integer getCust_id() {
        return this.cust_id;
    }
    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }
    public Integer getUnits() {
        return this.units;
    }
    public void setUnits(Integer units) {
        this.units = units;
    }
    public Book getBook() {
        return this.book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

}
