package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feedback_enviado extends AppCompatActivity {

    private Button retornarHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_enviado);

        retornarHome = findViewById(R.id.retornarHome);


        retornarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Feedback_enviado.this, MenuLateral.class);
                startActivity(intent);
                finish(); // Fecha a atividade atual
            }
        });
    }
}

