package exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainFuncionario {
    public static void main(String[] args) {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();

            Funcionario gerente1 = new Gerente("Angela", new BigDecimal("12000"));
            Funcionario gerente2 = new Gerente("Bruno", new BigDecimal("10000"));
            Funcionario dev1 = new Desenvolvedor("Carla", new BigDecimal("6000"));
            Funcionario dev2 = new Desenvolvedor("Diogo", new BigDecimal("7500"));

            funcionarios.add(gerente1);
            funcionarios.add(gerente2);
            funcionarios.add(dev1);
            funcionarios.add(dev2);

            System.out.println("SITUAÇÃO 1 - Funcionários criados com sucesso!");
            for (Funcionario func : funcionarios) {
                System.out.println("Funcionário: "+ func.getNome());
            }

            System.out.println("\nSITUAÇÃO 2 - Calcular bônus com sucesso!");
            for (Funcionario func : funcionarios) {
                System.out.println("Funcionário: "+ func.getNome() + " salário: R$ " + func.getSalario() + " - bônus: R$ " + func.calcularBonus());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nSITUAÇÃO 3 - Tentar criar um funcionário com salário negativo");
            Funcionario novoGerente = new Gerente("Diana", new BigDecimal("-500"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
