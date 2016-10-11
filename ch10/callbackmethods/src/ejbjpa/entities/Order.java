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
import java.util.*;
import javax.persistence.PrePersist;

import java.util.Date;
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @PrePersist
    private void setShippingDate() {
     if (this.getShipping_date() == null)
     {
       Calendar calendar = new GregorianCalendar();
       long weekday = calendar.get(Calendar.DAY_OF_WEEK);
       long days;
       if (weekday == 6) {
            days = 3;
       } else if (weekday == 7) {
            days = 2;
       } else {
            days =1;
       }
       Date date = new Date();
       long msDay = 1000 * 60 * 60 * 24;
       date.setTime(date.getTime() + msDay * days);
       this.setShipping_date(date);
     }
    }
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
