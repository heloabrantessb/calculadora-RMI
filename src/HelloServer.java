import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.RMISecurityManager; 
import java.rmi.server.UnicastRemoteObject; 

public class HelloServer extends UnicastRemoteObject implements Hello {
    public HelloServer() throws RemoteException {
        super();
    }

    public String Hello(){
        System.out.println("Invocation to Hello was succesful!"); 
        return "Hello World from RMI server!"; 
    }

    public static void main(String[] args) {
        try { 
            HelloServer obj = new HelloServer(); 
            Naming.rebind("Hello", obj); 
            System.out.println("Ligado no registro"); 
        } 
        catch (Exception e) { 
            System.out.println("error: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    }
}
