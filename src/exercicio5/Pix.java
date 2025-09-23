package exercicio5;

import java.math.BigDecimal;

public class Pix extends FormaPagamento{
    enum TipoChave { CPF, CELULAR }

    private String chave;
    private TipoChave tipo;

    Pix(TipoChave tipo, String chave) {
        this.tipo = tipo;
        this.chave = chave;
    }

    private boolean validarChave() {
        String patternCpf = "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$";
        String patternPhone = "^\\+?\\d{2}?\\s?\\d{2}?\\s?9?\\s?\\d{4}(-| )?\\d{4}$";

        if (this.tipo.equals(TipoChave.CPF)) {
            return this.chave.length() == 11 || this.chave.matches(patternCpf);
        } else if (this.tipo.equals(TipoChave.CELULAR)) {
            return this.chave.length() == 13 || this.chave.matches(patternPhone);
        }
        return false;
    }

    @Override
    public void validarPagamento() {
        if (validarChave()) {
            System.out.println("Chave "+ this.tipo + " validada com sucesso!");
        } else {
            throw new ChaveInvalidaException("Chave inválida, não é possível prosseguir!");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            validarPagamento();
            System.out.println("Pagamento no valor de R$ " + valor + " processado com sucesso!");
        } else {
            throw new PagamentoInvalidoException("Valor de pagamento deve ser maior que 0.");
        }
    }
}
