package br.ufsm.politecnico.csi.pp.parte2.exercicio2e;

public class BuilderPizza implements Builder {

    private Pizza pizza = new Pizza();

    @Override
    public void colocaMassa() {

    }

    @Override
    public void colocaMolhoTomate() {

    }

    @Override
    public void colocaQueijoMucarela() {

    }

    @Override
    public void colocaQueijoPrato() {

    }

    @Override
    public void colocaQueijoProvolone() {

    }

    @Override
    public void colocaQueijoCatupiry() {

    }

    @Override
    public void colocaCalabreza() {

    }

    @Override
    public void colocaCarne() {

    }

    @Override
    public void colocaTomateSeco() {

    }

    @Override
    public void colocaRucula() {

    }

    @Override
    public Lanche constroi() {
        pizza.assanoforno();
        return pizza;
    }
}
