package com.note.app.mykotlinproject.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val quoteRepoistory: QuoteRepoistory) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return  MainViewModel(quoteRepoistory) as T
    }

}