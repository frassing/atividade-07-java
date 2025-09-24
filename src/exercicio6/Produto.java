package exercicio6;

public class Produto {
    private final String nome;
    private final Dinheiro preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, Dinheiro preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = 0;
    }

    public String getNome() {
        return nome;
    }

    public Dinheiro getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
