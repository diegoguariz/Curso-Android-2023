package diego.guariz.appminhaideia.controller;

import android.util.Log;

import diego.guariz.appminhaideia.core.AppUtil;

public class ClienteController {

    String versaoApp;

    public ClienteController () {
        this.versaoApp = AppUtil.versaoDoAplicativo();

        Log.i(AppUtil.TAG, "ClienteController: Versão App: " + versaoApp);
    }


}
