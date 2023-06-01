package diego.guariz.primeironivelamentojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import javax.security.auth.login.LoginException;

import diego.guariz.primeironivelamentojava.model.Cliente;

public class MainActivity extends AppCompatActivity {

    Cliente objCliente;

    String TAG = "APP_MINHA_IDEIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objCliente = new Cliente("Diego", "teste@teste.com", "16 99712-7092", 43,true);

        Log.i(TAG, "onCreate: objCliente Nome: "+ objCliente.getNome());
        Log.i(TAG, "onCreate: objCliente Email: "+ objCliente.getEmail());
        Log.i(TAG, "onCreate: objCliente Telefone: "+ objCliente.getTelefone());
        Log.i(TAG, "onCreate: objCliente Idade: "+ objCliente.getIdade());
        Log.i(TAG, "onCreate: objCliente Sexo: "+ objCliente.isSexo());
    }
}