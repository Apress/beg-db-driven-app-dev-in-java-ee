package helloworld.client;
 
import javax.ejb.EJB;
import helloworld.ejb.HelloWorld;
public class HelloWorldClient {
      @EJB
      private static HelloWorld helloWorld;
      public static void main (String[] args)
        {
            System.out.println(helloWorld.outputHelloWorld());
        }
}