import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculadoraServer {
    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta 1099 dinamicamente
            Registry registry = LocateRegistry.createRegistry(1099);
            
            CalculadoraImpl obj = new CalculadoraImpl();
            
            registry.rebind("CalculadoraService", obj);
            
            System.out.println("----------------------------------------------");
            System.out.println("Servidor RMI da Calculadora iniciado com sucesso!");
            System.out.println("----------------------------------------------");
        } catch (Exception e) {
            System.err.println("Erro no servidor da Calculadora: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
