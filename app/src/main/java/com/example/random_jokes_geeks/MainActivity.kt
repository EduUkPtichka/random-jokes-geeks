package com.example.random_jokes_geeks

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.random_jokes_geeks.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModelLv by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btApiGetJoke.setOnClickListener {
            viewModel.getJoker().observe(this@MainActivity, Observer { receiving ->
                receiving.body.firstOrNull()?.let { joke ->
                    with(binding) {
                        tvRelis.text = joke.setup
                        tvElaboration.text = joke.punchline
                    }
                }
            })
        }
    }
}
