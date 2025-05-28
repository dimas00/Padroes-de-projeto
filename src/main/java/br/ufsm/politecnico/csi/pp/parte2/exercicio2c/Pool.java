package br.ufsm.politecnico.csi.pp.parte2.exercicio2c;

public interface Pool<T> {
    T acquire();
    void release(T t);
}
