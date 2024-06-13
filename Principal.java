package j;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Consultar Saldo");
            System.out.println("7. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta:");
                    String numeroCorrente = scanner.next();
                    System.out.println("Digite o nome do titular:");
                    String titularCorrente = scanner.next();
                    System.out.println("Digite o saldo inicial:");
                    double saldoInicialCorrente = scanner.nextDouble();
                    System.out.println("Digite a taxa de operação:");
                    double taxaDeOperacao = scanner.nextDouble();
                    if (banco.criarContaCorrente(numeroCorrente, titularCorrente, saldoInicialCorrente, taxaDeOperacao)) {
                        System.out.println("Conta Corrente criada com sucesso.");
                    } else {
                        System.out.println("Número da conta já existe.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o número da conta:");
                    String numeroPoupanca = scanner.next();
                    System.out.println("Digite o nome do titular:");
                    String titularPoupanca = scanner.next();
                    System.out.println("Digite o saldo inicial:");
                    double saldoInicialPoupanca = scanner.nextDouble();
                    System.out.println("Digite a taxa de juros:");
                    double taxaDeJuros = scanner.nextDouble();
                    if (banco.criarContaPoupanca(numeroPoupanca, titularPoupanca, saldoInicialPoupanca, taxaDeJuros)) {
                        System.out.println("Conta Poupança criada com sucesso.");
                    } else {
                        System.out.println("Número da conta já existe.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o número da conta:");
                    String numeroDeposito = scanner.next();
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    banco.depositar(numeroDeposito, valorDeposito);
                    break;
                case 4:
                    System.out.println("Digite o número da conta:");
                    String numeroSaque = scanner.next();
                    System.out.println("Digite o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    banco.sacar(numeroSaque, valorSaque);
                    break;
                case 5:
                    System.out.println("Digite o número da conta de origem:");
                    String numeroOrigem = scanner.next();
                    System.out.println("Digite o número da conta de destino:");
                    String numeroDestino = scanner.next();
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferencia = scanner.nextDouble();
                    banco.transferir(numeroOrigem, numeroDestino, valorTransferencia);
                    break;
                case 6:
                    System.out.println("Digite o número da conta:");
                    String numeroConsulta = scanner.next();
                    banco.consultarSaldo(numeroConsulta);
                    break;
                case 7:
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
