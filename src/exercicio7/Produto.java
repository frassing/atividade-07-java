package exercicio7;

public class Produto implements Identificavel<Integer> {
    private final Integer id;
    private String nome;
    private double preco;

    public Produto(Integer id, String nome, double preco) {
        this.id = id;
        setNome(nome);
        setPreco(preco);
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode estar vazio");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço do produto deve ser igual ou maior que zero");
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto: { id=" + id +", nome='" + nome + "', preço=R$ " + preco + " }";
    }
}
