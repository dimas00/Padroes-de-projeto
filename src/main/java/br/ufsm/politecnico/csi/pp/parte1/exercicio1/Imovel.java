package br.ufsm.politecnico.csi.pp.parte1.exercicio1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Imovel implements Forma2D, Forma3D {

    private String identificacao;
    private TipoUso tipoUso;
    private String proprietario;
    private String endereco;
    private List<Comodo> comodos;

    @Override
    public Double calcularArea() {
        Double area = 0.0;
        for (Comodo comodo : comodos) {
            area += comodo.calcularArea();
        }
        return area;
    }

    @Override
    public Double calcularVolume() {
        Double volume = 0.0;
        for (Comodo comodo : comodos) {
            volume += comodo.calcularVolume();
        }
        return volume;
    }


    public enum TipoUso {
        COMERCIAL, RESIDENCIAL
    }
}
