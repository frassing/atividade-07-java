package exercicio4;

public interface IMeioTransporte {
    void acelerar() throws VelocidadeInvalidaException;

    void frear() throws VelocidadeInvalidaException;
}
