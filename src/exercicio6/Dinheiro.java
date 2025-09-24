package exercicio6;

import java.math.BigDecimal;
import java.util.Objects;

public record Dinheiro(BigDecimal valor, Moeda moeda) {
    public Dinheiro {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return Objects.equals(valor, dinheiro.valor) && moeda == dinheiro.moeda;
    }

}
