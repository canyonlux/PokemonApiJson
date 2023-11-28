package com.example.pokemonapijson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PokemonAdapter.ItemClickListener {

    private RecyclerView recyclerView;
    private PokemonAdapter adapter;
    private List<Pokemon> pokemonList = new ArrayList<>(); // Inicializa la lista

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PokemonAdapter(this, pokemonList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        // Llamar a la API para obtener los datos al iniciar la actividad
        fetchPokemonData();
    }

    private void fetchPokemonData() {
        PokeApiService service = RetrofitClient.getService();
        Call<List<Pokemon>> call = service.getPokemonByName("pikachu"); // Asegúrate de que este método exista y devuelva el tipo correcto

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    pokemonList.clear();
                    pokemonList.addAll(response.body());
                    adapter.notifyDataSetChanged(); // Notificar al adaptador sobre el conjunto de datos cambiado
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                // Manejar el error adecuadamente
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        // Manejar el evento de clic aquí, por ejemplo, abrir la actividad de detalles del Pokémon
        Pokemon selectedPokemon = pokemonList.get(position);
        // Puedes enviar los detalles del Pokémon seleccionado a una nueva actividad o fragmento
    }
}

//Paso 6: Integración de la API con la Interfaz de Usuario
//
//    Implementar la lógica de selección en la lista:
//        En el Adapter, maneja los eventos de clic en cada elemento para mostrar los detalles.
//
//    Mostrar los detalles del Pokémon:
//        Crea una actividad o fragmento que se cargue cuando un elemento de la lista sea seleccionado.
//        Pasa los datos del Pokémon seleccionado a la vista de detalle y muestra la información.