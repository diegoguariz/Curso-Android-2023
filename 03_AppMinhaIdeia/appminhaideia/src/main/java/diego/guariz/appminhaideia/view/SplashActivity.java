package diego.guariz.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import diego.guariz.appminhaideia.R;
import diego.guariz.appminhaideia.controller.ClienteController;
import diego.guariz.appminhaideia.core.AppUtil;
import diego.guariz.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    TextView txtAppVersion;

    int tempoDeEspera = 1000 * 3; // Milisegundos, neste caso, o 3 é para representar 3 segundos

    Cliente objCliente;
    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada....");

        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.versaoDoAplicativo());

        clienteController = new ClienteController();

        trocarTela();

    }

    private void trocarTela() {

        Log.d(AppUtil.TAG, "onCreate: Mudando de tela....");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                objCliente = new Cliente("Diego",
                        "teste@teste.com",
                        "16 99712-7092",
                        43,
                        true);

                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);


    }

}