package ejbjpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "BILLING_ADDRESSES")
public class Address implements Serializable {
    @Id
    @Column(name = "CUST_ADDRESS_ID")
    private Integer cust_address_id;
    @Column(name = "STREET", nullable = false)
    private String street;
    @Column(name = "CITY", nullable = false)
    private String city;
    @Column(name = "STATE", nullable = false)
    private String state;
    @Column(name = "ZIPCODE", nullable = false)
    private String zipcode;
    @OneToOne(mappedBy="address")

    private Customer customer;

    public Address() {
    }   
    public Customer getCustomer () {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer= customer;
    }

    public Integer getCust_address_id() {
        return this.cust_address_id;
    }
    public void setCust_address_id(Integer cust_address_id) {
        this.cust_address_id = cust_address_id;
    }
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipcode() {
        return this.zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
