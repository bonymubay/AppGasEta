package curso.bony.appgaseta.view;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import curso.bony.appgaseta.R;
import curso.bony.appgaseta.apoio.UtilGasEta;
import curso.bony.appgaseta.controller.CombustivelController;
import curso.bony.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {


    EditText editPrecoGasolina;
    EditText editPrecoEtanol;


    TextView textResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnFinalizar;
    Button btnSalvar;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        editPrecoGasolina= findViewById(R.id.editPrecoGasolina);
        editPrecoEtanol= findViewById(R.id.editPrecoEtanol);


        textResultado= findViewById(R.id.textResultado);

        btnCalcular= findViewById(R.id.bntCalcular);
        btnLimpar= findViewById(R.id.btnLimpar);
        btnFinalizar=findViewById(R.id.btnFinalizar);
        btnSalvar=findViewById(R.id.btnSalvar);










        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {

                boolean isOky= true;

                if(editPrecoGasolina.getText().toString().isEmpty()){

                    editPrecoGasolina.setError("* OBRIGATORIO");
                    editPrecoGasolina.requestFocus();
                    isOky= false;
                }
                 if(editPrecoEtanol.getText().toString().isEmpty()){

                    editPrecoEtanol.setError("* OBRIGATORIO");
                    editPrecoEtanol.requestFocus();
                     isOky= false;
                }

                 if(isOky){
                     precoGasolina= Double.parseDouble(editPrecoGasolina.getText().toString());
                     precoEtanol= Double.parseDouble(editPrecoEtanol.getText().toString());

                     recomendacao=UtilGasEta.CalcularMelhorOpcao(precoGasolina,precoEtanol);
                     textResultado.setText(recomendacao);

                     editPrecoEtanol.setText("");
                     editPrecoGasolina.setText("");
                     btnSalvar.setEnabled(true);

                 }else {
                     btnSalvar.setEnabled(false);
                 }
            }
        });


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editPrecoEtanol.setText("");
                editPrecoGasolina.setText("");
                btnSalvar.setEnabled(false);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelGasolina=new Combustivel();
                combustivelEtanol=new Combustivel();
                CombustivelController combustivelController= new CombustivelController(GasEtaActivity.this);

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDeCombustivel(precoGasolina);


                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDeCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.CalcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.CalcularMelhorOpcao(precoGasolina,precoEtanol));

                combustivelController.salvar(combustivelGasolina);
                combustivelController.salvar(combustivelEtanol);
            }
        });

    }
}
