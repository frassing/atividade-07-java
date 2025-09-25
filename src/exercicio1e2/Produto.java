package exercicio1e2;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    Produto(String nome, double preco, int quantidadeEmEstoque) {
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty() || nome == null) throw new IllegalArgumentException("O nome do produto não pode estar vazio.");
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço deve ser maior que zero.");
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) throw new DescontoInvalidoException("Valor inválido! Desconto deve ser entre 0 e 50.");
        setPreco(this.preco - (this.preco * porcentagem/100));
    }
}
