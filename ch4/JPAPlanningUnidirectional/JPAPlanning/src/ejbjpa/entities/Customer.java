package ejbjpa.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {
    @Id
    @Column(name = "CUST_ID")
    private Integer cust_id;
    @Column(name = "COMPANY_NAME", nullable = false)
    private String company_name;
    @Column(name = "PHONE", nullable = false)
    private String phone;
    @OneToOne
    @PrimaryKeyJoinColumn(
      name="CUST_ID",
      referencedColumnName="CUST_ADDRESS_ID")
    private Address address;
    public Customer() {
    }   
    public Integer getCust_id() {
        return this.cust_id;
    }
    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }
    public String getCompany_name() {
        return this.company_name;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Address getAddress() {
        return this.address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
