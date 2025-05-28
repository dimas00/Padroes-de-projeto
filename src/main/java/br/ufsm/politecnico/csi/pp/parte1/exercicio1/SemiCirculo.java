package br.ufsm.politecnico.csi.pp.parte1.exercicio1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SemiCirculo implements Forma2D {
    private Double raio;
    private Double graus;

    @Override
    public Double calcularArea() {
        return Constantes.PI * Math.pow(raio, 2) * (graus / 360.0);
    }
}
