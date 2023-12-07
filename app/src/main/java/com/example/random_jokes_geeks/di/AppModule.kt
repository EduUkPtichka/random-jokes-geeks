package com.example.random_jokes_geeks.di

import com.example.random_jokes_geeks.api_Joker.ApiJokers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun providerApi(): ApiJokers {
        return Retrofit.Builder().baseUrl("https://dad-jokes.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiJokers::class.java)
    }
}