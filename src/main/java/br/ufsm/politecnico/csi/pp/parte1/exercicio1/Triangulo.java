package br.ufsm.politecnico.csi.pp.parte1.exercicio1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Triangulo implements Forma2D {

    private Double base;
    private Double altura;

    @Override
    public Double calcularArea() {
        return base*altura/2.0;
    }
}
