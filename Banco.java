package ProjetoFernanda;

import java.util.HashMap;

public class Banco {
    private HashMap<String, ContaBancaria> contas;

    public Banco() {
        contas = new HashMap<>();
    }

    public boolean criarContaCorrente(String numero, String titular, double saldoInicial, double taxaDeOperacao) {
        if (!contas.containsKey(numero)) {
            ContaCorrente novaConta = new ContaCorrente(numero, titular, saldoInicial, taxaDeOperacao);
            contas.put(numero, novaConta);
            return true;
        } else {
            return false;
        }
    }

    public boolean criarContaPoupanca(String numero, String titular, double saldoInicial, double taxaDeJuros) {
        if (!contas.containsKey(numero)) {
            ContaPoupanca novaConta = new ContaPoupanca(numero, titular, saldoInicial, taxaDeJuros);
            contas.put(numero, novaConta);
            return true;
        } else {
            return false;
        }
    }

    public ContaBancaria buscarConta(String numero) {
        return contas.get(numero);
    }

    public void consultarSaldo(String numero) {
        ContaBancaria conta = buscarConta(numero);
        if (conta != null) {
            System.out.println("Saldo atual da conta " + numero + ": " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void depositar(String numero, double valor) {
        ContaBancaria conta = buscarConta(numero);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso. Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar(String numero, double valor) {
        ContaBancaria conta = buscarConta(numero);
        if (conta != null) {
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso. Saldo atual: " + conta.getSaldo());
            } else {
                System.out.println("Saldo Insuficiente.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void transferir(String numeroOrigem, String numeroDestino, double valor) {
        ContaBancaria contaOrigem = buscarConta(numeroOrigem);
        ContaBancaria contaDestino = buscarConta(numeroDestino);
        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.transferir(contaDestino, valor)) {
                System.out.println("Transferência realizada com sucesso. Saldo atual da conta de origem: " + contaOrigem.getSaldo());
            } else {
                System.out.println("Saldo Insuficiente na conta de origem.");
            }
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }
}
