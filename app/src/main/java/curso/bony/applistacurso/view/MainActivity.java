package curso.bony.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import curso.bony.applistacurso.R;
import curso.bony.applistacurso.controller.PessoaController;
import curso.bony.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;
    PessoaController controller;
    EditText editPrimriroNome;
    EditText editSobrenone;
    EditText editNomeDoCurso;
    EditText editContacto;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        controller = new PessoaController(MainActivity.this);
        pessoa = new Pessoa();

        controller.buscar(pessoa);


        editPrimriroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenone = findViewById(R.id.editSobrenone);
        editNomeDoCurso = findViewById(R.id.editNomeDoCurso);
        editContacto = findViewById(R.id.editContacto);

        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);


        editPrimriroNome.setText(pessoa.getPrimeiroNome());
        editSobrenone.setText(pessoa.getSobreNome());
        editNomeDoCurso.setText(pessoa.getCursoDesejado());
        editContacto.setText(pessoa.getContacto());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimriroNome.setText("");
                editSobrenone.setText("");
                editNomeDoCurso.setText("");
                editContacto.setText("");
                controller.limpar();

            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pessoa.setPrimeiroNome(editPrimriroNome.getText().toString());
                pessoa.setSobreNome(editSobrenone.getText().toString());
                pessoa.setCursoDesejado(editNomeDoCurso.getText().toString());
                pessoa.setContacto(editContacto.getText().toString());

                editPrimriroNome.setText("");
                editSobrenone.setText("");
                editNomeDoCurso.setText("");
                editContacto.setText("");
                controller.salvar(pessoa);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Obrigado volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}