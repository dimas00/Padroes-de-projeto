package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

public class FundoRendaFixa extends ContaBancaria {

    public Double calculaIR() {
        double rendimento = 0.0;
        for (MovimentacaoBancaria movimentacaoBancaria : getMovimentacoes()) {
            if (movimentacaoBancaria.getTipo() == MovimentacaoBancaria.TipoMovimentacao.RENDIMENTO_FINANCEIRO) {
                rendimento += movimentacaoBancaria.getValor();
            }
        }
        return rendimento * 0.275;
    }

    @Override
    public Double saldoDisponivel() {
        return getSaldo();
    }

}
