package br.ufsm.politecnico.csi.pp.parte1.exercicio8;

@Validate
public class ExemploValidacao {

    @Min(mensagemErro = "o valor deve ser maior do que 1", minValue = 1)
    @NotNull(mensagemErro = "valor de id não pode ser nulo")
    @Max(mensagemErro = "valor de id não pode ser maior que 10", maxValue = 10)
    private Long id;
    @NotNull(mensagemErro = "o nome não pode ser nulo")
    private String nome;

    public static ExemploValidacao obterExemploValidacao() {
        ExemploValidacao ex = new ExemploValidacao();
        ex.id = 11L;
        ex.nome = "nome";
        return ex;
    }

}
