package exercicio5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento{
    private final String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    @Override
    public void validarPagamento() {
        if (this.codigoBarras != null && !this.codigoBarras.isEmpty() && this.codigoBarras.length() <= 48) {
            System.out.println("Código de barras válido");
        } else {
            throw new CodigoBoletoInvalidoException("Código de barras inválido, tente novamente!");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            validarPagamento();
            System.out.println("Pagamento de R$ " + valor + " processado com sucesso!");
        } else {
            throw new PagamentoInvalidoException("Não foi possível concluir o pagamento. Valores inválidos!");
        }
    }
}
