package exercicio8;

import java.math.BigDecimal;

public class Pedido {
    private String cepDestino;
    private double pesoKg;
    private CalculadoraFrete freteStrategy;
    private BigDecimal valorPedido;
    private BigDecimal valorTotalFrete;
    private BigDecimal valorTotal;

    public Pedido(String cepDestino, BigDecimal valorPedido, double pesoKg, CalculadoraFrete freteStrategy) {
        if (cepDestino.isEmpty() || !cepDestino.matches("\\d{5}-?\\d{3}")) {
            throw new CepInvalidoException("Cep não reconhecido, verifique os dados.");
        }
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior do que 0.");
        }
        setCepDestino(cepDestino);
        setValorPedido(valorPedido);
        setPesoKg(pesoKg);
        setFreteStrategy(freteStrategy);
        setValorTotalFrete(BigDecimal.ZERO);
        setValorTotal(BigDecimal.ZERO);
    }

//    Alterar o tipo de estratégia de frete
    public void setFreteStrategy(CalculadoraFrete freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

//    Utilizar a estratégia para calcular o valorTotalFrete
    public void calcularFrete() {
        setValorTotalFrete(freteStrategy.calcular(this));
        setValorTotal(valorTotalFrete.add(valorPedido));
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public BigDecimal getValorTotalFrete() {
        return valorTotalFrete;
    }

    public void setValorTotalFrete(BigDecimal valorTotalFrete) {
        this.valorTotalFrete = valorTotalFrete;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
