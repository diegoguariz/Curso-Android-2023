package diego.guariz.ferramentalayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Apresentar Textos
    TextView txtTitulo;

    // Entrada de Dados - Formulários
    EditText editNomeCompleto;

    // Evento do Botão
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        txtTitulo.setText("Retrato Principal");

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean dadosOk = true;

                if (TextUtils.isEmpty(editNomeCompleto.getText().toString())) {

                    editNomeCompleto.setError("Digite o Nome Completo por favor...");
                    // Toast.makeText(getBaseContext(), "Digite o Nome Completo por favor... ", Toast.LENGTH_LONG).show();
                    dadosOk = false;
                }

                if (dadosOk) {
                    // Toast
                    Toast.makeText(getBaseContext(), "Você digitou: " + editNomeCompleto.getText(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}