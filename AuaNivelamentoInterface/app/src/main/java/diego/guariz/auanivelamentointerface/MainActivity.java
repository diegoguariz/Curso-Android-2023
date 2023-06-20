package diego.guariz.auanivelamentointerface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Cliente objCliente;
    Produto objProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objCliente = new Cliente();
        objProduto = new Produto();

        objCliente.setNome("Diego");
        objCliente.setEmail("diego@guariz.com.br");

        objProduto.setNome_produto("HD SSD");
        objProduto.setFornecedor("Seagate");

        objCliente.incluir();
        objCliente.alterar();

        objProduto.deletar();
        objProduto.listar();
    }
}