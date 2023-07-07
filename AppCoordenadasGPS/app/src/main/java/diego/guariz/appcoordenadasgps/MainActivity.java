package diego.guariz.appcoordenadasgps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtValorLatitude, txtValorLongitude;

    double latitude, longitude;
    boolean gpsAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtxValorLongitude);

        if (gpsAtivo) {

            obterCoordenadas();
        } else {

            latitude = 0.00;
            longitude = 0.00;

            txtValorLatitude.setText(String.valueOf(latitude));
            txtValorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this,
                    "Coordenadas não disponíveis!", Toast.LENGTH_LONG).show();
        }
    }

    private void obterCoordenadas() {

        boolean permissaoAtiva = true;

        if (permissaoAtiva) {

            capturaUltimaLocalizacaoValida();
        } else {
            
            solicitarPermissaoParaObterLocalizacao();
        }
    }

    private void capturaUltimaLocalizacaoValida() {

        latitude = 1.98;
        longitude = -1.67;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));

        Toast.makeText(this,
                "Coordenadas obtidas com sucesso!", Toast.LENGTH_LONG).show();
    }

    private void solicitarPermissaoParaObterLocalizacao() {

        Toast.makeText(this,
                "Aplicativo não tem permissão", Toast.LENGTH_LONG).show();
    }

}