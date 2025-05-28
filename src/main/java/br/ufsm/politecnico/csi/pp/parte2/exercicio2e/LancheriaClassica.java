package br.ufsm.politecnico.csi.pp.parte2.exercicio2e;

public class LancheriaClassica {

    private Builder builder = new BuilderPastel();


    public Lanche getCalabreza() {
        builder.colocaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaCalabreza();
        return builder.constroi();
    }

    public Lanche getQuatroQueijos() {
        builder.colocaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaQueijoPrato();
        builder.colocaQueijoProvolone();
        builder.colocaQueijoCatupiry();
        return builder.constroi();
    }

    public Lanche getTomateSecoRucula() {
        builder.colocaMassa();
        builder.colocaMolhoTomate();
        builder.colocaQueijoMucarela();
        builder.colocaTomateSeco();
        builder.colocaRucula();
        return builder.constroi();
    }

}
