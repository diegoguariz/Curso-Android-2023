package diego.guariz.appminhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {

    // Métodos para persistência de dados no Banco de Dados
    // CRUD - Create Read Update Delete

    // Incluir
    public boolean incluir(T obj);

    // Alterar
    public boolean alterar(T obj);

    // Deletar
    public boolean deletar(int id);

    // Listar
    public List<T> listar();


}
