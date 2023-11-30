package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText)findViewById(R.id.edt1);
    }

    public void registrar (View view){
        String nombre = edt.getText().toString();


        if (!nombre.equals("")) {
            Toast.makeText(this, "ESTAS REGISTRADO", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("Bienvenido", nombre);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Debes ingresar un nombre valido", Toast.LENGTH_LONG).show();
            edt.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edt,InputMethodManager.SHOW_IMPLICIT);

        }
    }


}