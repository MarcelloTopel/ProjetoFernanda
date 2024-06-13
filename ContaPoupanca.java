package j;

public class ContaPoupanca extends ContaBancaria {
    private double taxaDeJuros;

    public ContaPoupanca(String numero, String titular, double saldoInicial, double taxaDeJuros) {
        super(numero, titular, saldoInicial);
        this.taxaDeJuros = taxaDeJuros;
    }

    public void aplicarJuros() {
        this.saldo += this.saldo * taxaDeJuros;
    }
}
