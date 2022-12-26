package com.note.app.mykotlinproject.retrofitmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.note.app.mykotlinproject.retrofitmvvm.repository.QuoteRepositoryMvvm

class MainViewModelFactory(private val repositoryMvvm: QuoteRepositoryMvvm):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repositoryMvvm ) as T
    }

}