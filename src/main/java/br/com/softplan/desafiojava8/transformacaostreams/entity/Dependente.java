package br.com.softplan.desafiojava8.transformacaostreams.entity;

public class Dependente {
    private String nome;
    private GrauParentesco parentesco;

    public Dependente(String nome, GrauParentesco parentesco) {
        super();
        this.nome = nome;
        this.parentesco = parentesco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrauParentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(GrauParentesco parentesco) {
        this.parentesco = parentesco;
    }
}
