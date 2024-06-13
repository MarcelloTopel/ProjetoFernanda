package ProjetoFernanda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta:");
                    String numero = scanner.next();
                    System.out.println("Digite o nome do titular:");
                    String titular = scanner.next();
                    System.out.println("Digite o saldo inicial:");
                    double saldoInicial = scanner.nextDouble();
                    if (banco.criarConta(numero, titular, saldoInicial)) {
                        System.out.println("Conta criada com sucesso.");
                    } else {
                        System.out.println("Número da conta já existe.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o número da conta:");
                    numero = scanner.next();
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    banco.depositar(numero, valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o número da conta:");
                    numero = scanner.next();
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    banco.sacar(numero, valorSaque);
                    break;
                case 4:
                    System.out.println("Digite o número da conta de origem:");
                    String numeroOrigem = scanner.next();
                    System.out.println("Digite o número da conta de destino:");
                    String numeroDestino = scanner.next();
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferencia = scanner.nextDouble();
                    banco.transferir(numeroOrigem, numeroDestino, valorTransferencia);
                    break;
                case 5:
                    System.out.println("Digite o número da conta:");
                    numero = scanner.next();
                    banco.consultarSaldo(numero);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
