package br.com.alura.desafio.produto;

public class ItemDeVenda {
    private String nome;
    private double valor;

    public ItemDeVenda(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  "\n Nome do Produto: " + nome +
                "\n Valor: " + valor;
    }
}
