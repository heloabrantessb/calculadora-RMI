# Calculadora Distribuída via Java RMI

Este projeto é uma demonstração prática de **RMI (Remote Method Invocation)** em Java. RMI é uma tecnologia que permite a objetos Java em execução em diferentes Máquinas Virtuais Java (JVMs) invocarem métodos uns dos outros pela rede, ideal para sistemas distribuídos simples.

O repositório contém dois exemplos principais:
1. **Calculadora Distribuída** (exemplo interativo e completo com tratamento de exceções).
2. **Hello World RMI** (exemplo básico de inicialização e comunicação).

---

## Estrutura do Projeto

Os arquivos fonte estão contidos no diretório `src`:

*   **Calculadora Distribuída**:
    *   [`ICalculadora.java`](file:///home/helo/projetos/calculadora-RMI/src/ICalculadora.java): Interface que define as operações matemáticas expostas remotamente (soma, subtração, multiplicação e divisão).
    *   [`CalculadoraImpl.java`](file:///home/helo/projetos/calculadora-RMI/src/CalculadoraImpl.java): Implementação real dos métodos matemáticos definidos na interface.
    *   [`CalculadoraServer.java`](file:///home/helo/projetos/calculadora-RMI/src/CalculadoraServer.java): Servidor que cria o Registro RMI na porta `1099` e registra o serviço.
    *   [`CalculadoraClient.java`](file:///home/helo/projetos/calculadora-RMI/src/CalculadoraClient.java): Cliente interativo CLI que se conecta ao servidor RMI e envia comandos via console.

*   **Exemplo Simplificado (Hello World)**:
    *   [`Hello.java`](file:///home/helo/projetos/calculadora-RMI/src/Hello.java): Interface do serviço simplificado.
    *   [`HelloServer.java`](file:///home/helo/projetos/calculadora-RMI/src/HelloServer.java): Servidor do exemplo básico.
    *   [`HelloClient.java`](file:///home/helo/projetos/calculadora-RMI/src/HelloClient.java): Cliente do exemplo básico.

---

## Como Executar

### Pré-requisitos
*   Java JDK 8 ou superior instalado.
*   Terminal do sistema operacional.

### Passo 1: Compilação dos Arquivos
Compile todos os arquivos Java a partir da raiz do projeto direcionando os binários para a pasta `bin`:

```bash
javac -d bin src/*.java
```

### Passo 2: Executar a Calculadora

#### 1. Iniciar o Servidor
O servidor da calculadora cria o registro RMI na porta `1099` de maneira dinâmica e automática. Inicie-o com:

```bash
java -cp bin CalculadoraServer
```
*Você deve ver a mensagem: `Servidor RMI da Calculadora iniciado com sucesso!`*

#### 2. Iniciar o Cliente
Em um **novo terminal**, execute o cliente para abrir o menu interativo:

```bash
java -cp bin CalculadoraClient
```

No terminal do cliente, você poderá interagir fornecendo os números e a operação desejada:
```text
=== CALCULADORA DISTRIBUÍDA RMI ===
1. Soma (+)
2. Subtração (-)
3. Multiplicação (*)
4. Divisão (/)
5. Sair
Escolha uma opção:
```

---

## Tecnologias e Recursos Utilizados

*   **Java RMI Registry**: Serviço de busca e registro de objetos distribuídos.
*   **Programação Orientada a Objetos**: Uso de interfaces (`Remote`) e herança (`UnicastRemoteObject`) para definição de chamadas remotas.
*   **Tratamento de Exceções**: Proteção no cliente e servidor para divisões por zero e falhas de conexão de rede (`RemoteException`).
