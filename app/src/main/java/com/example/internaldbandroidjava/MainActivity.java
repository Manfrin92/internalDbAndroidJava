package com.example.internaldbandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public class MyTask extends AsyncTask<String, String, String>
{

    @Override
    public void onPreExecute()
    {
        //progressDialog = progressDialog.show(MainActivity.this, "Aguarde", "Armazenando", true);
    }

    @Override
    public String doInBackground(String... parametros)
    {
        String nome = parametros[0];
        String email = parametros[1];
        int matricula = Integer.parseInt(parametros[2].toString());

        Estudante estudante = new Estudante(nome, email, matricula);
        EstudanteDAO estudanteDAO = new EstudanteDAO(MainActivity.this);
        String resultado = estudanteDAO.inserir(estudante);

        return resultado;
    }

    @Override
    public void onPostExecute(String retorno)
    {
        //progressDialog.dismiss();
        Toast.makeText(MainActivity.this, retorno, Toast.LENGTH_LONG).show();
    }
}



    public void mInserir(View view) {

            EditText etNome = findViewById(R.id.etNome);
            EditText etEmail = findViewById(R.id.etEmail);
            EditText etMatricula = findViewById(R.id.etMatricula);

            String clearName = etNome.getText().toString();
            String clearEmail = etEmail.getText().toString();
            String clearMatricula = etMatricula.getText().toString();



            if (clearName.length() > 0 && clearEmail .length() > 0 && clearMatricula .length() > 0 && clearMatricula .length() > 0) {
                Toast.makeText(MainActivity.this, clearEmail, Toast.LENGTH_LONG).show();
                MyTask myTask = new MyTask();
                String retorno = myTask.doInBackground(clearName, clearEmail, clearMatricula);
            } else {
                Toast.makeText(MainActivity.this, "Faltam dados", Toast.LENGTH_LONG).show();
            }

    }
}