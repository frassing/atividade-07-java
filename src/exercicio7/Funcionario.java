package exercicio7;

public class Funcionario implements Identificavel<Integer>{
    private final Integer id;
    private String nome;
    private double salario;

    public Funcionario(Integer id, String nome, double salario) {
        this.id = id;
        setNome(nome);
        setSalario(salario);
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
            throw new IllegalArgumentException("O nome do funcionário não pode estar vazio.");
        }
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário deve ser maior ou igual a zero");
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionário: {" + "id=" + id +", nome='" + nome + "', salário=R$ " + salario + " }";
    }
}
