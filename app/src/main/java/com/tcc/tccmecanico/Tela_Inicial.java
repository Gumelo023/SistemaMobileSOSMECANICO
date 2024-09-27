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

        CardView card_mecanico = findViewById(R.id.card_mecanico);
        card_mecanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela_Inicial.this, CatalogoMecanicos.class);
                startActivity(intent);

            }


        });

        CardView card_suporte = findViewById(R.id.card_suporte);

        card_suporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela_Inicial.this, Avaliacao.class);
                startActivity(intent);
            }
        });

    }


}