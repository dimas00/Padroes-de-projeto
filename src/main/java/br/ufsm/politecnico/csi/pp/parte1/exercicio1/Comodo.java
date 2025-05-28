package br.ufsm.politecnico.csi.pp.parte1.exercicio1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comodo implements Forma2D, Forma3D {

    private String identificacao;
    private Double peDireito;
    private Forma2D[] formas;


    @Override
    public Double calcularArea() {
        Double area = 0.0;
        for (Forma2D forma : formas) {
            area += forma.calcularArea();
        }
        return area;
    }

    @Override
    public Double calcularVolume() {
        return calcularArea() * peDireito;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Double getPeDireito() {
        return peDireito;
    }

    public void setPeDireito(Double peDireito) {
        this.peDireito = peDireito;
    }

    public Forma2D[] getFormas() {
        return formas;
    }

    public void setFormas(Forma2D[] formas) {
        this.formas = formas;
    }
}
