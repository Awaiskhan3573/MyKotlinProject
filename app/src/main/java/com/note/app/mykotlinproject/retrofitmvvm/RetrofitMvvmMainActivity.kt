package com.note.app.mykotlinproject.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.retrofitmvvm.api.QuoteService
import com.note.app.mykotlinproject.retrofitmvvm.api.RetrofitHelper
import com.note.app.mykotlinproject.retrofitmvvm.repository.QuoteRepositoryMvvm
import com.note.app.mykotlinproject.retrofitmvvm.viewmodel.MainViewModel
import com.note.app.mykotlinproject.retrofitmvvm.viewmodel.MainViewModelFactory

class RetrofitMvvmMainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_mvvm_main)

        val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repositoryMvvm=QuoteRepositoryMvvm(quoteService)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repositoryMvvm)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this, Observer {
            Log.d("AWAISKHANDATA",it.results.toString())
        })
    }
}