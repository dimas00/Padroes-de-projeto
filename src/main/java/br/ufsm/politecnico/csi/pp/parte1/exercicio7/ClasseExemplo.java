package br.ufsm.politecnico.csi.pp.parte1.exercicio7;

import java.util.List;

public class ClasseExemplo {

    private Integer id;
    private String nome;
    private Double saldo;
    private String cpf;
    private List<List<String>> chaves;
    private OutraClasse outraClasse;

    @JSON
    public OutraClasse getOutraClasse() {
        return outraClasse;
    }

    public void setOutraClasse(OutraClasse outraClasse) {
        this.outraClasse = outraClasse;
    }

    @JSON
    public List<List<String>> getChaves() {
        return chaves;
    }

    public void setChaves(List<List<String>> chaves) {
        this.chaves = chaves;
    }

    @JSON
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JSON
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JSON
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @JSON
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
