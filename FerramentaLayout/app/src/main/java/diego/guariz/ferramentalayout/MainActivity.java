package diego.guariz.ferramentalayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // Apresentar Textos
    TextView txtTitulo;

    // Entrada de Dados - Formulários
    EditText editNomeCompleto;

    // Evento do Botão
    Button btnConfirmar;

    ToggleButton tbLigado;

    SwitchCompat swMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        tbLigado = findViewById(R.id.tbLigado);
        swMostrar = findViewById(R.id.swMostrar);

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

        tbLigado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tbLigado.isChecked()) {
                    editNomeCompleto.setEnabled(false);
                } else {
                    editNomeCompleto.setEnabled(true);
                }
            }
        });

        swMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (swMostrar.isChecked()) {

                    txtTitulo.setVisibility(View.GONE);
                } else {

                    txtTitulo.setVisibility(View.VISIBLE);

                    String novoTitulo = txtTitulo.getText().toString().toUpperCase();

                    txtTitulo.setText(novoTitulo);
                }
            }
        });

    }
}