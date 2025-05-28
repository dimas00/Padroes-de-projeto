package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import java.util.List;

public class Serasa implements Observer{
    private List<ContaBancaria> contasNegativadas;

    @Override
    public void update(ContaBancaria conta) {
        contasNegativadas.add(conta);
    }
}
