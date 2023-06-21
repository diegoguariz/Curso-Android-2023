package diego.guariz.appminhaideiadb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import diego.guariz.appminhaideiadb.R;
import diego.guariz.appminhaideiadb.api.AppUtil;
import diego.guariz.appminhaideiadb.controller.ClienteController;
import diego.guariz.appminhaideiadb.controller.ProdutoController;
import diego.guariz.appminhaideiadb.model.Cliente;
import diego.guariz.appminhaideiadb.model.Produto;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    ProdutoController produtoController;
    Cliente objCliente;
    Produto objProduto;

    // Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: App Minha Ideia Database");

        objCliente = new Cliente();
        objProduto = new Produto();

        objCliente.setNome("Diego Guariz");
        objCliente.setEmail("diego@guariz.com.br");

        objProduto.setNome_produto("HD Externo 1Gb");
        objProduto.setFornecedor("Seagate");

        clienteController = new ClienteController(getApplicationContext());
        produtoController = new ProdutoController(getApplicationContext());

        // Incluir o Cliente
        if (clienteController.incluir(objCliente)) {
            Toast.makeText(MainActivity.this, "Cliente " + objCliente.getNome() + " incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.i(AppUtil.TAG, "onCreate: Cliente " + objCliente.getNome() + " incluido com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente " + objCliente.getNome() + " não incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.e(AppUtil.TAG, "onCreate: Cliente " + objCliente.getNome() + " não incluido com sucesso!");
        }

        // Incluir o Produto
        if (produtoController.incluir(objProduto)) {
            Toast.makeText(MainActivity.this, "Produto " + objProduto.getNome_produto() + " incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.i(AppUtil.TAG, "onCreate: Produto " + objProduto.getNome_produto() + " incluido com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Produto " + objProduto.getNome_produto() + " não incluido com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.e(AppUtil.TAG, "onCreate: Produto " + objProduto.getNome_produto() + " não incluido com sucesso!");
        }

    }
}