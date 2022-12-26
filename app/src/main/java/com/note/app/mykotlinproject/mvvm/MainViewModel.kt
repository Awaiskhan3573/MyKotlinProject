package com.note.app.mykotlinproject.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private  val quoteRepoistory: QuoteRepoistory): ViewModel() {
    fun getQuotes():LiveData<List<Quote>>{
        return quoteRepoistory.getQuotes(1)
    }
    fun insertQuote(quote: Quote?){
        viewModelScope.launch(Dispatchers.IO){
            quoteRepoistory.insertQuote(quote)
        }


    }

}