package exercicio4;

public class Carro implements IMeioTransporte{
    private int velocidade;
    private final int limiteVelocidadeMaxima;

    public Carro() {
        this.velocidade  = 0;
        this.limiteVelocidadeMaxima = 120;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidadeMaxima) {
            this.velocidade += 15;
            System.out.println("Acelerando o carro... Velocidade atual: " + this.velocidade);
        } else {
            throw new VelocidadeInvalidaException("Velocidade máxima atingida!");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            this.velocidade -= 15;
            System.out.println("Desacelerando o carro... Velocidade atual: " + this.velocidade);
        } else {
            throw new VelocidadeInvalidaException("Carro parado, não é possível diminuir a velocidade");
        }
    }
}
