package com.example.random_jokes_geeks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.random_jokes_geeks.api_Joker.ModelRelisJoker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelLv @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getJoker(): LiveData<ModelRelisJoker> {
        return repository.getJoke()
    }
}
