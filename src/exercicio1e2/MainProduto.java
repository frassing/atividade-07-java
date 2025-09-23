package exercicio1e2;

public class MainProduto {
    public static void main(String[] args) {
        try {
            Produto borrachaE = new Produto("borracha escolar", 1.8, 0);

            System.out.println("Produto: " + borrachaE.getNome());
            System.out.println("Valor: R$ " + borrachaE.getPreco());
            System.out.println("Em estoque: " + borrachaE.getQuantidadeEmEstoque());

            Produto lapiseira = new Produto("Lapiseira 0.5", 4.5, 8);
//            lapiseira.setPreco(-2);
//            lapiseira.setQuantidadeEmEstoque(-1);


            System.out.println("\n=====================");
            System.out.println("Produto: " + lapiseira.getNome());
            System.out.println("Valor: R$ " + lapiseira.getPreco());
            System.out.println("Em estoque: " + lapiseira.getQuantidadeEmEstoque());

            System.out.println("\nDescontos");
            System.out.println("Produto: " + borrachaE.getNome());
            System.out.println("Preço com 10% de desconto: R$ " + borrachaE.aplicarDesconto(10));

            System.out.println("\nProduto: " + lapiseira.getNome());
            System.out.println("Preço com 25% de desconto: R$ " + lapiseira.aplicarDesconto(25));
            System.out.println("Preço com 0% de desconto: R$ " + lapiseira.aplicarDesconto(0));
            System.out.println("Preço 50% de desconto: R$ " + lapiseira.aplicarDesconto(50));
//            System.out.println("Preço com tentativa de desconto de −5: R$ " + lapiseira.aplicarDesconto(-5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
