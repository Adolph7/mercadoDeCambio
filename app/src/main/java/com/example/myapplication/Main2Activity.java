package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Main2Activity extends AppCompatActivity {

    private TextView txt_v1;
    private RecyclerView rcv;

    private String usuario;

    private String saldo[] = {"Saldo en pesos ", "Saldo en dolares", "Saldo en euro"};
    private String cantidades[] = {"104567", "56780", "3768"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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



