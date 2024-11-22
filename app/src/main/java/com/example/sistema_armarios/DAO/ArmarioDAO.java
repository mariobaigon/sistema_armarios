package com.example.sistema_armarios.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sistema_armarios.models.Armario;
import com.example.sistema_armarios.models.DB;

import java.util.ArrayList;
import java.util.List;

public class ArmarioDAO {
    private SQLiteDatabase db;

    public ArmarioDAO(Context context) {
        DB dbHelper = new DB(context);
        db = dbHelper.getWritableDatabase();
    }

    public void salvar(Armario armario) {
        ContentValues values = new ContentValues();
        values.put("cor", armario.getCor());
        values.put("chave", armario.getChave());
        db.insert("armario", null, values);
    }

    public List<Armario> listarArmarios() {
        List<Armario> armarios = new ArrayList<>();
        String query = "SELECT * FROM armario";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Armario armario = new Armario();
                armario.setId_armario(cursor.getInt(0));
                armario.setCor(cursor.getString(1));
                armario.setChave(cursor.getString(2));
                armarios.add(armario);
            } while (cursor.moveToNext());
        }
        return armarios;
    }
}
