package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ContaCorrente extends ContaBancaria {

    public ContaCorrente() {}

    public ContaCorrente(Double limite) {
        this.limite = limite;
    }
    private Double limite;


    public boolean isEspecial() {
        return limite != null && limite > 0;
    }


    @Override
    public Double calculaIR() {
        return 0.0;
    }

    @Override
    public Double saldoDisponivel() {
        return getSaldo() + limite;
    }




}
