package exercicio8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sedex implements CalculadoraFrete{
    @Override
    public BigDecimal calcular(Pedido pedido) {
        BigDecimal basePeso;
        if (pedido.getPesoKg() < 1) {
            basePeso = new BigDecimal("1.4");
        } else if(pedido.getPesoKg() <= 10) {
            basePeso = new BigDecimal("3.60");
        } else if (pedido.getPesoKg() < 20) {
            basePeso = new BigDecimal("6.80");
        } else {
            basePeso = new BigDecimal("8.23");
        }
        return new BigDecimal("12.5").multiply(basePeso).setScale(2, RoundingMode.HALF_EVEN);
    }
}
