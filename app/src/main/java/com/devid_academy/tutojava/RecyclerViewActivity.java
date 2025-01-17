package com.devid_academy.tutojava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements ICountryInteraction {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Australie", R.drawable.australia_flag_small));
        countries.add(new Country("FranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFranceFrance", R.drawable.france_flag_small));
        countries.add(new Country("Chine", R.drawable.china_flag_small));
        countries.add(new Country("Inde", R.drawable.india_flag_small));
        countries.add(new Country("Mexique", R.drawable.mexico_flag_small));
        countries.add(new Country("Tunisie", R.drawable.tunisia_flag_small));


        RecyclerView recyclerView = findViewById(R.id.rv_country);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // méthodes 1 et 1bis
        // recyclerView.setAdapter(new CountryAdapter(countries, this));

        // méthode 2
        CountryAdapter countryAdapter = new CountryAdapter(countries);
        countryAdapter.setRva(this);
        countryAdapter.setICountryInteraction(this);
        recyclerView.setAdapter(countryAdapter);

        Button btnAdd = findViewById(R.id.btn_rva_add_country);
        btnAdd.setOnClickListener(v -> {
            countries.add(
                    new Country("Brazil", "https://cdn.countryflags.com/thumbs/brazil/flag-800.png")
            );
            countryAdapter.notifyItemInserted(countries.size()-1);
            countryAdapter.notifyDataSetChanged();
        });
    }

    public void makeToast(String message ) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayCountryName(Country country) {
        Toast.makeText(this, country.getName(), Toast.LENGTH_SHORT).show();
    }
}