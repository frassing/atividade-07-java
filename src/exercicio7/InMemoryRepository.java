package exercicio7;

import java.util.*;

// Classe concreta que implementa o contrato (IRepository)
// Para se manter genérica também indica que recebe entidades T que estendem Identificavel e têm um ID do mesmo tipo usado no Repository
public class InMemoryRepository  <T extends Identificavel<ID>, ID> implements IRepository<T,ID> {
    private Map<ID, T> repositorio = new HashMap<>();

    @Override
    public void salvar(T entidade) {
        repositorio.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(repositorio.get(id));
    }

    @Override
    public List<T> buscarTodos() {
        return List.copyOf(repositorio.values());
    }

    @Override
    public void remover(ID id) throws EntidadeNaoEncontradaException {
        if (!repositorio.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Não foi possível remover, registro não encontrado!");
        }
        repositorio.remove(id);
    }
}
