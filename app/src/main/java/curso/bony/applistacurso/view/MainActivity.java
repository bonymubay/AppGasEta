package curso.bony.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import curso.bony.applistacurso.R;
import curso.bony.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa= new Pessoa();
        pessoa.setPrimeiroNome("Gerson");
        pessoa.setSobreNome("Orlando");
        pessoa.setCursoDesejado("Curso de Java");
        pessoa.setContacto(843788966);
    }
}