package br.ufsm.politecnico.csi.pp.parte1.exercicio1;

public class Constantes {

    public static final double PI = Math.PI;
    public static final Formula CALCULO_AREA_TRIANGULO = (x, y) ->  {
        return Math.pow(x, 2) + Math.pow(y, 2);
    };

    public static final Formula CALCULO_AREA_AREA =
            new Formula() {
                @Override
                public double calcula(double x, double y) {
                    return x * y;
                }
            };
}
