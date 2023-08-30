package br.com.alura.desafio.bancario;

public class Cartao {
    private int numeroDoCartao;
    private String nomeDoTitular;
    private String codigoDeSeguranca;
    private float limite;

    public Cartao(int numeroDoCartao, String nomeDoTitular, String codigoDeSeguranca, float limite) {
        this.numeroDoCartao = numeroDoCartao;
        this.nomeDoTitular = nomeDoTitular;
        this.codigoDeSeguranca = codigoDeSeguranca;
        this.limite = limite;
    }

    public int getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public float getLimite() {
        return limite;
    }

    public void debitarSaldo(double valor) {
        if (limite >= valor) {
            limite -= valor;
        } else {
            System.out.println("Valor Zerado!");
        }
    }
    @Override
    public String toString() {
        return  "\nNumero Do Cartão: " + numeroDoCartao +
                "\nNome Do Títular: " + nomeDoTitular +
                "\nCódigo De Seguranca: " + codigoDeSeguranca +
                "\nLimite: " + limite;
    }
}
