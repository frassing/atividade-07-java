package exercicio4;

public class Bicicleta implements IMeioTransporte{
    private int velocidade;
    private final int limiteVelocidadeMaxima;

    public Bicicleta() {
        this.velocidade = 0;
        this.limiteVelocidadeMaxima = 30;
    }

    @Override
    public void acelerar() {
        if (this.velocidade < this.limiteVelocidadeMaxima) {
            this.velocidade += 2;
            System.out.println("Acelerando bicicleta... Velocidade atual:" + this.velocidade);
        } else {
            throw new VelocidadeInvalidaException("Limite de velocidade atingido!");
        }
    }

    @Override
    public void frear() {
        if (this.velocidade > 0) {
            this.velocidade -= 2;
            System.out.println("Desacelerando bicicleta... Velocidade atual: " + this.velocidade);
        } else {
            throw new VelocidadeInvalidaException("Bicicleta já está parada!");
        }
    }
}
