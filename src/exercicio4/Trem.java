package exercicio4;

public class Trem implements IMeioTransporte{
    private int velocidade;
    private final int limiteVelocidadeMaxima;

    public Trem() {
        this.velocidade = 0;
        this.limiteVelocidadeMaxima = 80;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidadeMaxima) {
            this.velocidade += 5;
            System.out.println("Acelerando trem... Velocidade atual: " + this.velocidade);
        } else {
            throw new VelocidadeInvalidaException("Trem já está na velocidade máxima permitida!");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            this.velocidade -= 5;
            System.out.println("Desacelerando trem... Velocidade atual: " + this.velocidade);
        } else {
            throw new VelocidadeInvalidaException("O trem já está parado.");
        }
    }
}
