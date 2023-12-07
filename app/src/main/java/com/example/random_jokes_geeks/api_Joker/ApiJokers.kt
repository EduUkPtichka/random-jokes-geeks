package com.example.random_jokes_geeks.api_Joker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

//https://rapidapi.com/KegenGuyll/api/dad-jokes/
//https://dad-jokes.p.rapidapi.com/random/joke

interface ApiJokers {

    @GET("random/joke")
    fun getJoke(
        @Header("X-RapidAPI-Key") key: String = "62046210eamshb1039cc3a834d5ep160059jsn329f9fbbe521",
        @Header("X-RapidAPI-Host") host: String = "dad-jokes.p.rapidapi.com"
    ): Call<ModelRelisJoker>
}