package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import java.util.Random;

public class TesteBanco {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();
        Random rand = new Random();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10_000_00; i++) {
            banco.criaConta(((Integer) rand.nextInt()).toString(), 1000.0, 1000.0, Banco.TipoConta.CONTA_CORRENTE);
        }
        System.out.println("Tempo de inserção: " + (System.currentTimeMillis() - time) + "ms.");
        time = System.currentTimeMillis();
        for (ContaBancaria conta : banco.getContas().values()) {
            ContaBancaria cnt = banco.getContas().get(conta.getNumero());
            //System.out.println(cnt);
        }
        System.out.println("Tempo de busca e varredura: " + (System.currentTimeMillis() - time) + "ms.");
    }
}
