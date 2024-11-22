package com.example.sistema_armarios.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SistemaArmario";
    private static final int DATABASE_VERSION = 1;

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da tabela Armário
        String createTableArmario = "CREATE TABLE armario (" +
                "id_armario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cor TEXT," +
                "chave TEXT UNIQUE);";
        db.execSQL(createTableArmario);

        // Criação da tabela Professor
        String createTableProfessor = "CREATE TABLE professor (" +
                "id_prof INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "matricula INTEGER," +
                "fk_armario INTEGER," +
                "FOREIGN KEY(fk_armario) REFERENCES armario(id_armario));";
        db.execSQL(createTableProfessor);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        // Exclua as tabelas antigas, se necessário, e recrie-as
        db.execSQL("DROP TABLE IF EXISTS armario");
        db.execSQL("DROP TABLE IF EXISTS professor");
        onCreate(db); // Recria as tabelas
    }

}
