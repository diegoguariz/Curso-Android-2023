package diego.guariz.appminhaideiadb.model;

import android.util.Log;

import diego.guariz.appminhaideiadb.api.AppUtil;
import diego.guariz.appminhaideiadb.controller.ICrud;

public class Produto {

    private int id;
    private String nome_produto;
    private String fornecedor;

    public String getNome_produto() {

        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {

        this.nome_produto = nome_produto;
    }

    public String getFornecedor() {

        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {

        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
