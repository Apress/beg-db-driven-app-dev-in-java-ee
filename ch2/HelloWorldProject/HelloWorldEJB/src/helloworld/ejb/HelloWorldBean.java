package helloworld.ejb;
import javax.ejb.Stateless;
@Stateless
public class HelloWorldBean implements helloworld.ejb.HelloWorld {
  public String outputHelloWorld() {
     return "Hello World!";
  }
}