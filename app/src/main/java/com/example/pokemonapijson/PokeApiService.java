package com.example.pokemonapijson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiService {

    @GET("pokemon/{id}")
    Call<PokemonResponse> getPokemonById(@Path("id") int pokemonId);

    @GET("pokemon/{name}")
    Call<PokemonResponse> getPokemonByName(@Path("name") String pokemonName);

    // Puedes agregar más métodos si necesitas acceder a más endpoints de la API
}
