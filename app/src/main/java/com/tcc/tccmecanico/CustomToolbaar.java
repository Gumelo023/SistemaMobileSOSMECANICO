package com.tcc.tccmecanico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CustomToolbaar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toolbaar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //Outside Create

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.tela_inicial) {
            Toast.makeText(this, "Tela Inicial", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.feedback_toolbar) {
            Toast.makeText(this, "Faça sua avaliação", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.configurações) {
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.tela_inicial) {
            Toast.makeText(this, "Tela Inicial", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.logout) {
            Toast.makeText(this, "Deslogado", Toast.LENGTH_SHORT).show();

        }

        return true;
    }
}



