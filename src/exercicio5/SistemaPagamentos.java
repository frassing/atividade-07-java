package exercicio5;

import java.math.BigDecimal;

import static exercicio5.Pix.TipoChave.CELULAR;
import static exercicio5.Pix.TipoChave.CPF;

public class SistemaPagamentos {
    public static void main(String[] args) {
        try {
//            FormaPagamento pixCpf = new Pix(CPF, "0123456729"); // Chave com número faltando
//            pixCpf.processarPagamento(new BigDecimal("43.20"));

            FormaPagamento pixCelular = new Pix(CELULAR, "+5592988776655");
            pixCelular.processarPagamento(new BigDecimal("45.00"));

            FormaPagamento cartaoC = new CartaoCredito("12345678901234");
            cartaoC.processarPagamento(new BigDecimal("230"));

            FormaPagamento boleto = new Boleto("34191090081234567890123456789012398760000010000");
            boleto.processarPagamento(new BigDecimal("180.32"));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
