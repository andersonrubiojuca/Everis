package com.example.everis;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.everis.Hamburguer.Hamburguer;
import com.example.everis.Hamburguer.HamburguerDAO;

import java.text.DecimalFormat;


public class Detalhes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id;
        try {
            id = getIntent().getExtras().getInt("lanche");
        } catch (NullPointerException nullPointerException) {
            id = 0;
        }

        final Hamburguer hamburguer = HamburguerDAO.chamarlanche().get(id);

        Button button = findViewById(R.id.dComprarButton);


        TextView tNome = findViewById(R.id.dNome);
        tNome.append(hamburguer.nome);

        TextView tDescricao = findViewById(R.id.dDescricao);
        tDescricao.append(hamburguer.descricao);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);
        TextView tPreco = findViewById(R.id.dPreco);
        tPreco.append("Preço R$: " + df.format(hamburguer.preco));

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Finalizar.class);

                intent.putExtra("lanche", hamburguer.id);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}