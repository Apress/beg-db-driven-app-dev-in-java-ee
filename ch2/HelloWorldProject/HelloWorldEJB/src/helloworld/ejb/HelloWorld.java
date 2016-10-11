package helloworld.ejb;
import javax.ejb.Remote;
@Remote
public interface HelloWorld {
  public String outputHelloWorld(); 
}
