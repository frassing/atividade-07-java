package exercicio1e2;

public class MainProduto {
    public static void main(String[] args) {
        try {
            Produto borrachaE = new Produto("borracha escolar", 1.8, 0);

            System.out.println("SITUAÇÃO 1 - Produto criado com sucesso!");
            System.out.println("Produto: " + borrachaE.getNome());
            System.out.println("Valor: R$ " + borrachaE.getPreco());
            System.out.println("Em estoque: " + borrachaE.getQuantidadeEmEstoque());

            System.out.println("\nSITUAÇÃO 2 - Aumentar quantidade com sucesso!");
            borrachaE.setQuantidadeEmEstoque(2);
            System.out.println("Em estoque agora: " + borrachaE.getQuantidadeEmEstoque());

            System.out.println("\nSITUAÇÃO 3 - Aplicar desconto de 5% com sucesso!");
            System.out.println("Valor antes: R$ " + borrachaE.getPreco());
            borrachaE.aplicarDesconto(5);
            System.out.println("Valor após desconto: R$ " + borrachaE.getPreco());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 4 - Tentar criar produto com nome vazio");
            Produto lapiseira = new Produto("", 4.5, 8);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 5 - Tentar colocar o preço com um valor negativo");
            Produto lapiseira = new Produto("Lapiseira 0.5", -12, 8);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 6 - Tentar colocar quantidade em estoque com um valor negativo");
            Produto lapiseira = new Produto("Lapiseira 0.5", 4.20, -2);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 7 - Tentar aplicar desconto com um valor negativo");
            Produto lapiseira = new Produto("Lapiseira 0.5", 4.20, 20);
            lapiseira.aplicarDesconto(-2);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 8 - Tentar aplicar desconto com um valor acima do limite");
            Produto lapiseira = new Produto("Lapiseira 0.5", 4.20, 20);
            lapiseira.aplicarDesconto(55);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
