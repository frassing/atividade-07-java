package exercicio6;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SistemaCarrinhoCompras {
    public static void main(String[] args) {
//        CRIAÇÃO DOS PRODUTOS
        Produto p1 = new Produto("Escova Pets", new Dinheiro(new BigDecimal("12.90"), Moeda.BRL));
        Produto p2 = new Produto("Hidratante Patinhas", new Dinheiro(new BigDecimal("19.90"), Moeda.BRL));
        Produto p3 = new Produto("Snack FN 6 unidades", new Dinheiro(new BigDecimal("29.50"), Moeda.BRL));
        Produto p4 = new Produto("Ração 3kg Gatos Castrados Sabor Carne", new Dinheiro(new BigDecimal("60.00"), Moeda.BRL));

//        ADICIONAR QUANTIDADE EM ESTOQUE PARA CADA PRODUTO
        List<Produto> loja = Arrays.asList(p1, p2, p3, p4);
        for (Produto p : loja) {
            p.setQuantidadeEmEstoque(5);
        }

//        CRIAR ITENS DO CARRINHO
        ItemCarrinho item1 = new ItemCarrinho(p1, 2);
        ItemCarrinho item2 = new ItemCarrinho(p2, 1);
        ItemCarrinho item3 = new ItemCarrinho(p2, 1);

//        INICIALIZAR CARRINHO COM CUPOM DE 5% DE DESCONTO
        Carrinho carrinho = new Carrinho(new BigDecimal("5"));

        System.out.println("Carrinho vazio:");
        System.out.println(carrinho.getItensNoCarrinho());

//        ADICIONAR ITENS AO CARRINHO
        carrinho = carrinho.adicionar(item1);
        carrinho = carrinho.adicionar(item2);
        carrinho = carrinho.adicionar(item3);

        System.out.println("\nCarrinho após adição de produtos:");
        System.out.println(carrinho.getItensNoCarrinho());
        System.out.println("Total do carrinho: " + carrinho.getValorTotal());

        carrinho = carrinho.aplicarDesconto();
        System.out.println("Total do carrinho ao aplicar desconto: " + carrinho.getValorTotal());

        System.out.println("\nRemoção do produto do carrinho:");
        carrinho = carrinho.remover(item2);
        System.out.println(carrinho.getItensNoCarrinho());
        System.out.println("Total do carrinho: " + carrinho.getValorTotal());

        carrinho = carrinho.aplicarDesconto();
        System.out.println("Total do carrinho ao aplicar desconto: " + carrinho.getValorTotal());

    }
}
