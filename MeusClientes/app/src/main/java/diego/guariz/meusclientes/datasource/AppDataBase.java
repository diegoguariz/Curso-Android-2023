package diego.guariz.meusclientes.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import diego.guariz.meusclientes.api.AppUtil;
import diego.guariz.meusclientes.datamodel.ClienteDataModel;
import diego.guariz.meusclientes.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "MeusClientes.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;


    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela cliente criada: " + ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
    Método para incluir dados no banco de dados
     */
    public boolean insert(String tabela, ContentValues dados) {
        db = getWritableDatabase();

        boolean retorno = false;

        // Regra de Negócio
        try {
            // O que deve ser realizado
            // Salvar os dados

            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            Log.d(AppUtil.TAG, "insert: " + e.getMessage());
        }

        return retorno;

    }

    // Método para excluir registro do banco de dados
    public boolean deleteByID(String tabela, int id) {
        db = getWritableDatabase();

        boolean retorno = false;

        // Regra de Negócio
        try {
            retorno = db.delete(tabela, "id=?", new String[] {String.valueOf(id)}) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "delete: " + e.getMessage());
        }

        return retorno;

    }

    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();
        boolean retorno = false;

        // Regra de Negócio
        try {
            retorno = db.update(tabela, dados, "id=?", new String[] {String.valueOf(dados.get("id"))}) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "update: " + e.getMessage());
        }

        return retorno;

    }

    @SuppressLint("Range")
    public List<Cliente> listarClientes(String tabela) {

        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();
        Cliente objCli;

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                objCli = new Cliente();

                objCli.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                objCli.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                objCli.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.TELEFONE)));
                objCli.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                objCli.setCep(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.CEP)));
                objCli.setLogradouro(cursor.getString(cursor.getColumnIndex(ClienteDataModel.LOGRADOURO)));
                objCli.setNumero(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NUMERO)));
                objCli.setBairro(cursor.getString(cursor.getColumnIndex(ClienteDataModel.BAIRRO)));
                objCli.setCidade(cursor.getString(cursor.getColumnIndex(ClienteDataModel.CIDADE)));
                objCli.setEstado(cursor.getString(cursor.getColumnIndex(ClienteDataModel.ESTADO)));

                clientes.add(objCli);

                Log.i("Listar", "LIstar AppData: " + objCli.getNome());

            } while (cursor.moveToNext());
        }

        return clientes;

    }

}
