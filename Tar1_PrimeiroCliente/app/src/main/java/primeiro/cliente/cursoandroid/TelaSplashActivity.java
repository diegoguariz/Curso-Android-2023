package primeiro.cliente.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TelaSplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 15; // 15 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        mudarDeTela();
    }

    private void mudarDeTela() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mudarATela = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(mudarATela);
                finish();
            }
        }, tempoDeEspera);
    }
}