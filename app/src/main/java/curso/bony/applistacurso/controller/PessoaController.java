package curso.bony.applistacurso.controller;

import android.content.SharedPreferences;

import curso.bony.applistacurso.model.Pessoa;
import curso.bony.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String nomePreferences="prefeList";

    public PessoaController(MainActivity mainActivity){
        preferences= mainActivity.getSharedPreferences(nomePreferences,0);
        listaVip= preferences.edit();
    }

    public void salvar(Pessoa pessoa){
        listaVip.putString("PrimeiroNome",pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome",pessoa.getSobreNome());
        listaVip.putString("CursoDesejado",pessoa.getCursoDesejado());
        listaVip.putString("contacto",pessoa.getContacto());
        listaVip.apply();

    }

    public void buscar(Pessoa pessoa){
        pessoa.setPrimeiroNome(preferences.getString("PrimeiroNome","NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome","NA"));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado","NA"));
        pessoa.setContacto(preferences.getString("contacto","NA"));
    //return pessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
