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

public class GasEtaActivity extends AppCompatActivity {


    EditText editPrecoGasolina;
    EditText editPrecoEtanol;


    TextView textResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnFinalizar;
    Button btnSalvar;


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
                     double precoGasolina= Double.parseDouble(editPrecoGasolina.getText().toString());
                     double precoEtanol= Double.parseDouble(editPrecoEtanol.getText().toString());

                     textResultado.setText(UtilGasEta.CalcularMelhorOpcao(precoGasolina,precoEtanol));
                     editPrecoEtanol.setText("");
                     editPrecoGasolina.setText("");

                 }
            }
        });


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editPrecoEtanol.setText("");
                editPrecoGasolina.setText("");
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

            }
        });

    }
}
