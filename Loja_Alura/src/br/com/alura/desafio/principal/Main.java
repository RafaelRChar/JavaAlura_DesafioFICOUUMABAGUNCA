package br.com.alura.desafio.principal;

import br.com.alura.desafio.bancario.Cartao;
import br.com.alura.desafio.produto.ItemDeVenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leituraDeCartao = new Scanner(System.in);
        List<Cartao> listaDeCartoes = new ArrayList<>();
        List<ItemDeVenda> listaDeItensDeVenda = new ArrayList<>();
        Cartao cartaoAtual = null;
        while (true) {
            System.out.println(" == Opções para Cartão == ");
            String opcoesEmNumerosMenu =
                    """
                            1- Cadastrar cartão;
                            2- Escolher cartão:
                            3- Fazer comprar:
                            4- Eliminar cartão:
                            5- Mostrar Produtos:
                            6- Sair
                            =======
                            """;
            System.out.println(opcoesEmNumerosMenu);
            int opcoesMenu;
            opcoesMenu = leituraDeCartao.nextInt();
            switch (opcoesMenu) {
                case 1:
                    //Registro do cartão:
                    System.out.println("- > Digite o número do cartão: ");
                    int numeroCartao = leituraDeCartao.nextInt();
                    //Para consumir quebra de linha, estava dando problema :(
                    leituraDeCartao.nextLine();
                    System.out.println("- > Digite o nome do titular: ");
                    String nomeTitular = leituraDeCartao.nextLine();
                    System.out.println("- > Digite codigo de segurança (AAA): ");
                    String codigoDeSeguranca = leituraDeCartao.nextLine();
                    System.out.println("- > Digite o limite do cartão: ");
                    float limitedoCartao = leituraDeCartao.nextFloat();
                    leituraDeCartao.nextLine();
                    //Para consumir quebra de linha, estava dando problema :(
                    // Usando todas as variáveis que foram usadas no scanner para construir o cartão;
                    Cartao novoCartao = new Cartao(numeroCartao, nomeTitular, codigoDeSeguranca, limitedoCartao);
                    System.out.println("\n === Cartão cadastrado com sucesso! === \n");
                    listaDeCartoes.add(novoCartao);
                    break;
                case 2:
                    System.out.println("== Opções de Cartões: ");
                    //Fazendo o for com base no tamanho da lista;
                    for (int i = 0; i < listaDeCartoes.size(); i++) {
                        Cartao cartao = listaDeCartoes.get(i);
                        System.out.println((i + 1) + ": Número: " + cartao.getNumeroDoCartao() + ", Titular: " + cartao.getNomeDoTitular());
                    }
                    System.out.println("\n == Escolha um cartão pelo número: ");
                    //A Lista começa de um 0 então tem que tirar um;
                    int escolhaDeCartao = leituraDeCartao.nextInt() - 1;
                    if (escolhaDeCartao >= 0 && escolhaDeCartao < listaDeCartoes.size()) {
                        cartaoAtual = listaDeCartoes.get(escolhaDeCartao);
                        System.out.println("\n == Cartão: [" + (escolhaDeCartao + 1) + "] Escolhido com sucesso! == \n");
                    } else {
                        System.out.println("\n == Opção Inválida! == \n");
                    }
                    break;
                case 3:
                    if (cartaoAtual != null) {
                        System.out.println("- > Nome do Produto: ");
                        leituraDeCartao.nextLine(); // Consumir quebra de linha pendente (Eu não entendi muito bem até agora como funciona)1
                        String nomeProduto = leituraDeCartao.nextLine();
                        System.out.println("- > Preço do produto: ");
                        double precoProduto = leituraDeCartao.nextDouble();
                        leituraDeCartao.nextLine(); // Consumir quebra de linha pendente
                        ItemDeVenda itemAtual = new ItemDeVenda(nomeProduto, precoProduto);
                        if (cartaoAtual.getLimite() >= precoProduto) {
                            cartaoAtual.debitarSaldo(precoProduto);
                            System.out.println("\n == Compra realizada com sucesso! == \n == Saldo restante: " + cartaoAtual.getLimite() + " == \n");
                            listaDeItensDeVenda.add(itemAtual);
                        } else {
                            System.out.println("Sem limite. Não foi possível realizar a compra.");
                        }
                    } else {
                        System.out.println("\n  == Selecione um cartão primeiro na opção 2! == \n");
                    }
                    break;
                case 4:
                    System.out.println(" == Escolha um cartão para apagar: ");
                    for (int i = 0; i < listaDeCartoes.size(); i++) {
                        Cartao cartao = listaDeCartoes.get(i);
                        System.out.println((i + 1) + ": Número: " + cartao.getNumeroDoCartao() + ", Titular: " + cartao.getNomeDoTitular());
                    }
                    System.out.println("\n == Digite o número do cartão a ser eliminado: ");
                    int indiceEliminar = leituraDeCartao.nextInt() - 1;
                    if (indiceEliminar >= 0 && indiceEliminar < listaDeCartoes.size()) {
                        listaDeCartoes.remove(indiceEliminar);
                        System.out.println("\n  == Cartão eliminado com sucesso!! == \n");
                    } else {
                        System.out.println("\n == Opção Inválida! == \n");
                    }
                    break;
                case 5:
                    if (listaDeItensDeVenda.isEmpty()) {
                        System.out.println("\n == Você não tem itens! == \n");
                    } else {
                        for (ItemDeVenda item : listaDeItensDeVenda) {
                            System.out.println("======");
                            System.out.println(item);
                            System.out.println("======");
                        }

                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    leituraDeCartao.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        }
    }
}