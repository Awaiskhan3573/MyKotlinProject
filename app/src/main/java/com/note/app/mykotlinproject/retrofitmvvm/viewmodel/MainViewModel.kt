package com.note.app.mykotlinproject.retrofitmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.note.app.mykotlinproject.mvvm.QuoteRepoistory
import com.note.app.mykotlinproject.retrofitmvvm.models.QuoteList
import com.note.app.mykotlinproject.retrofitmvvm.repository.QuoteRepositoryMvvm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repositoryMvvm: QuoteRepositoryMvvm):ViewModel(){
 init {
     viewModelScope.launch(Dispatchers.IO ){
         repositoryMvvm.getQuotes(1)
     }

 }
    val quotes:LiveData<QuoteList>
    get() = repositoryMvvm.quotes



}