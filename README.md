# Lista de Exercícios 07
## ☕ Praticando com Java.
Este repositório contém a resolução de uma série de exercícios práticos de Programação Orientada a Objetos (POO) em Java, abordando desde conceitos fundamentais como encapsulamento até padrões de projeto como Strategy.

Cada exercício possui seu próprio pacote e um arquivo main para demonstração que inclui alguns casos de sucesso e de falhas.

## 🎯 Objetivos de Aprendizado

- Aplicar princípios de POO (encapsulamento, herança, polimorfismo, abstração).
- Exercitar boas práticas como imutabilidade e uso de generics.
- Trabalhar com tratamento de exceções e validações de regra de negócio.
- Introdução a padrões de projeto (Strategy).

## ✒️ Resumo dos exercícios
### Exercício 1 — Encapsulamento (Classe Produto)
- Implementação da classe Produto com atributos privados e validações.
- Uso de getters/setters com regras de negócio.
- Tratamento de casos inválidos via IllegalArgumentException.

### Exercício 2 — Encapsulamento com Validação de Regra (Desconto)
- Extensão da classe Produto com método aplicarDesconto(double porcentagem).
- Restrições de desconto (0 a 50%).
- Exceções personalizadas (IllegalArgumentException ou DescontoInvalidoException).

### Exercício 3 — Herança (Hierarquia de Funcionários)
- Classe base Funcionario e subclasses Gerente e Desenvolvedor.
- Implementação de calcularBonus() com porcentagens diferentes.
- Uso de List<Funcionario> para demonstrar polimorfismo.
 
### Exercício 4 — Polimorfismo com Interface (IMeioTransporte)
- Interface IMeioTransporte com métodos acelerar() e frear().
- Implementações: Carro, Bicicleta, Trem.

### Exercício 5 — Abstração (Sistema de Pagamentos)
- Classe abstrata FormaPagamento com métodos de validação e processamento.
- Subclasses: CartaoCredito, Boleto, Pix.
- Tratamento de erros de validação via exceções específicas.

### Exercício 6 — Imutabilidade e Objetos de Valor (Carrinho de Compras)
- Objeto de valor imutável Dinheiro com BigDecimal e Moeda.
- Modelagem de Produto, ItemCarrinho e Carrinho imutável.
- Operações retornam novos objetos.

### Exercício 7 — Generics (Repositório Genérico em Memória)
- Interface IRepository<T, ID> com operações CRUD.
- Implementação InMemoryRepository baseada em Map.
- Uso de Optional e exceções personalizadas (EntidadeNaoEncontradaException).

### Exercício 8 — Padrão Strategy (Cálculo de Frete com Lambdas)
- Interface CalculadoraFrete com diferentes estratégias (Sedex, Pac, RetiradaNaLoja).
- Injeção e troca de estratégias em tempo de execução.
- Estratégia promocional via lambda.

## 📂 Estrutura do repositório
```
atividade-07-java/
 └─ src/
     ├─ exercicio1e2/
     │   ├─ MainProduto.java
     │   ├─ ...
     ├─ exercicio3/
     │   ├─ MainFuncionario.java
     │   ├─ ...
     ├─ exercicio4/
     │   ├─ MainTransporte.java
     │   ├─ ...     
     ├─ exercicio5/
     │   ├─ MainPagamentos.java
     │   ├─ ...     
     ├─ exercicio6/
     │   ├─ MainCarrinho.java
     │   ├─ ...     
     ├─ exercicio7/
     │   ├─ MainRepository.java
     │   ├─ ...
     ├─ exercicio8/
     │   ├─ MainStrategy.java
     │   ├─ ...
     └─ README.md (está aqui)
```

## 🛠️ Como executar:
- Faça o fork do repositório para o seu perfil do GitHub e clone-o, ou apenas faça o clone deste repositório direto para a sua máquina e siga uma das opções abaixo:

### A partir de alguma IDE
- Após possuir a pasta do projeto no seu computador, importe/abra o projeto na IDE de sua preferência (Recomendado IntelliJ);
- Cada pacote dentro da pasta `src` possui o seu arquivo Main*, navegue até o arquivo Main desejado e abra-o;
- A própria IDE deve possuir um comando/botão de "Run"/"Run this file", no caso do IntelliJ, certifique-se que a opção à esquerda do botão Run esteja como "Current File".

### Compilar todos os arquivos de uma vez
- No terminal, navegue até a pasta raiz do projeto `atividade-07-java`;
- Digite o comando `javac -d out src/*/*.java` para compilar todos os arquivos de todos os pacotes;
- Depois, é só escolher qual exercício deseja executar: `java -cp out nomeDoPacote.MainDoExercicio`;
- Exemplo: `java -cp out exercicio3.MainFuncionario` ou `java -cp out exercicio8/MainStrategy`

### Compilar e executar os pacotes separadamente
- No terminal, navegue até a pasta raiz do projeto `atividade-07-java`;
- Digite o comando `javac -d out src/nomeDoPacote/*.java` para compilar todos os arquivos java do pacote indicado. Exemplo: `javac -d out src/exercicio1e2/*.java` ou `javac -d out src/exercicio4/*.java`;
- Depois, é só executar: `java -cp out nomeDoPacote.MainDoExercicio`. Exemplo: `java -cp out exercicio3.MainFuncionario` ou `java -cp out exercicio8.MainStrategy`