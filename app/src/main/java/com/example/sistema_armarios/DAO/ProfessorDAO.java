package com.example.sistema_armarios.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sistema_armarios.models.DB;
import com.example.sistema_armarios.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private SQLiteDatabase db;

    public ProfessorDAO(Context context) {
        DB dbHelper = new DB(context);
        db = dbHelper.getWritableDatabase();
    }

    public void salvar(Professor professor) {
        ContentValues values = new ContentValues();
        values.put("nome", professor.getNome());
        values.put("matricula", professor.getMatricula());
        values.put("fk_armario", professor.getFk_armario());
        db.insert("professor", null, values);
    }

    public List<Professor> listarProfessores() {
        List<Professor> professores = new ArrayList<>();
        String query = "SELECT * FROM professor";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Professor professor = new Professor();
                professor.setId_prof(cursor.getInt(0));
                professor.setNome(cursor.getString(1));
                professor.setMatricula(cursor.getInt(2));
                professor.setFk_armario(cursor.getInt(3));
                professores.add(professor);
            } while (cursor.moveToNext());
        }
        return professores;
    }


}
