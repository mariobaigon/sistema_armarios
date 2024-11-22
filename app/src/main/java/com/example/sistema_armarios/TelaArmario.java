package com.example.sistema_armarios;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sistema_armarios.DAO.ArmarioDAO;
import com.example.sistema_armarios.models.Armario;

import java.util.ArrayList;
import java.util.List;

public class TelaArmario extends AppCompatActivity {

    EditText cor, chave;
    Button btncad, btnAlterar, btnExcluir;
    ArmarioDAO armarioDAO;
    private ArrayAdapter<String> adapter;
    private List<String> listaArmarios;
    private ListView listViewArmarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_armario);

        cor=findViewById(R.id.edtcorAr);
        chave=findViewById(R.id.edtchave);
        btncad=findViewById(R.id.btncad);
        listViewArmarios=findViewById(R.id.listView2);

        armarioDAO = new ArmarioDAO(this);
        btncad.setOnClickListener(view -> {
            Armario armario = new Armario(cor.getText().toString(), chave.getText().toString());
            armarioDAO.salvar(armario);
            carregarArmarios();
        });
        carregarArmarios();
    }
    private void carregarArmarios() {
        List<Armario> armarios = armarioDAO.listarArmarios();
        listaArmarios = new ArrayList<>();
        for (Armario armario : armarios) {
            listaArmarios.add("Cor: " + armario.getCor() + " - Chave: " +
                    armario.getChave());
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaArmarios);
        listViewArmarios.setAdapter(adapter);
    }
}