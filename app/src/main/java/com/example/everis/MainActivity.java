package com.example.everis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.everis.Senha.Senha;

public class MainActivity extends AppCompatActivity {

    final Senha senha = new Senha();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.Lbutton);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.LELogin);
                TextView tSenha = (TextView) findViewById(R.id.LESenha);

                senha.setLogin(tLogin.getText().toString());
                senha.setSenha(tSenha.getText().toString());

                if (senha.autenticacao()) {
                    Intent intent = new Intent(getApplicationContext(), Lista.class);

                    startActivity(intent);
                } else {
                    Context contexto = getApplicationContext();

                    Toast toast = Toast.makeText(contexto, "Erro! Verifique seu Loguin e/ou Senha", Toast.LENGTH_SHORT);
                    toast.show();
                    }
                }


            });

        }
    }




