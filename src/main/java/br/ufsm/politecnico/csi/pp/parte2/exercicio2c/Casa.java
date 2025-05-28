package br.ufsm.politecnico.csi.pp.parte2.exercicio2c;

import lombok.*;


public class Casa implements Cloneable {

    private Long numeroPortasExternas = 2L;
    private Long numeroVagasGaragem = 2L;
    private Long numeroQuartos = 3L;
    private Long numeroSalas = 2L;
    private Long numeroBanheiros = 4L;
    private boolean temPiscina = false;
    private boolean temJardim = false;
    private boolean temParquinho = false;
    private static Casa prototipo = new Casa();

    @SneakyThrows
    public static Casa build() {
        return (Casa) prototipo.clone();
    }

}
