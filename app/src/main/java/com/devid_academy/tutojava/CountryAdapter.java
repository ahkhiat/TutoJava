package com.devid_academy.tutojava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryHolder> {
    private ArrayList<Country> countries;
    private ICountryInteraction iCountryInteraction;

    private RecyclerViewActivity rva;
    public CountryAdapter() {
        super();
        this.countries = new ArrayList<>();
    }

    public void setRva(RecyclerViewActivity rva) {
        this.rva = rva;
    }

    public void setICountryInteraction(ICountryInteraction iCountryInteraction) {
        this.iCountryInteraction = iCountryInteraction;
    }

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_country, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
        Country country = countries.get(position);
        holder.tvItem.setText(country.getName());
//        holder.ivItem.setImageResource(country.getResId());
        if(country.getUrl() != null) {
            Picasso.get()
                    .load(country.getUrl())
                    .placeholder(R.drawable.wallpaper) // image d'attente de chargement, optionnel
//                .error(android.R.color.holo_red_dark)
                    .into(holder.ivItem);
        } else {
            holder.ivItem.setImageResource(country.getResId());
        }


        // méthode 1
//        if(rva != null) {
//            holder.itemLayout.setOnClickListener(v -> rva.makeToast(country.getName()));
//        }

        // méthode 1 bis
//         holder.itemLayout.setOnClickListener(v -> Toast.makeText(holder.itemView.getContext(), country.getName(), Toast.LENGTH_SHORT).show());

        // méthode 2
        // Avec interface OnCountryClickListener
         holder.itemLayout.setOnClickListener(v -> iCountryInteraction.displayCountryName(country));


    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries.clear();
        this.countries.addAll(countries);
    }

    public void addCountry(Country country) {
        countries.add(country);
        notifyItemInserted(countries.size()-1);
    }
}
