package exercicio7;

import java.util.List;
import java.util.Optional;

// Armazena entidades T que obrigatoriamente estendem Identificavel e têm um ID que é do mesmo tipo do ID usado como chave no Repository
public interface IRepository <T extends Identificavel<ID>, ID> {
    void salvar(T entidade);

    Optional<T> buscarPorId(ID id);

    List<T> buscarTodos();

    void remover(ID id) throws EntidadeNaoEncontradaException;
}
