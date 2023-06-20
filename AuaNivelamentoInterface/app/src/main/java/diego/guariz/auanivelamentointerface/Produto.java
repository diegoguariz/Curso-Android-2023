package diego.guariz.auanivelamentointerface;

import android.util.Log;

public class Produto implements ICrud {

    private static final String TAG = "CRUD";

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

    @Override
    public void incluir() {

        Log.i(TAG, "incluir: Produto");

    }

    @Override
    public void alterar() {

        Log.i(TAG, "alterar: Produto");

    }

    @Override
    public void deletar() {

        Log.i(TAG, "deletar: Produto");

    }

    @Override
    public void listar() {

        Log.i(TAG, "listar: Produtos");

    }
}
