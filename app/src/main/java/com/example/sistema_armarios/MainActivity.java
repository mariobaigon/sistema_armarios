package com.example.sistema_armarios;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button botaoArmario, botaoProfessores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoArmario = findViewById(R.id.btnarmarios);

        botaoArmario.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TelaArmario.class);
            startActivity(intent);
        });

        botaoProfessores = findViewById(R.id.btnProfessores);

        botaoProfessores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TelaProfessor.class);
            startActivity(intent);
        });
    }
}