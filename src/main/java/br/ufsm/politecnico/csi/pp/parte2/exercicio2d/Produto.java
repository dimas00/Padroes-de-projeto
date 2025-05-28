package br.ufsm.politecnico.csi.pp.parte2.exercicio2d;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Produto implements Cloneable {

    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String categoria;
    @Getter
    @Setter
    private Double preco;
    @Getter
    private Map<String, String> outrosAtributos = new HashMap<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Produto p = (Produto) super.clone();
        p.outrosAtributos = new HashMap<>();
        p.outrosAtributos.putAll(this.outrosAtributos);
        return p;
    }

    public void addAtributo(String nome, String valor) {
        outrosAtributos.put(nome, valor);
    }

}
