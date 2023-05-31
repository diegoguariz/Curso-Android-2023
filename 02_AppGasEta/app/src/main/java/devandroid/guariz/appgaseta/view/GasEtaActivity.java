package devandroid.guariz.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.guariz.appgaseta.R;
import devandroid.guariz.appgaseta.apoio.UtilGasEta;
import devandroid.guariz.appgaseta.controller.CombustivelController;
import devandroid.guariz.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);

        dados =  controller.getListaDeDados();

        Combustivel objAlteracao = dados.get(1);
        objAlteracao.setNomeDoCombustivel("**GASOLINA**");
        objAlteracao.setPrecoDoCombustivel(5.97);
        objAlteracao.setRecomendacao("** Abastecer com Gasolina **");

        //controller.alterar(objAlteracao);

        controller.deletar(21);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("* Obrigatório!");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }

                if(TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatório!");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }

                if(isDadosOk) {
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calculaMelhorOpcao(precoGasolina,precoEtanol);

                    txtResultado.setText(recomendacao);

                    btnSalvar.setEnabled(true);

                } else {
                    Toast.makeText(GasEtaActivity.this, "Por favor, digite os dados obrigatórios!",
                            Toast.LENGTH_LONG).show();

                    btnSalvar.setEnabled(false);
                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editGasolina.setText("");
                editEtanol.setText("");

                btnSalvar.setEnabled(false);

                controller.limpar();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: EditText inputType

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calculaMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calculaMelhorOpcao(precoGasolina, precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);



            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "GasEta Boa Economia!",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Toast.makeText(GasEtaActivity.this, UtilGasEta.calculaMelhorOpcao(5.12, 3.99),
                Toast.LENGTH_LONG).show();

    }
}
