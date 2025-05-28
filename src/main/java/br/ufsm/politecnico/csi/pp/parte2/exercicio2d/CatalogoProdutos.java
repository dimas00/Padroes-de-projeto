package br.ufsm.politecnico.csi.pp.parte2.exercicio2d;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class CatalogoProdutos {

    Map<String, Produto> produtos = new HashMap<>();

    public void adicionarPrototipo(String nome, Produto produto) {
        produtos.put(nome, produto);
    }

    @SneakyThrows
    public Produto clonarProduto(String nome) {
        if (!produtos.containsKey(nome)) {
            throw new Exception("produto nao encontrado");
        }
        return (Produto) produtos.get(nome).clone();
    }

    public static void main(String[] args) {
        CatalogoProdutos c = new CatalogoProdutos();
        Produto notebook = new Produto();
        notebook.setNome("Notebook Gamer");
        notebook.setCategoria("eletrônicos");
        notebook.setPreco(5000.0);
        c.adicionarPrototipo("Notebook Gamer", notebook);

        Produto notebookGamerTopzera = c.clonarProduto("Notebook Gamer");
        notebookGamerTopzera.setPreco(10000.0);
        notebookGamerTopzera.addAtributo("placa de video", "RTX 3060");

    }

}
