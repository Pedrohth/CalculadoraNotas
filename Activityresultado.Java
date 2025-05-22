package com.pedroh.calcularnotas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView textResultado;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textResultado = findViewById(R.id.textResultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        double media = getIntent().getDoubleExtra("media", 0);
        textResultado.setText("Sua média é: " + String.format("%.2f", media));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Volta para a tela anterior
            }
        });
    }
}
