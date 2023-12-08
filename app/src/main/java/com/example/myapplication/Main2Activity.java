package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Main2Activity extends AppCompatActivity {

    private TextView txt_v1;
    private RecyclerView rcv;

    private String usuario;

    private String saldo[] = {"Saldo en pesos ", "Saldo en dolares", "Saldo en euro"};
    private String cantidades[] = {"104567", "56780", "3768"};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent= new Intent(this, Main3Activity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.setTitle("Mercado de cambio");
        Toolbar tool= findViewById(R.id.toolbar_menu);
        setSupportActionBar(tool);

        txt_v1 = findViewById(R.id.textViewMain2);
        rcv = findViewById(R.id.recycler_item);

        usuario = getIntent().getStringExtra("Bienvenido");
        txt_v1.setText("Bienvenido:" + usuario);

        // Create and set up a custom adapter for the RecyclerView
        MyAdapter adapter = new MyAdapter(saldo, cantidades);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        usuario = getIntent().getStringExtra("Bienvenido");
        txt_v1.setText("Bienvenido:" + usuario);
    }


}



