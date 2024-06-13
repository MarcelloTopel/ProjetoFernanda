package j;

public class ContaCorrente extends ContaBancaria {
    private double taxaDeOperacao;

    public ContaCorrente(String numero, String titular, double saldoInicial, double taxaDeOperacao) {
        super(numero, titular, saldoInicial);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + taxaDeOperacao;
        return super.sacar(valorTotal);
    }

    @Override
    public boolean transferir(ContaBancaria contaDestino, double valor) {
        double valorTotal = valor + taxaDeOperacao;
        return super.transferir(contaDestino, valorTotal);
    }
}
