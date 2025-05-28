package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Banco {

    private Banco() {
    }

    private static Banco instance;
    public static Banco getInstance() {
        synchronized (Banco.class) {
            if (instance == null) {
                instance = new Banco();
            }
            return instance;
        }
    }

    private Map<Long, ContaBancaria> contas = new ConcurrentHashMap<>();
    private Long ultimoNumreroConta = 0L;
    private Serasa serasa = new Serasa();

    public Map<Long, ContaBancaria> getContas() {
        return contas;
    }

    public ContaBancaria criaConta(String cpf, Double saldoInicial, Double limite, TipoConta tipo) {
        if (tipo == null) return null;
        ContaBancaria conta = null;
        if (tipo == TipoConta.CONTA_CORRENTE) {
            conta = new ContaCorrente(limite);
        } else if (tipo == TipoConta.POUPANCA) {
            conta = new Poupanca();
        } else if (tipo == TipoConta.RENDA_VARIAVEL) {
            conta = new FundoRendaVariavel();
        } else if (tipo == TipoConta.RENDA_FIXA) {
            conta = new FundoRendaFixa();
        }
        conta.setCpf(cpf);
        conta.setSaldo(saldoInicial);
        conta.setNumero(++ultimoNumreroConta);
        contas.put(conta.getNumero(), conta);
        conta.addObserver(serasa);
        return conta;
    }

    public boolean excluiConta(Long numero) {
        return contas.remove(numero) != null;
    }

    public void saque(Long numero, Double valor) throws BancoException {
        if (valor < 0) throw new BancoException("valor inválido.");;
        ContaBancaria conta = contas.get(numero);
        if (conta == null) throw new BancoException("conta não inexistente com o número informado.");
        conta.addMovimentacao(new MovimentacaoBancaria(valor, MovimentacaoBancaria.TipoMovimentacao.DEBITO, "saque"));
        conta.setSaldo(conta.getSaldo() - valor);
    }

    public void deposito(Long numero, Double valor) throws BancoException {
        if (valor <= 0) throw new BancoException("valor inválido.");
        ContaBancaria conta = contas.get(numero);
        if (conta == null) throw new IllegalArgumentException("conta não inexistente com o número informado.");
        conta.setSaldo(conta.getSaldo() + valor);
        conta.addMovimentacao(new MovimentacaoBancaria(valor, MovimentacaoBancaria.TipoMovimentacao.CREDITO, "saque"));
    }

    public void transrerencia(Long numeroOrigem, Long numeroDestino, Double valor) throws BancoException {
        if (valor <= 0) throw new BancoException("valor inválido.");
        saque(numeroOrigem, valor);
        try {
            deposito(numeroDestino, valor);
        } catch (BancoException e) {
            deposito(numeroOrigem, valor);
        }
    }

    public Double getSaldo(Long numero) {
        return contas.get(numero) == null ? null : contas.get(numero).getSaldo();
    }

    public String extrato(Long numero) throws BancoException {
        ContaBancaria conta = contas.get(numero);
        if (conta == null) throw new BancoException("conta não existente.");
        StringBuilder sb = new StringBuilder();
        for (MovimentacaoBancaria movimentacao : conta.getMovimentacoes()) {
            sb.append(movimentacao.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ContaCorrente contaCorrente1 = new ContaCorrente(100.0);
        contaCorrente1.setCpf("123.456.789");
        contaCorrente1.setSaldo(200.0);
        contaCorrente1.setNumero(1234);
        ContaCorrente contaCorrente2 = new ContaCorrente(100.0);
        contaCorrente2.setCpf("123.456.789");
        contaCorrente2.setSaldo(223200.0);
        contaCorrente2.setNumero(1234);
        System.out.println(contaCorrente1.equals(contaCorrente2));
    }


    public enum TipoConta {
        CONTA_CORRENTE(ContaCorrente::new),
        POUPANCA(Poupanca::new),
        RENDA_FIXA(FundoRendaFixa::new),
        RENDA_VARIAVEL(FundoRendaVariavel::new);

        private ContaCreator creator;

        public ContaCreator getCreator() {
            return creator;
        }

        private TipoConta(ContaCreator creator) {
            this.creator = creator;
        }
    }

}
