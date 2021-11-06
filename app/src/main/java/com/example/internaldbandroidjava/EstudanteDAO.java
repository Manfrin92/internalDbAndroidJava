package com.example.internaldbandroidjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EstudanteDAO {
    private Conexao con;
    private SQLiteDatabase db;

    public EstudanteDAO(Context context){
        con = new Conexao(context);
        db = con.getWritableDatabase();
        String sql = "CREATE TABLE IF NOT EXISTS estudante (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, email TEXT, matricula INTEGER);";
        db.execSQL(sql);
    }

    public String inserir(Estudante estudante){
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", estudante.getNome());
        contentValues.put("email", estudante.getEmail());
        contentValues.put("matricula", estudante.getMatricula());

        db.insert("estudante", null, contentValues);

        return "Inserido com sucesso";
    }
}
