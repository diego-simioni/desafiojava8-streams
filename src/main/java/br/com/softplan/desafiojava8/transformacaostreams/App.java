package br.com.softplan.desafiojava8.transformacaostreams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import br.com.softplan.desafiojava8.transformacaostreams.dao.FuncionarioDAO;
import br.com.softplan.desafiojava8.transformacaostreams.entity.Funcionario;
import br.com.softplan.desafiojava8.transformacaostreams.entity.GrauParentesco;

public class App
{
    private static FuncionarioDAO dao = new FuncionarioDAO();

    public static void main( String[] args )
    {
        // o primeiro passo é pegar os dados do nosso DAO
        List<Funcionario> funcionarios = dao.getFuncionarios();

        // em seguida, aplicamos os aumentos:
        // 40% para os gerentes
        // 20% para os demais empregados
        Consumer<Funcionario> aumento40porCento = aumento(1.4);
        Consumer<Funcionario> aumento20porCento = aumento(1.2);
        Consumer<Funcionario> aplicarAumento = ifThen(f -> f.isGerente(), aumento40porCento, aumento20porCento);

        funcionarios.stream()
                    .forEach(aplicarAumento);

        // agora, precisamos mostrar na tela os empregados, ordenados pelo salário.
        // em seguida, calculamos o total da folha de pagamento
        funcionarios.stream()
                    .sorted((f1, f2) -> f1.getSalario().compareTo(f2.getSalario()))
                    .forEach(f -> System.out.println(f));

        Double totalFolha = funcionarios.stream()
                                        .map(f -> f.getSalario())
                                        .reduce(0.0, (a, b) -> a + b);
        System.out.println(totalFolha);

        // Para finalizar, exibimos a lista de dependentes que sejam filhos dos
        // funcionarios, que sera usada para a campanha de vacinacao
        // A lista deve ser ordenada por nome do dependente
        funcionarios.stream()
                    .flatMap(f -> f.getDependentes().stream())
                    .filter(d -> d.getParentesco() == GrauParentesco.FILHO)
                    .map(d -> d.getNome())
                    .sorted()
                    .forEach(d -> System.out.println(d));

    }

    private static Consumer<Funcionario> aumento(Double fator) {
        return f -> f.setSalario(f.getSalario() * fator);
    }

    private static Consumer<Funcionario> ifThen(Predicate<Funcionario> condicao, Consumer<Funcionario> verdadeiro,
            Consumer<Funcionario> falso) {
        return f -> {
            if (condicao.test(f)) {
                verdadeiro.accept(f);
            } else {
                falso.accept(f);
            }
        };
    }
}
