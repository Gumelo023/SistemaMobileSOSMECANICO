package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;

import com.tcc.tccmecanico.databinding.ActivityCatalogoMecanicosBinding;

import java.util.ArrayList;

public class CatalogoMecanicos extends AppCompatActivity {

    ActivityCatalogoMecanicosBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCatalogoMecanicosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.baseline_personbranco, R.drawable.maggi, R.drawable.cake, R.drawable.pancake, R.drawable.pizza, R.drawable.burger, R.drawable.fries};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Gustavo Melo", "Matheus Santos", "Fawensley Charite", "Joao Paulo", "Robson Alex","Guilherme Xavier", "Luan Santos"};
        String[] localList= {"Barueri", "Osasco", "Carapicuiba","Jandira", "Itapevi", "Sorocaba", "Osasco"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], localList[i], ingredientList[i], descList[i], imageList[i]);
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
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}