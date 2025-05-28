package br.ufsm.politecnico.csi.pp.parte1.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimentacaoBancaria {

    private Double valor;
    private TipoMovimentacao tipo;
    private String descricao;

    public enum TipoMovimentacao { CREDITO, DEBITO, RENDIMENTO_FINANCEIRO }

    @Override
    public String toString() {
        return "MovimentacaoBancaria{" +
                "valor=" + valor +
                ", tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
