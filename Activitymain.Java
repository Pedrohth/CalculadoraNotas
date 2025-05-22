package com.pedroh.calcularnotas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editNota1, editPeso1, editNota2, editPeso2;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNota1 = findViewById(R.id.editNota1);
        editPeso1 = findViewById(R.id.editPeso1);
        editNota2 = findViewById(R.id.editNota2);
        editPeso2 = findViewById(R.id.editPeso2);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nota1 = parseDouble(editNota1.getText().toString());
                double peso1 = parseDouble(editPeso1.getText().toString());
                double nota2 = parseDouble(editNota2.getText().toString());
                double peso2 = parseDouble(editPeso2.getText().toString());

                // Se peso não for preenchido, assume 1
                if (peso1 == 0) peso1 = 1;
                if (peso2 == 0) peso2 = 1;

                double media = ((nota1 * peso1) + (nota2 * peso2)) / (peso1 + peso2);

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("media", media);
                startActivity(intent);
            }
        });
    }

    private double parseDouble(String value) {
        if (value.isEmpty()) {
            return 0;
        } else {
            return Double.parseDouble(value);
        }
    }
}
