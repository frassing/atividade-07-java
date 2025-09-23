package exercicio5;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {
    private final String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() {
        if (this.numeroCartao != null && !this.numeroCartao.isEmpty() && this.numeroCartao.length() >= 13 && this.numeroCartao.length() <= 16) {
            System.out.println("Número do cartão validado com sucesso!");
        } else {
            throw new NumeroCartaoInvalidoException("O número do cartão de crédito é inválido!");
        }

    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            validarPagamento();
            System.out.println("Pagamento no valor de R$ " + valor + " processado com sucesso!");
        } else {
            throw new PagamentoInvalidoException("Não é possível prosseguir com o pagamento.");
        }
    }
}
