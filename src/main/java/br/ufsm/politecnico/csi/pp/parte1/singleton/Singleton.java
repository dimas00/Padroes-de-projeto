package br.ufsm.politecnico.csi.pp.parte1.singleton;

public class Singleton {

    private Singleton() {
    }

    private static Singleton instance;

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }

}
