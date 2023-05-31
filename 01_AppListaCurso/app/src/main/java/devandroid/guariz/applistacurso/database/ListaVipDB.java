package devandroid.guariz.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.guariz.applistacurso.model.Pessoa;

public class ListaVipDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "listaVip.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;


    public ListaVipDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // QUERY SQL PARA CRIAR UMA TABELA
        String sqlTabelaPessoa =
                "CREATE TABLE Pessoa (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "primeiroNome TEXT, " +
                        "sobreNome TEXT, " +
                        "cursoDesejado TEXT, " +
                        "telefoneContato TEXT)";

        db.execSQL(sqlTabelaPessoa);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {

        db.insert(tabela, null, dados);
    }

    public List<Pessoa> listarDados() {

        List<Pessoa> lista = new ArrayList<>();

        // Representa um registro que está na tabela Combustivel
        Pessoa registro;

        String querySQL = "SELECT * FROM Pessoa";

        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {
            // True

            do {

                registro = new Pessoa();

                registro.setId(cursor.getInt(0));
                registro.setPrimeiroNome(cursor.getString(1));
                registro.setSobreNome(cursor.getString(2));
                registro.setCursoDesejado(cursor.getString(3));
                registro.setTelefoneContato(cursor.getString(4));

                lista.add(registro);

            } while (cursor.moveToNext());

        } else {
            // False

        }

        return lista;
    }

    public void alterarObjeto(String tabela, ContentValues dados) {

        // ID do registro a ser alterado (PK)
        // update TABLE set campo = novoDados WHERE id = ?

        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id = ?", new String[]{Integer.toString(id)});


    }

    public void deletarObjeto(String tabela, int id) {

        // ID do registro a ser alterado (PK)
        // delete from TABLE WHERE id = ?

        db.delete(tabela, "id = ?", new String[]{Integer.toString(id)});


    }


}
