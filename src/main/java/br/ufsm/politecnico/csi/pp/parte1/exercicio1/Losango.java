package br.ufsm.politecnico.csi.pp.parte1.exercicio1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Losango implements Forma2D {
    private Double diagonalMaior;
    private Double diagonalMenor;

    @Override
    public Double calcularArea() {
        return diagonalMaior * diagonalMenor / 2.0;
    }

}
