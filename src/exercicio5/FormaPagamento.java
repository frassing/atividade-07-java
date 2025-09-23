package exercicio5;

import java.math.BigDecimal;

abstract class FormaPagamento {
    public abstract void validarPagamento();

    public abstract void processarPagamento(BigDecimal valor);
}
