package com.example.everis;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.everis.Hamburguer.Hamburguer;
import com.example.everis.Hamburguer.HamburguerDAO;

import java.text.DecimalFormat;

public class Finalizado extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalizado);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);

        Button button = findViewById(R.id.fiButton);

        int id = getIntent().getExtras().getInt("lanche");
        String nome = getIntent().getExtras().getString("nome");
        String pagamento = getIntent().getExtras().getString("pagamento");

        final Hamburguer hamburguer = HamburguerDAO.chamarlanche().get(id);



        TextView textView = findViewById(R.id.fiDetalhes);
        textView.append("Seu pedido está agora fincalizado!" +
                "\nDados da compra:" +
                "\nPedido: " + hamburguer.nome +
                "\nPreço: " +  df.format(hamburguer.preco) +
                "\nForma de Pagamento: " + pagamento +
                "\nNome: " + nome +
                "\nA entrega neste endereço será de " +calculoDeEntrega());

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lista.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }

    //simula uma estimativa do tempo caso existisse o restaurante
    private String calculoDeEntrega(){
        return "15 minutos";
    }

}
