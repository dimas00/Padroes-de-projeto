package br.ufsm.politecnico.csi.pp.parte2.exercicio2c;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PoolGenerico<T> implements Pool<T> {

    private Class<T> tipo;
    private List<T> objetosCriados = new ArrayList<T>();
    private List<T> objetosDisponiveis = new ArrayList<T>();

    @SneakyThrows
    public PoolGenerico(Class<T> tipo) {
        this.tipo = tipo;
        for (int i = 0; i < 3; i++) {
            T obj = tipo.newInstance();
            objetosCriados.add(obj);
            objetosDisponiveis.add(obj);
        }
    }

    @SneakyThrows
    @Override
    public T acquire() {
        synchronized (objetosDisponiveis) {
            if (objetosDisponiveis.isEmpty()) {
                if (objetosCriados.size() < 20) {
                    T obj = tipo.newInstance();
                    objetosCriados.add(obj);
                    return obj;
                } else {
                    System.out.println("pool esgotado.");
                    while (objetosDisponiveis.isEmpty()) {
                        objetosDisponiveis.wait();
                    }
                    return objetosDisponiveis.remove(0);
                }
            } else {
                return objetosDisponiveis.remove(0);
            }
        }
    }

    @Override
    public void release(T t) {
        if (!objetosCriados.contains(t)) {
            throw new IllegalArgumentException("objeto nao foi criado por este pool.");
        }
        synchronized (objetosDisponiveis) {
            objetosDisponiveis.add(t);
            if (objetosDisponiveis.size() == 1) {
                objetosDisponiveis.notify();
            }
        }
    }

    public static void main(String[] args) {
        PoolGenerico<Object> pool = new PoolGenerico<>(Object.class);
        Executor executor = Executors.newCachedThreadPool();
        Random random = new Random();
        IntStream.range(0, 22).forEach(i -> {
            executor.execute(() -> {
                while (true) {
                    Object l = pool.acquire();
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) { }
                    pool.release(l);
                }
            });
        });
    }

}
