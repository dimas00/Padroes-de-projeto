package br.ufsm.politecnico.csi.pp.parte1.exercicio7;

public class OutraClasse {
    private String chave;
    private String descricao;
    private Integer codigo;

    @JSON
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @JSON
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JSON
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
