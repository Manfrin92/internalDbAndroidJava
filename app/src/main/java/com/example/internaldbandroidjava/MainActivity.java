package com.example.internaldbandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void mInserir(View view) {
        EditText etNome = findViewById(R.id.etNome);
        EditText etIdade = findViewById(R.id.etIdade);

        String clearName = etNome.getText().toString();
        String clearAge = etIdade.getText().toString();

        if (clearName != null && clearName != "" && clearAge != null && clearAge != "") {
            Pessoa novaPessoa = new Pessoa(etNome.getText().toString(), Integer.parseInt(etIdade.getText().toString()));
            PessoaDAO pessoaDAO = new PessoaDAO(this);
            long id = pessoaDAO.inserir(novaPessoa);

            Toast.makeText(this, "Pessoa salva, id: "+id, Toast.LENGTH_LONG).show();
        }
    }
}