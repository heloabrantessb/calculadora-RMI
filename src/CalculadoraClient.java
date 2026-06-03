import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculadoraClient {
    public static void main(String[] args) {
        try {
            // referência do registro na máquina local na porta 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            ICalculadora calc = (ICalculadora) registry.lookup("CalculadoraService");
            
            System.out.println("Conectado ao servidor de Calculadora RMI!");
            
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;
            
            while (continuar) {
                System.out.println("\n=== CALCULADORA DISTRIBUÍDA RMI ===");
                System.out.println("1. Soma (+)");
                System.out.println("2. Subtração (-)");
                System.out.println("3. Multiplicação (*)");
                System.out.println("4. Divisão (/)");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = 0;
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                } else {
                    scanner.next(); // consome valor inválido
                    System.out.println("Opção inválida. Digite um número de 1 a 5.");
                    continue;
                }
                
                if (opcao == 5) {
                    continuar = false;
                    System.out.println("Encerrando o cliente da calculadora. Até mais!");
                    break;
                }
                
                if (opcao < 1 || opcao > 4) {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
                
                System.out.print("Digite o primeiro número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Digite o segundo número: ");
                double num2 = scanner.nextDouble();
                
                double resultado = 0;
                try {
                    switch (opcao) {
                        case 1:
                            resultado = calc.soma(num1, num2);
                            System.out.println("Resultado da soma: " + resultado);
                            break;
                        case 2:
                            resultado = calc.subtracao(num1, num2);
                            System.out.println("Resultado da subtração: " + resultado);
                            break;
                        case 3:
                            resultado = calc.multiplicacao(num1, num2);
                            System.out.println("Resultado da multiplicação: " + resultado);
                            break;
                        case 4:
                            resultado = calc.divisao(num1, num2);
                            System.out.println("Resultado da divisão: " + resultado);
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao realizar operação " + e.getMessage());
                }
            }
            scanner.close();
            
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
