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
    //Produto objProduto;

    // Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: App Minha Ideia Database");

        clienteController = new ClienteController(getApplicationContext());
        produtoController = new ProdutoController(getApplicationContext());

       /* for (int i = 0; i < 49; i++) {
            objCliente = new Cliente();

            objCliente.setNome("Laura Lorenzon Guariz" + i);
            objCliente.setEmail(i + "laura@yahoo.com");

            clienteController.incluir(objCliente);

        }*/

        /*objCliente = new Cliente();
        objProduto = new Produto();

        objCliente.setId(3);
        objCliente.setNome("Laura Lorenzon Guariz");
        objCliente.setEmail("laura@yahoo.com");

        objProduto.setId(3);
        objProduto.setNome_produto("Notebook i7 500Gb SSD");
        objProduto.setFornecedor("Acer");*/

        //clienteController.listar();

        for (Cliente objCli: clienteController.listar())  {

            Log.i("Listar", "Cliente: " + objCli.getId() + " " + objCli.getNome() + " " + objCli.getEmail());

        }

        for (Produto objProd: produtoController.listar())  {

            Log.i("Listar Produtos", "Produto: " + objProd.getId() + " " + objProd.getNome_produto() + " " + objProd.getFornecedor());

        }

        // Alterar o Cliente / Produto
        /*if (clienteController.alterar(objCliente)) {
            Toast.makeText(MainActivity.this, "Cliente " + objCliente.getNome() + " Alterado com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.i(AppUtil.TAG, "onCreate: Cliente " + objCliente.getNome() + " Alterado com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente " + objCliente.getNome() + " não Alterado com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.e(AppUtil.TAG, "onCreate: Cliente " + objCliente.getNome() + " não Alterado com sucesso!");
        }

        // Incluir o Produto
        if (produtoController.alterar(objProduto)) {
            Toast.makeText(MainActivity.this, "Produto " + objProduto.getNome_produto() + " Alterado com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.i(AppUtil.TAG, "onCreate: Produto " + objProduto.getNome_produto() + " Alterado com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Produto " + objProduto.getNome_produto() + " não Alterado com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.e(AppUtil.TAG, "onCreate: Produto " + objProduto.getNome_produto() + " não Alterado com sucesso!");
        }*/


        // Excluir o Cliente
/*
        if (clienteController.deletar(objCliente.getId())) {
            Toast.makeText(MainActivity.this, "Cliente " + objCliente.getNome() + " excluído com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.i(AppUtil.TAG, "onCreate: Cliente " + objCliente.getNome() + " excluído com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Cliente " + objCliente.getNome() + " não excluído com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.e(AppUtil.TAG, "onCreate: Cliente " + objCliente.getNome() + " não excluído com sucesso!");
        }

        // Excluir o Produto
        if (produtoController.deletar(objCliente.getId())) {
            Toast.makeText(MainActivity.this, "Produto " + objProduto.getNome_produto() + " excluído com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.i(AppUtil.TAG, "onCreate: Produto " + objProduto.getNome_produto() + " excluído com sucesso!");
        } else {
            Toast.makeText(MainActivity.this, "Produto " + objProduto.getNome_produto() + " não excluído com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Log.e(AppUtil.TAG, "onCreate: Produto " + objProduto.getNome_produto() + " não excluído com sucesso!");
        }
*/


        // Incluir o Cliente
 /*       if (clienteController.incluir(objCliente)) {
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
        }*/

    }
}