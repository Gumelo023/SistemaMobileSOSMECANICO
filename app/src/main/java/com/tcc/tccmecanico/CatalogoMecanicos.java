package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import android.net.Uri;

import com.tcc.tccmecanico.databinding.ActivityCatalogoMecanicosBinding;

import java.util.ArrayList;

public class CatalogoMecanicos extends AppCompatActivity {


    ActivityCatalogoMecanicosBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, sobrenos, mecanicos, perfil, feedback, logout;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogoMecanicosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        int[] imageList = {R.drawable.homemmecanico, R.drawable.homemmecanico, R.drawable.homemmecanico, R.drawable.homemmecanico,R.drawable.homemmecanico, R.drawable.homemmecanico, R.drawable.homemmecanico};
        int[] descList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.JoaoDesc};
        int[] numblist = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Gustavo Melo", "Matheus Santos", "Fawensley Charite", "Joao Paulo", "Robson Alex","Guilherme Xavier", "Luan Santos"};
        String[] localList= {"Barueri", "Osasco", "Carapicuiba","Jandira", "Itapevi", "Sorocaba", "Osasco"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], localList[i], descList[i], numblist[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(CatalogoMecanicos.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> AdapterView, View View, int i, long l) {
                Intent intent = new Intent(CatalogoMecanicos.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("local", localList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("numb", numblist[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });

        drawerLayout = findViewById(R.id.drewerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        mecanicos = findViewById(R.id.mecanicos);
        perfil = findViewById(R.id.perfil);
        feedback = findViewById(R.id.feedback);
        logout = findViewById(R.id.logout);
        sobrenos = findViewById(R.id.sobrenos);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(CatalogoMecanicos.this, MenuLateral.class);

            }
        });
        mecanicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        sobrenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(CatalogoMecanicos.this, SobreNos_Activity.class);
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(CatalogoMecanicos.this,PerfilActivity.class);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(CatalogoMecanicos.this, FeedbackActivity.class);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CatalogoMecanicos.this, "Logout", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Realize a busca com o texto submetido
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Atualize os resultados da busca conforme o texto muda
                listAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            // Ação para o item de pesquisa
            return true;

        }

        return super.onOptionsItemSelected(item);
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