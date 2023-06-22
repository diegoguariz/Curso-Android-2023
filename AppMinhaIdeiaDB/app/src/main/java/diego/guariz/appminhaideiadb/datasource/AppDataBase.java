package diego.guariz.appminhaideiadb.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import diego.guariz.appminhaideiadb.api.AppUtil;
import diego.guariz.appminhaideiadb.datamodel.ClienteDataModel;
import diego.guariz.appminhaideiadb.datamodel.ProdutoDataModel;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "AppMinhaIdeia.sqlite";
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

        db.execSQL(ProdutoDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela produto criada: " + ProdutoDataModel.criarTabela());

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
}
