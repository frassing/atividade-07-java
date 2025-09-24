package exercicio6;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static exercicio6.Moeda.BRL;

public class Carrinho {
    private final List<ItemCarrinho> itensCarrinho;
    private Dinheiro valorTotal;
    private final BigDecimal cupomDesconto;

    public Carrinho() {
        this.itensCarrinho = new ArrayList<>();
        this.valorTotal = new Dinheiro(new BigDecimal("0"), BRL);
        this.cupomDesconto = new BigDecimal(BigInteger.ZERO);
    }

    public Carrinho(BigDecimal cupomDesconto) {
        if (cupomDesconto.compareTo(BigDecimal.ZERO) < 0 || cupomDesconto.compareTo(new BigDecimal("30")) > 0 ) {
            throw new CupomInvalidoException("Cupom de desconto inválido, permitido apenas entre 0 e 30%");
        }
        this.itensCarrinho = new ArrayList<>();
        this.valorTotal = new Dinheiro(new BigDecimal("0"), BRL);
        this.cupomDesconto = cupomDesconto;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal cupomDesconto, Dinheiro total) {
        this.itensCarrinho = Collections.unmodifiableList(itens);
        this.cupomDesconto = cupomDesconto;
        this.valorTotal = total;
    }

    public BigDecimal getValorTotal() {
        return valorTotal.valor();
    }

    public List<ItemCarrinho> getItensNoCarrinho() {
        return this.itensCarrinho;
    }

    public Carrinho adicionar(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itensCarrinho);
        boolean exists = novaLista.stream().anyMatch(itemCarrinho -> itemCarrinho.getNomeProduto().equals(item.getNomeProduto()));
        if (!exists) {
            novaLista.add(item);
        }
        Dinheiro novoTotal = calcularValorTotal(novaLista);
        return new Carrinho(novaLista, this.cupomDesconto, novoTotal);
    }

    public Carrinho remover(ItemCarrinho item) {
        List<ItemCarrinho> novaLista = new ArrayList<>(this.itensCarrinho);
        if (!novaLista.contains(item)) {
            throw new ItemInvalidoException("Item não encontrado no carrinho!");
        }
        novaLista.remove(item);
        Dinheiro novoTotal = calcularValorTotal(novaLista);
        return new Carrinho(novaLista, this.cupomDesconto, novoTotal);
    }

    public Carrinho aplicarDesconto() {
        BigDecimal subtotal = this.getValorTotal();
        if (this.cupomDesconto.compareTo(BigDecimal.ZERO) > 0) {
            subtotal = subtotal.subtract(subtotal.multiply(this.cupomDesconto.divide(new BigDecimal("100")))).setScale(2, RoundingMode.HALF_UP);
        }
        Dinheiro novoTotal = new Dinheiro(subtotal, BRL);
        return new Carrinho(this.itensCarrinho, this.cupomDesconto, novoTotal);
    }

    private Dinheiro calcularValorTotal(List<ItemCarrinho> itens) {
        BigDecimal subtotalCarrinho = itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new Dinheiro(subtotalCarrinho, BRL);
    }

}
