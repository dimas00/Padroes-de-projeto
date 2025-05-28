package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

public class Poupanca extends ContaBancaria {
    @Override
    public Double calculaIR() {
        return 0.0;
    }

    @Override
    public Double saldoDisponivel() {
        return getSaldo();
    }


}
