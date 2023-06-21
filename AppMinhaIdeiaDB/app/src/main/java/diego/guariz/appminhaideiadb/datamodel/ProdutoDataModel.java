package diego.guariz.appminhaideiadb.datamodel;

public class ProdutoDataModel {

    public static final String TABELA = "produto";

    public static final String ID = "id";
    public static final String NOME_PRODUTO = "nome_produto";
    public static final String FORNECEDOR = "fornecedor";

    public static String queryCriarTabela = "";

    public static String criarTabela () {

        // Concateação de String
        queryCriarTabela += "CREATE TABLE " + TABELA+ " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME_PRODUTO + " text, ";
        queryCriarTabela += FORNECEDOR + " text ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }
}
