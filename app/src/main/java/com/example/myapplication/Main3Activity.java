package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.filament.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {

    final static String KEY_PREFS_LAST_PREG = "preg";
    final static String PREFS_CACHE_NAME = "cache";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.cmbiar) {
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
        }else if (item.getItemId()==R.id.info){
           logout();
        }

        return super.onOptionsItemSelected(item);

    }

    private void logout() {}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.setTitle("Mercado de cambio");
        Toolbar tool= findViewById(R.id.toolbar_menu);
        setSupportActionBar(tool);

        SharedPreferences prefs = getSharedPreferences(PREFS_CACHE_NAME, Context.MODE_PRIVATE);
        String preguntar = prefs.getString (KEY_PREFS_LAST_PREG, "");
        EditText edtText= findViewById(R.id.editTextTextDolar);
        edtText.setText(preguntar);



        Button btn = findViewById(R.id.buttonDolar);
        btn.setOnClickListener(v -> {

            String precio= edtText.getText().toString();

            getSharedPreferences("cache", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(KEY_PREFS_LAST_PREG, precio);
            editor.apply();

            String url = "https://api.bluelytics.com.ar/v2/latest";

            OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(url)
                        .build();

            Response response = null;

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        String jsonString = response.body().string();
                        Log.d("JSON", jsonString);

                        JSONObject json = null;

                        String output="";
                        try {
                           JSONObject jso = new JSONObject(jsonString);
                            JSONObject oficial = jso.getJSONObject("oficial");
                            output = String.valueOf(oficial.getDouble("value_avg"));

                        } catch (JSONException e) {
                            output="Error reading data";

                            throw new RuntimeException(e);
                        } catch (Exception e) {
                            output= "Internal erro";
                            //TODO:Manejo de error
                        }finally {

                        }

                        String finalOutput = output;
                        runOnUiThread(() ->{
                            TextView lblout= findViewById(R.id.textViewOut);
                            lblout.setText(finalOutput);
                        });
                    }
                });


        });
    }
    public void logout (View view) {

        finish();
    }


}