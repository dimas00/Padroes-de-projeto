package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class ContaBancaria {

    @EqualsAndHashCode.Include
    private long numero;
    private String cpf;
    private double saldo;
    private Collection<MovimentacaoBancaria> movimentacoes = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addMovimentacao(MovimentacaoBancaria movimentacao) {
        movimentacoes.add(movimentacao);
    }

    public abstract Double calculaIR();

    public abstract Double saldoDisponivel();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}

