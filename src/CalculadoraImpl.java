import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements ICalculadora {
    
    public CalculadoraImpl() throws RemoteException {
        super();
    }

    @Override
    public double soma(double a, double b) throws RemoteException {
        System.out.println(a + " + " + b);
        return a + b;
    }

    @Override
    public double subtracao(double a, double b) throws RemoteException {
        System.out.println(a + " - " + b);
        return a - b;
    }

    @Override
    public double multiplicacao(double a, double b) throws RemoteException {
        System.out.println(a + " * " + b);
        return a * b;
    }

    @Override
    public double divisao(double a, double b) throws RemoteException {
        System.out.println(a + " / " + b);
        if (b == 0) {
            throw new RemoteException("Divisão por zero não é permitida!");
        }
        return a / b;
    }
}
