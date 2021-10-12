package com.example.internaldbandroidjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PessoaDAO {
    private Conexao con;
    private SQLiteDatabase db;

    public PessoaDAO(Context context) {
        con = new Conexao(context);
        db = con.getWritableDatabase();
    }

    public long inserir(Pessoa pessoa) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", pessoa.getNome());
        contentValues.put("idade", pessoa.getIdade());

        return db.insert("pessoa", null, contentValues);
    }
}
