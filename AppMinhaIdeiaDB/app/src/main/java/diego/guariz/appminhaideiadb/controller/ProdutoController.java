package diego.guariz.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import diego.guariz.appminhaideiadb.datamodel.ClienteDataModel;
import diego.guariz.appminhaideiadb.datamodel.ProdutoDataModel;
import diego.guariz.appminhaideiadb.datasource.AppDataBase;
import diego.guariz.appminhaideiadb.model.Cliente;
import diego.guariz.appminhaideiadb.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {

        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME_PRODUTO, obj.getNome_produto());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return insert(ProdutoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(ProdutoDataModel.TABELA, id);
    }

    @Override
    public boolean alterar(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID, obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME_PRODUTO, obj.getNome_produto());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return update(ProdutoDataModel.TABELA, dadoDoObjeto);
    }


    @Override
    public List<Produto> listar() {

        return listarProdutos(ProdutoDataModel.TABELA);
    }
}
