package com.note.app.mykotlinproject.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.note.app.mykotlinproject.databinding.ActivityMvvmMainBinding

class MvvmMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repoistory = QuoteRepoistory(dao)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repoistory)).get(MainViewModel::class.java)
        mainViewModel.getQuotes().observe(this, Observer {
            binding.quotes=it.toString()
        })
        binding.btnAddQuote.setOnClickListener {
             val quote=Quote(0,"testing implementation ","awais")
            mainViewModel.insertQuote(quote)
        }
    }
}