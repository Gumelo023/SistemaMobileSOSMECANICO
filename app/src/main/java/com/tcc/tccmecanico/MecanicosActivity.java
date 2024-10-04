package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tcc.tccmecanico.databinding.ActivityCatalogoMecanicosBinding;

import java.util.ArrayList;

public class MecanicosActivity extends AppCompatActivity {

    ActivityCatalogoMecanicosBinding binding;

    ListAdapter listAdapter;

    ArrayList<ListData> dataArrayList = new ArrayList<>();

    ListData listData;

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, settings, mecanicos, perfil, feedback, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanicos);

        binding = ActivityCatalogoMecanicosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.foto_gustavo, R.drawable.foto_matheus, R.drawable.foto_wellington, R.drawable.foto_joao, R.drawable.foto_robson, R.drawable.foto_xavier, R.drawable.foto_luan};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Gustavo Melo", "Matheus Santos", "Fawensley Charite", "Joao Paulo", "Robson Alex","Guilherme Xavier", "Luan Santos"};
        String[] localList= {"Barueri", "Osasco", "Carapicuiba","Jandira", "Itapevi", "Sorocaba", "Osasco"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], localList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(MecanicosActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> AdapterView, View View, int i, long l) {
                Intent intent = new Intent(MecanicosActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("local", localList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });


        drawerLayout = findViewById(R.id.drewerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        settings = findViewById(R.id.settings);
        mecanicos = findViewById(R.id.mecanicos);
        perfil = findViewById(R.id.perfil);
        feedback = findViewById(R.id.feedback);
        logout = findViewById(R.id.logout);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MecanicosActivity.this, MenuLateral.class);

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MecanicosActivity.this, SettingsActivity.class);
            }
        });
        mecanicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MecanicosActivity.this,PerfilActivity.class);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MecanicosActivity.this, FeedbackActivity.class);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MecanicosActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}