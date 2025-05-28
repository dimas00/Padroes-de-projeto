package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

public class ContaBancariaFactory {

    private ContaBancariaFactory() { }
    private static ContaBancariaFactory instance;

    public static ContaBancariaFactory getInstance() {
        synchronized (ContaBancariaFactory.class) {
            if (instance == null) {
                instance = new ContaBancariaFactory();
            }
        }
        return instance;
    }

    public ContaBancaria getContaBancaria(Banco.TipoConta tipo) {
        return tipo.getCreator().create();
    }

}
