package br.com.softplan.desafiojava8.transformacaostreams.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.softplan.desafiojava8.transformacaostreams.entity.Dependente;
import br.com.softplan.desafiojava8.transformacaostreams.entity.Funcionario;
import br.com.softplan.desafiojava8.transformacaostreams.entity.GrauParentesco;

public final class FuncionarioDAO {
    public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        List<Dependente> dependentes;

        //1
        dependentes = new ArrayList<Dependente>();
        dependentes.add(new Dependente("Dona Neves", GrauParentesco.OUTRO));
        dependentes.add(new Dependente("Chiquinha", GrauParentesco.FILHO));
        funcionarios.add(new Funcionario("Seu Madruga", 1200.0, false, dependentes));

        //2
        funcionarios.add(new Funcionario("Jaiminho", 2600.0, false, new ArrayList<Dependente>()));

        //3
        dependentes = new ArrayList<Dependente>();
        dependentes.add(new Dependente("Nhonho", GrauParentesco.FILHO));
        funcionarios.add(new Funcionario("Seu Barriga", 4800.0, true, dependentes));

        //4
        dependentes = new ArrayList<Dependente>();
        dependentes.add(new Dependente("Quico", GrauParentesco.FILHO));
        dependentes.add(new Dependente("Pópis", GrauParentesco.OUTRO));
        funcionarios.add(new Funcionario("Dona Florinda", 2200.0, false, dependentes));

        //5
        funcionarios.add(new Funcionario("Professor Girafales", 3600.0, true, new ArrayList<Dependente>()));

        //6
        dependentes = new ArrayList<Dependente>();
        dependentes.add(new Dependente("Satanás (gato)", GrauParentesco.OUTRO));
        funcionarios.add(new Funcionario("Dona Clotilde", 1300.0, false, dependentes));

        //7
        dependentes = new ArrayList<Dependente>();
        dependentes.add(new Dependente("Paty", GrauParentesco.FILHO));
        funcionarios.add(new Funcionario("Glória", 3000.0, false, dependentes));


        return funcionarios;
    }
}
