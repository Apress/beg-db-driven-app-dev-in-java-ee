package ejbjpa.entities;
import java.io.Serializable;
import java.util.List;
public class Employee implements Serializable {
    private Integer empno;
    private String firstname;
    private String lastname;
    private List<Order> orders;
    public List<Order> getOrders(){
       return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public Employee() {
    }   
    public Integer getEmpno() {
        return this.empno;
    }
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }
    public String getFirstname() {
        return this.firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
