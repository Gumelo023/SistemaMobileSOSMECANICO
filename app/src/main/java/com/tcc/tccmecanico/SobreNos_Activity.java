package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SobreNos_Activity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, sobrenos, mecanicos, perfil, feedback, logout;
    Button btnVoltar; // Declare o botão Voltar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nos);

        drawerLayout = findViewById(R.id.drewerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        mecanicos = findViewById(R.id.mecanicos);
        perfil = findViewById(R.id.perfil);
        feedback = findViewById(R.id.feedback);
        sobrenos = findViewById(R.id.sobrenos);
        logout = findViewById(R.id.logout);
        btnVoltar = findViewById(R.id.button_voltar); // Inicialize o botão Voltar

        menu.setOnClickListener(v -> openDrawer(drawerLayout));
        home.setOnClickListener(v -> redirectActivity(SobreNos_Activity.this, MenuLateral.class));
        mecanicos.setOnClickListener(v -> redirectActivity(SobreNos_Activity.this, CatalogoMecanicos.class));
        perfil.setOnClickListener(v -> redirectActivity(SobreNos_Activity.this, PerfilActivity.class));
        feedback.setOnClickListener(v -> redirectActivity(SobreNos_Activity.this, FeedbackActivity.class));
        sobrenos.setOnClickListener(v -> recreate());
        logout.setOnClickListener(v -> {
            // Adicione lógica de logout aqui
            Toast.makeText(SobreNos_Activity.this, "Logout", Toast.LENGTH_SHORT).show();
        });

        btnVoltar.setOnClickListener(v -> finish()); // Define o evento de clique para o botão Voltar
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void redirectActivity(SobreNos_Activity currentActivity, Class<?> newActivity) {
        Intent intent = new Intent(currentActivity, newActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
