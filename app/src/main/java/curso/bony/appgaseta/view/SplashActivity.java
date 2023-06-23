package curso.bony.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import curso.bony.appgaseta.R;
import curso.bony.appgaseta.database.GasEtadb;

public class SplashActivity extends AppCompatActivity {

    public static final int Time=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();
    }

    private void comutarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                GasEtadb gasEtadb= new GasEtadb(SplashActivity.this);
                Intent telaPrincipal= new Intent(SplashActivity.this, GasEtaActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, Time);
    }
}