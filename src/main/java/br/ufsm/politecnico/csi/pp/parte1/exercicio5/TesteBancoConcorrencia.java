package br.ufsm.politecnico.csi.pp.parte1.exercicio5;

import br.ufsm.politecnico.csi.pp.parte1.exercicio2.Banco;

public class TesteBancoConcorrencia {

    private Banco banco = Banco.getInstance();

    public TesteBancoConcorrencia() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10_000; i1++) {
                    banco.criaConta("000.000.000-00", 1000.0, 10.0, Banco.TipoConta.CONTA_CORRENTE);
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        new TesteBancoConcorrencia();
    }

}
