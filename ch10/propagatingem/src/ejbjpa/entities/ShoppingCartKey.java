package ejbjpa.entities;
import java.io.Serializable;

public final class ShoppingCartKey implements Serializable {
 public Integer cart_id;
 public String book_id;
 public ShoppingCartKey() {}
 public ShoppingCartKey(Integer cart_id, String book_id) {
  this.cart_id = cart_id;
  this.book_id = book_id;
 }

public boolean equals(Object obj) {
 if (this == obj) {
  return true;
 }
 if (obj == null) {
  return false;
 }
 if (!(obj instanceof ShoppingCartKey)) {
  return false;
 }
 ShoppingCartKey other = (ShoppingCartKey) obj;
 if (cart_id != null && other.cart_id!= null && this.cart_id.equals(other.cart_id)) {
   return (book_id != null && other.book_id!= null && this.book_id.equals(other.book_id));
  }
  return false;
}

public int hashCode() {
 if (cart_id!=null && book_id!=null) {
  return (cart_id.hashCode() ^ book_id.hashCode());
 }
 return 0;
}

}