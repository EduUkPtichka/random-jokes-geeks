package com.example.random_jokes_geeks

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.random_jokes_geeks.api_Joker.ApiJokers
import com.example.random_jokes_geeks.api_Joker.ModelRelisJoker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiJokers) {

    fun getJoke(): MutableLiveData<ModelRelisJoker> {

        val list = MutableLiveData<ModelRelisJoker>()

        api.getJoke().enqueue(object : Callback<ModelRelisJoker> {
            override fun onResponse(
                call: Call<ModelRelisJoker>,
                response: Response<ModelRelisJoker>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        list.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<ModelRelisJoker>, t: Throwable) {
                Log.e("lalala", "onFailure: ${t.message}")
            }

        })
        return list
    }
}