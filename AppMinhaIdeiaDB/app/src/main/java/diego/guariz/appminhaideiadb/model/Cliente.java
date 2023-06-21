package diego.guariz.appminhaideiadb.model;

import android.util.Log;

import diego.guariz.appminhaideiadb.api.AppUtil;
import diego.guariz.appminhaideiadb.controller.ICrud;

public class Cliente  {

    private int id; // Chave Primária Auto incremento
    private String nome;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

}
