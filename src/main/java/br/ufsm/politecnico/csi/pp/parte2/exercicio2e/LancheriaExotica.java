package br.ufsm.politecnico.csi.pp.parte2.exercicio2e;

public class LancheriaExotica {

    public Lanche getDaCasa(Builder builder) {
        builder.colocaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaQueijoPrato();
        builder.colocaQueijoProvolone();
        builder.colocaQueijoCatupiry();
        builder.colocaTomateSeco();
        builder.colocaRucula();
        builder.colocaCarne();
        return builder.constroi();
    }

    public Lanche getTiaLele(Builder builder) {
        builder.colocaMassa();
        builder.colocaTomateSeco();
        return builder.constroi();
    }

}
