package com.example.random_jokes_geeks.api_Joker

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceRet {

    val retrofit = Retrofit.Builder().baseUrl("https://dad-jokes.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(ApiJokers::class.java)

}