package curso.bony.appgaseta.controller;

import android.content.SharedPreferences;

import curso.bony.appgaseta.model.Combustivel;
import curso.bony.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadosPreferencias;
    public static final String nomePreferences="listaCombustiv";

    public CombustivelController(GasEtaActivity activity){
        sharedPreferences=activity.getSharedPreferences(nomePreferences,0);
        dadosPreferencias= sharedPreferences.edit();
    }

    public void salvar(Combustivel object ){
        dadosPreferencias.putString("combustivel", object.getNomeDoCombustivel());
        dadosPreferencias.putFloat("preco", (float) object.getPrecoDeCombustivel());
        dadosPreferencias.putString("recomendacao", object.getRecomendacao());
        dadosPreferencias.apply();
    }

    public void limpar(){
        dadosPreferencias.clear();
        dadosPreferencias.apply();
    }
}
