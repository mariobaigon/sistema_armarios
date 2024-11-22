package com.example.sistema_armarios;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sistema_armarios.DAO.ArmarioDAO;
import com.example.sistema_armarios.DAO.ProfessorDAO;
import com.example.sistema_armarios.models.Armario;
import com.example.sistema_armarios.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class TelaProfessor extends AppCompatActivity {

    EditText nome, matricula, fk_armario;
    Button btncad, btnAlterar, btnExcluir;
    Spinner spArmario;
    ProfessorDAO professorDAO;
    ArmarioDAO armarioDAO;
    private ArrayAdapter<String> adapter;
    private List<String> listaProfessores;
    private ListView listViewProfessores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_professor);


        nome=findViewById(R.id.edtnome);
        matricula=findViewById(R.id.edtmatricula);
        btncad=findViewById(R.id.btncad2);
        listViewProfessores=findViewById(R.id.listView3);
        spArmario=findViewById(R.id.spArmario);

        professorDAO = new ProfessorDAO(this);
        armarioDAO = new ArmarioDAO(this);

        btncad.setOnClickListener(view -> {

            String var_nome = nome.getText().toString();
            int var_matricula= Integer.parseInt(matricula.getText().toString());
            int fk_armario = (int) spArmario.getSelectedItemId();

            Professor professor = new Professor(var_nome, var_matricula, fk_armario);
            professorDAO.salvar(professor);
            carregarProfessores();
        });
        carregarArmarios();
        carregarProfessores();
    }
    private void carregarArmarios() {
        List<Armario> armarios = armarioDAO.listarArmarios();
        ArrayAdapter<Armario> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, armarios);
        spArmario.setAdapter(adapter);
    }
    private void carregarProfessores() {
        List<Professor> professores = professorDAO.listarProfessores();
        listaProfessores = new ArrayList<>();
        for (Professor professor : professores) {
            listaProfessores.add("Nome: " + professor.getNome() + " - Matricula: " +
                    professor.getMatricula()+ " - Armário: "+professor.getFk_armario());
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaProfessores);
        listViewProfessores.setAdapter(adapter);
    }
}