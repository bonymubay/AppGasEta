package curso.bony.appgaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import curso.bony.appgaseta.R;
import curso.bony.appgaseta.controller.CursoController;
import curso.bony.appgaseta.controller.PessoaController;
import curso.bony.appgaseta.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;
    PessoaController controller;
    CursoController cursoController;

    List<String> nomesDosCursos;
    EditText editPrimriroNome;
    EditText editSobrenone;
    EditText editNomeDoCurso;
    EditText editContacto;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);


        controller = new PessoaController(MainActivity.this);
        pessoa = new Pessoa();

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();

        controller.buscar(pessoa);


        editPrimriroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenone = findViewById(R.id.editSobrenone);
        editNomeDoCurso = findViewById(R.id.editNomeDoCurso);
        editContacto = findViewById(R.id.editContacto);
        spinner = findViewById(R.id.spinner);

        //Adapter
        //Layout
        //Injectar adapter ao spinner -> A lista sera gerada

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);


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