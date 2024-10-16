package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_Inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        CardView card_fazer_cad = findViewById(R.id.card_fazer_cad);
        card_fazer_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela_Inicial.this, FormCadastro.class);
                startActivity(intent);

            }


        });

        CardView card_login = findViewById(R.id.card_login);
        card_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela_Inicial.this, FormLogin.class);
                startActivity(intent);

            }


        });


    }
}