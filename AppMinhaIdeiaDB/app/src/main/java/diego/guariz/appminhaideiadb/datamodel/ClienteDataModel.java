package diego.guariz.appminhaideiadb.datamodel;

public class ClienteDataModel {

    // Modelo Objeto Relacional

    // Toda Classe Data Model tem esta estrutura

    // 1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    // 2 - Atributos um para um com os nomes dos campos
    public static final String ID = "id"; // no SQLite será integer
    public static final String NOME = "nome"; // no SQLite será text
    public static final String EMAIL = "email"; // no SQLite será text

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // 4 - Método para gerar o Script para criar a tabela
    public static String criarTabela () {

        // Concateação de String
        queryCriarTabela += "CREATE TABLE " + TABELA+ " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += EMAIL + " text ";
        queryCriarTabela += ")";



        return queryCriarTabela;
    }

    // 5 - Queries de consulta gerais

}
