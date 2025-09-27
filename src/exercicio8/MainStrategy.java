package exercicio8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainStrategy {
    public static void main(String[] args) {
        try {
            Pedido p1 = new Pedido("00000-000", new BigDecimal("20"), 0.83, new RetiradaNaLoja());
            Pedido p2 = new Pedido("11111111", new BigDecimal("180"), 3, new Pac());

            System.out.println("SITUAÇÃO 1 - Calcular valor do Frete com estratégia RETIRADA NA LOJA");
            p1.calcularFrete();
            System.out.println("Valor frete: R$ " + p1.getValorTotalFrete());
            System.out.println("Estratégia 'Retirada na loja' tem frete gratuito!");

            System.out.println("\nSITUAÇÃO 2 - Calcular valor do Frete com estratégia PAC");
            p2.calcularFrete();
            System.out.println("Valor do pedido (sem o valor de frete) R$ " + p2.getValorPedido());
            System.out.println("Valor do frete: R$ " + p2.getValorTotalFrete());
            System.out.println("Valor total do pedido: R$ " + p2.getValorTotal());

            System.out.println("\nSITUAÇÃO 3 - Mudança de estratégia: De PAC para SEDEX");
            p2.setFreteStrategy(new Sedex());
            p2.calcularFrete();
            System.out.println("Valor do pedido (sem o valor de frete) R$ " + p2.getValorPedido());
            System.out.println("Valor do frete após mudança de estratégia: R$ " + p2.getValorTotalFrete());
            System.out.println("Valor total do pedido: R$ " + p2.getValorTotal());

//            Estratégia Promocional via lambda
            BigDecimal minimoValorPromo = new BigDecimal("150.00");
            CalculadoraFrete padraoPac = new Pac();
            CalculadoraFrete fretePromocional = pedido -> {
                if (pedido.getValorPedido().compareTo(minimoValorPromo) >= 0) {
                    return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
                } else {
                    return padraoPac.calcular(pedido);
                }
            };

            System.out.println("\nSITUAÇÃO 4 - Frete Promocional (Grátis para valores acima de R$ 150,00)");
            p2.setFreteStrategy(fretePromocional);
            p2.calcularFrete();
            System.out.println("Valor pedido: R$ " + p2.getValorPedido());
            System.out.println("Valor do frete com estratégia 'frete promocional': R$ " + p2.getValorTotalFrete());
            System.out.println("Valor total do pedido: R$ " + p2.getValorTotal());


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 5 - Tentar usar um cep com 7 números");
            Pedido p3 = new Pedido("1234567", new BigDecimal("82"),3,new Pac());
        } catch (CepInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 6 - Tentar usar peso de pedido menor ou igual a 0.");
            Pedido p4 = new Pedido("12345678", new BigDecimal("50"),0, new RetiradaNaLoja());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
