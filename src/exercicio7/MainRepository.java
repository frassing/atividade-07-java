package exercicio7;


public class MainRepository {
    public static void main(String[] args) {
        try {
            IRepository<Funcionario, Integer> funcionarios = new InMemoryRepository<>();
            Funcionario f1 = new Funcionario(0,"Luana da Silva", 4500);
            Funcionario f2 = new Funcionario(1, "Murilo Oliveira", 4500);

            funcionarios.salvar(f1);
            funcionarios.salvar(f2);

            System.out.println("SITUAÇÃO 1 - Funcionários salvos no repositório com sucesso");
            System.out.println("Buscar todos: " + funcionarios.buscarTodos());

            Funcionario funcBuscaSucesso = funcionarios.buscarPorId(1).orElseThrow(() -> new EntidadeNaoEncontradaException("Registro não encontrado, verifique o id."));
            System.out.println("\nSITUAÇÃO 2 - Busca por ID com sucesso");
            System.out.println("Busca id: 1 -> " + funcBuscaSucesso);

        } catch(IllegalArgumentException | EntidadeNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        try {
            IRepository<Produto, Integer> produtos = new InMemoryRepository<>();
            Produto p1 = new Produto(11, "Caderno A5 Pautado 100fls", 12.30);
            Produto p2 = new Produto(12, "Caderno A4 Pautado 250fls", 18.00);

            produtos.salvar(p1);
            produtos.salvar(p2);

            System.out.println("\nSITUAÇÃO 3 - Buscar id inexistente");
            System.out.println("Produtos salvos: " + produtos.buscarTodos());
            Produto prodBuscaFalha = produtos.buscarPorId(3).orElseThrow(() -> new EntidadeNaoEncontradaException("Registro não encontrado, verifique o id."));
            System.out.println("Busca id: 3:");
            System.out.println(prodBuscaFalha);

        } catch (EntidadeNaoEncontradaException e ) {
            System.out.println(e.getMessage());
        }

        try {
            IRepository<Produto, Integer> produtos = new InMemoryRepository<>();
            Produto p1 = new Produto(11, "Caderno A5 Pautado 100fls", 12.30);
            Produto p2 = new Produto(12, "Caderno A4 Pautado 250fls", 18.00);

            produtos.salvar(p1);
            produtos.salvar(p2);

            System.out.println("\nSITUAÇÃO 4 - Tentar remover id inexistente");
            System.out.println("Produtos salvos: " + produtos.buscarTodos());
            System.out.println("Remover id: 5:");
            produtos.remover(5);

        } catch (EntidadeNaoEncontradaException e ) {
            System.out.println(e.getMessage());
        }

        try {
            IRepository<Produto, Integer> produtos = new InMemoryRepository<>();
            Produto p1 = new Produto(11, "Caderno A5 Pautado 100fls", 12.30);
            Produto p2 = new Produto(12, "Caderno A4 Pautado 250fls", 18.00);

            produtos.salvar(p1);
            produtos.salvar(p2);

            System.out.println("\nSITUAÇÃO 5 - Remover id existente na lista");
            System.out.println("Produtos salvos: " + produtos.buscarTodos());
            System.out.println("Remover id: 11:");
            produtos.remover(11);
            System.out.println("Produtos após remoção: " + produtos.buscarTodos());

        } catch (EntidadeNaoEncontradaException e ) {
            System.out.println(e.getMessage());
        }
    }
}
