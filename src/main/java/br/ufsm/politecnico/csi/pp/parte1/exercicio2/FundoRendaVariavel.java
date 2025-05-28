package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder
public class FundoRendaVariavel extends ContaBancaria {

    public FundoRendaVariavel() {
    }

    @Override
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
