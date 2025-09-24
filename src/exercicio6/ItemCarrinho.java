package exercicio6;

import java.math.BigDecimal;

public class ItemCarrinho {
    private final Produto produto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemCarrinho(Produto produto) {
        this.produto = produto;
        setQuantidade(1);
        setSubtotal(produto, quantidade);
    }

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        setQuantidade(quantidade);
        setSubtotal(produto, quantidade);
    }

    public String getNomeProduto() {
        return this.produto.getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade > 0 && quantidade <= produto.getQuantidadeEmEstoque()) {
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade inválida!");
        }
    }

    public void setSubtotal(Produto produto, int quantidade) {
        this.subtotal = produto.getPreco().valor().multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "Produto: %s - Quantidade: %d - Subtotal: %s".formatted(getNomeProduto(), getQuantidade(), getSubtotal());
    }
}
