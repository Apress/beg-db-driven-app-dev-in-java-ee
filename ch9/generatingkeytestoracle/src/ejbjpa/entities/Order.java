package ejbjpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.persistence.SequenceGenerator;

import java.util.Date;
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
 /*   @TableGenerator(name = "ponoGen", 
                    table = "PONO_GEN_TABLE", 
                    pkColumnName = "GEN_NAME", 
                    valueColumnName = "GEN_VALUE", 
                    pkColumnValue = "PONO_GEN", 
                    allocationSize = 1) */
    @SequenceGenerator(name = "ponoGen", 
                    sequenceName = "PONO_GEN_SEQUENCE", 
                    initialValue = 10, 
                    allocationSize = 1) 

    @Id
   // @GeneratedValue(strategy=GenerationType.TABLE, generator = "ponoGen")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ponoGen")
    @Column(name = "PONO")
    private Integer pono;
    @Column(name = "SHIPPING_DATE", nullable = false)
    @Temporal(DATE)
    private Date shipping_date;
    @Column(name = "DELIVERY_ESTIMATE", nullable = false)
    private String delivery_estimate;
    @ManyToOne
    @JoinColumn(
      name="CUST_ID",
      referencedColumnName="CUST_ID")
    private Customer customer;
    @ManyToOne
    @JoinColumn(
      name="EMPNO",
      referencedColumnName="EMPNO")
    private Employee employee;
    public Order() {
    }   
    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    public void setEmployee (Employee employee) {
        this.employee = employee;
    }
    public Integer getPono () {
        return this.pono;
    }
    public void setPono (Integer pono) {
        this.pono = pono;
    }
    public Date getShipping_date () {
        return this.shipping_date;
    }
    public void setShipping_date (Date shipping_date) {
        this.shipping_date = shipping_date;
    }
    public String getDelivery_estimate () {
        return this.delivery_estimate;
    }
    public void setDelivery_estimate (String delivery_estimate) {
        this.delivery_estimate = delivery_estimate;
    }
}
