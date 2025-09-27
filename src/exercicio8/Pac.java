package exercicio8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pac implements CalculadoraFrete{
    @Override
    public BigDecimal calcular(Pedido pedido) {
        BigDecimal basePeso;
        if (pedido.getPesoKg() < 1) {
            basePeso = new BigDecimal("1");
        } else if(pedido.getPesoKg() <= 5) {
            basePeso = new BigDecimal("2.43");
        } else if (pedido.getPesoKg() <= 10) {
          basePeso = new BigDecimal("3.80");
        } else if (pedido.getPesoKg() < 20) {
            basePeso = new BigDecimal("5.24");
        } else {
            basePeso = new BigDecimal("7.50");
        }

        return new BigDecimal("9").multiply(basePeso).setScale(2, RoundingMode.HALF_EVEN);
    }
}
