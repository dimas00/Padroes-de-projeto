package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Serasa implements Observer{
    private List<ContaBancaria> contasNegativadas = new ArrayList<>();

    public List<ContaBancaria> getContasNegativadas() {
        return contasNegativadas;
    }

    @Override
    public void update(ContaBancaria conta) {

        if (conta.getSaldo()<0){
            if(!contasNegativadas.contains(conta)){
                contasNegativadas.add(conta);
            }
        }else {
            contasNegativadas.remove(conta);
        }

    }
}
