package br.com.softplan.desafiojava8.transformacaostreams.entity;

import java.util.List;

public class Funcionario {
    private String nome;
    private Double salario;
    private Boolean gerente;
    private List<Dependente> dependentes;
    public Funcionario(String nome, Double salario, Boolean gerente, List<Dependente> dependentes) {
        super();
        this.nome = nome;
        this.salario = salario;
        this.gerente = gerente;
        this.dependentes = dependentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean isGerente() {
        return gerente;
    }

    public void setGerente(Boolean gerente) {
        this.gerente = gerente;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", salario=" + salario + "]";
    }

}
