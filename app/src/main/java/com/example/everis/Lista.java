package com.example.everis;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.everis.Hamburguer.*;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ListView listaDeLanche = (ListView) findViewById(R.id.listview);
        List<Hamburguer> lista = HamburguerDAO.chamarlanche();

        final ArrayList<Hamburguer> arrayList = (ArrayList<Hamburguer>) lista;

        ArrayAdapter<Hamburguer> adapter = new ArrayAdapter<Hamburguer>(this, android.R.layout.simple_list_item_1
                , lista);

        listaDeLanche.setAdapter(adapter);

        listaDeLanche.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Detalhes.class);

                intent.putExtra("lanche", arrayList.get(position).id);

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
