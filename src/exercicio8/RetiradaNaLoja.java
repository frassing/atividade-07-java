package exercicio8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RetiradaNaLoja implements CalculadoraFrete{
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    }
}
