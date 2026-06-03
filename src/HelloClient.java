import java.rmi.Naming; 
import java.rmi.RemoteException; 

public class HelloClient {
    static String mensagem = "Olá, mundo";
    static Hello obj = null;

    public static void main(String[] args) {
        try {
            obj = (Hello)Naming.lookup("//localhost/Hello");
            mensagem = obj.Hello();
            System.out.println("Mensagem do servidor: " + mensagem);
        } catch (Exception e) {
            System.out.println("HelloClient exception: "
            + e.getMessage()); 
            e.printStackTrace(); 
        }
    }
}
