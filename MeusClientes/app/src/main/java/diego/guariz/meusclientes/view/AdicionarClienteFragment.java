package diego.guariz.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import diego.guariz.meusclientes.R;
import diego.guariz.meusclientes.controller.ClienteController;
import diego.guariz.meusclientes.model.Cliente;

public class AdicionarClienteFragment extends Fragment {

    // Fragment - Classe responsável pela camada de visão (Layout)
    // Declaração GLOBAL de atributos - variáveis globais
    View view;

    TextView txtTitulo;
    EditText editNomeCompleto;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;
    CheckBox chkTermosDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;


    public AdicionarClienteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();

        escutarEventosBosBotoes();

        return view;
    }

    /**
     * Inicializar os componentes da tela/layout
     * para adicionar os clientes
     */
    private void iniciarComponentesDeLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novoCliente);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());

    }

    private void escutarEventosBosBotoes() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                // Validação Nome Completo
                if (TextUtils.isEmpty(editNomeCompleto.getText())) {
                    isDadosOk = false;
                    editNomeCompleto.setError("Digite o Nome Completo...");
                    editNomeCompleto.requestFocus();
                }

                // Validação Telefone
                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDadosOk = false;
                    editTelefone.setError("Digite o Telefone...");
                    editTelefone.requestFocus();
                }

                // Validação E-mail
                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDadosOk = false;
                    editEmail.setError("Digite o E-mail...");
                    editEmail.requestFocus();
                }

                // Validação Cep
                if (TextUtils.isEmpty(editCep.getText())) {
                    isDadosOk = false;
                    editCep.setError("Digite o CEP...");
                    editCep.requestFocus();
                }

                // Validação Logradouro
                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDadosOk = false;
                    editLogradouro.setError("Digite o Logradouro...");
                    editLogradouro.requestFocus();
                }

                // Validação Número
                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDadosOk = false;
                    editNumero.setError("Digite o Número...");
                    editNumero.requestFocus();
                }

                // Validação Bairro
                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDadosOk = false;
                    editBairro.setError("Digite o Bairro...");
                    editBairro.requestFocus();
                }

                // Validação Cidade
                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDadosOk = false;
                    editCidade.setError("Digite a Cidade...");
                    editCidade.requestFocus();
                }

                // Validaão Estado
                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDadosOk = false;
                    editEstado.setError("Digite o Estado...");
                    editEstado.requestFocus();
                }


                if (isDadosOk) {
                    // Popular os dados no objeto Cliente

                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());
                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());

                    clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente", "onClick: Dados Corretos....");
                } else {

                    Log.i("log_add_cliente", "onClick: Dados Incorretos....");
                }
            }
        });
    }
}