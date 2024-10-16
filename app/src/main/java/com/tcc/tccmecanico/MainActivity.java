package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreferences.getString("email", null) != null) {
                    Intent intent = new Intent(MainActivity.this, MenuLateral.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Tela_Inicial.class);
                    startActivity(intent);
                }

                finish();
            }
        }, 2000); // 3000 milissegundos = 3 segundos
    }
}