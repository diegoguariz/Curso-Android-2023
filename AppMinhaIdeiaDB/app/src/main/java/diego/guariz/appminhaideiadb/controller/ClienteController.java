package diego.guariz.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import diego.guariz.appminhaideiadb.api.AppUtil;
import diego.guariz.appminhaideiadb.datamodel.ClienteDataModel;
import diego.guariz.appminhaideiadb.datasource.AppDataBase;
import diego.guariz.appminhaideiadb.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;


    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObjeto = new ContentValues();

        // Key, valor

        // dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        // ID é a chave primária da tabela cliente e é gerada a cada
        // novo registro adicionado
        // INSERT INTO TABLE

        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        // Enviar os dados  (dadoDoObjeto) para a classe APPDatabase
        // utilizando um método capaz de adicionar o OBJ no
        // banco de dados, de qualquer tabela (Cliente no caso)


        return insert(ClienteDataModel.TABELA, dadoDoObjeto);

    }


    @Override
    public boolean deletar(int id) {

        return deleteByID(ClienteDataModel.TABELA, id);

    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        return update(ClienteDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public List<Cliente> listar() {

        return listarClientes(ClienteDataModel.TABELA);
    }
}
