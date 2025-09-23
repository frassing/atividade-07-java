package exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainFuncionario {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        Funcionario gerente1 = new Gerente("Angela", new BigDecimal("12000"));
        Funcionario gerente2 = new Gerente("Bruno", new BigDecimal("10000"));
        Funcionario dev1 = new Desenvolvedor("Carla", new BigDecimal("6000"));
        Funcionario dev2 = new Desenvolvedor("Diogo", new BigDecimal("7500"));

        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(dev1);
        funcionarios.add(dev2);

        for (Funcionario func : funcionarios) {
            System.out.println("Funcionário: "+ func.getNome() + " - bônus: R$ " + func.calcularBonus());
        }
    }
}
