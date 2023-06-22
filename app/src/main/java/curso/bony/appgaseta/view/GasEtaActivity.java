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

import java.text.DecimalFormat;

import curso.bony.appgaseta.R;
import curso.bony.appgaseta.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    DecimalFormat df=new DecimalFormat("#.##");
    EditText editPreco;
    EditText editConsumo;
    EditText editDistancia;

    TextView textResultado;

    Button btnCalcular;
    Button btnLimpar;
    double preco;
    double consumo;
    double distancia;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        editPreco= findViewById(R.id.editPreco);
        editConsumo= findViewById(R.id.editConsumo);
        editDistancia=findViewById(R.id.editDistancia);

        textResultado= findViewById(R.id.textResultado);

        btnCalcular= findViewById(R.id.bntCalcular);
        btnLimpar= findViewById(R.id.btnLimpar);


       String Preco=  editPreco.getText().toString();
        String Distancia = editDistancia.getText().toString();
       String Consumo= editConsumo.getText().toString() ;







        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {

                if(editPreco.getText().toString().isEmpty()||editConsumo.getText().toString().isEmpty()||editDistancia.getText().toString().isEmpty()){
                    textResultado.setText("PRENCHER TODOS OS CAMPOS");
                }else {

                    distancia = Double.parseDouble(editDistancia.getText().toString());
                    consumo = Double.parseDouble(editConsumo.getText().toString());
                    preco = Double.parseDouble(editPreco.getText().toString());

                   //double Resultado = Double.parseDouble(df.format(UtilGasEta.calcularGasto(distancia, consumo, preco)));
                  textResultado.setText(Double.toString(Double.parseDouble(df.format(UtilGasEta.calcularGasto(distancia,consumo,preco)))));

                     editDistancia.setText("");
                     editConsumo.setText("");
                      editPreco.setText("");
                }
            }
        });


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDistancia.setText("");
                editConsumo.setText("");
                editPreco.setText("");
            }
        });

    }
}
