package com.example.pokemonapijson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        this.inflater = LayoutInflater.from(context);
        this.pokemonList = pokemonList;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.pokemon_list_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon currentPokemon = pokemonList.get(position);
        holder.bind(currentPokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }


    public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView pokemonName;
        private ImageView pokemonImage;

        public PokemonViewHolder(View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemon_name);
            pokemonImage = itemView.findViewById(R.id.pokemon_image);
            itemView.setOnClickListener(this);
        }

        void bind(Pokemon pokemon) {
            pokemonName.setText(pokemon.getName());

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
